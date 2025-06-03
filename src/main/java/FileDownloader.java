import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.*;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileDownloader {

    private static final String JSON_FILE_PATH = "D://download.json";       // JSON 文件路径
    private static final String DOWNLOAD_FOLDER = "D://downloads";     // 下载文件夹
    private static final int TIMEOUT = 10_000;                     // 超时时间（毫秒）

    public static void main(String[] args) {
        // 创建下载文件夹
        Path downloadDir = Paths.get(DOWNLOAD_FOLDER);
        try {
            Files.createDirectories(downloadDir);
        } catch (IOException e) {
            System.err.println("创建文件夹失败: " + e.getMessage());
            return;
        }

        // 读取 JSON 文件
        String jsonContent = readFileAsString(JSON_FILE_PATH);
        if (jsonContent == null) {
            return;
        }

        // 解析 JSON 并提取下载链接
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(jsonContent);
            JsonNode dataNode = rootNode.get("data");
            if (dataNode == null) {
                System.err.println("JSON 中缺少 data 节点");
                return;
            }
            JsonNode listNode = dataNode.get("list");
            if (listNode == null || !listNode.isArray()) {
                System.err.println("JSON 中缺少有效的文件列表");
                return;
            }

            // 遍历下载所有文件
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                for (Iterator<JsonNode> iterator = listNode.iterator(); iterator.hasNext();) {
                    JsonNode itemNode = iterator.next();
                    String downloadUrl = itemNode.get("downloadUrl").asText();
                    if (downloadUrl == null || downloadUrl.isEmpty()) {
                        System.err.println("跳过无效条目：缺少 downloadUrl");
                        continue;
                    }

                    // 处理 URL 转义字符（替换 \u0026 为 &）
                    //downloadUrl = downloadUrl.replace("\\u0026", "&");
                    // 解码 URL 中的文件名（如中文）
                    String fileName = decodeFileName(downloadUrl);
                    Path savePath = downloadDir.resolve(fileName);

                    // 检查文件是否已存在
                    if (Files.exists(savePath)) {
                        System.out.println("跳过已存在文件: " + fileName);
                        continue;
                    }

                    // 执行下载
                    downloadFile(httpClient, downloadUrl, savePath);
                }
            }
        } catch (Exception e) {
            System.err.println("JSON 解析或下载失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 从 URL 中提取并解码文件名
     */
    private static String decodeFileName(String url) throws UnsupportedEncodingException {
        String[] parts = url.split("/");
        String fileName = parts[parts.length - 1];
        // 解码 URL 编码的部分（如 %E6%96%87%E4%BB%B6.xlsx）
        String urlStr = URLDecoder.decode(fileName,"UTF-8").replaceAll("\\+", " ");
        String[] split = urlStr.split("\\?");
        return  split[0];
    }

    /**
     * 下载单个文件
     */
    private static void downloadFile(CloseableHttpClient httpClient, String url, Path savePath) {
        try {
            HttpGet request = new HttpGet(URI.create(url));
            request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                if (response.getCode() != 200) {
                    System.err.println("下载失败，状态码: " + response.getCode() + " - " + url);
                    return;
                }

                // 写入文件
                try (InputStream inputStream = response.getEntity().getContent();
                     OutputStream outputStream = Files.newOutputStream(savePath)) {
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("成功下载: " + savePath.getFileName());
            }
        } catch (Exception e) {
            System.err.println("下载失败: " + e.getMessage() + " - " + url);
        }
    }

    /**
     * 读取文件内容为字符串
     */
    private static String readFileAsString(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage());
            return null;
        }
    }
}