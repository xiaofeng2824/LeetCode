package test;

//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CommonFunctionProvider
 *
 * @Description: 测试数据提供，解析json数据
 *
 * @Author chenrongjun
 *
 * @Date 2021-09-17
 *
 * @Version 1.0
 *
 */
//@Slf4j
public class CommonFunctionProvider {
    /*
     * @Description：将data存入到filePath中
     * @filePath: 文件地址
     */
    public static void savedata(String filePath,String data) {
        try {
            OutputStreamWriter os = null;
            FileOutputStream fos = null;
            OutputStreamWriter osw=null;
            // data/inventory/TestCommandInbound/TestCommandInbound.txt
            File file=new File(filePath);
            fos=new FileOutputStream(file);//定义输出文件
            osw=new OutputStreamWriter(fos);//写入输入文件
            BufferedWriter bWriter=new BufferedWriter(osw);//写入缓存区
            bWriter.write(data);
            bWriter.close();//关闭写入缓存区
            osw.close();//关闭写入文件内容
            fos.close();//关闭写入文件
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public  JSONObject getDataFromFile(String filePath) {
//        try {
//
//            FileInputStream fos = null;
//            InputStreamReader isr=null;
//            // data/inventory/TestCommandInbound/TestCommandInbound.txt
//            File file=new File(filePath);
//            fos=new FileInputStream(file);//定义输出文件
//            isr=new InputStreamReader(fos);//写入输入文件
//            BufferedReader bReader=new BufferedReader(isr);
//            JSONObject jsonObject=null;
//            String data=null;
//            while (( data=bReader.readLine()) != null) {
//                 jsonObject=JSONObject.parseObject(data);
//            }
//
//            bReader.close();//关闭写入缓存区
//            isr.close();//关闭写入文件内容
//            fos.close();//关闭写入文件
//            return jsonObject;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
////        try {
////            JSONObject json = new JSONObject();
////            Resource resource = new ClassPathResource(filePath);
////            InputStream is = resource.getInputStream();
////            InputStreamReader isr = new InputStreamReader(is);
////            BufferedReader br = new BufferedReader(isr);
////            String data = null;
////            //首行为字段名
////            while ((data = br.readLine()) != null) {
////                json=JSONObject.parseObject(data);
////            }
////            br.close();
////            is.close();
////            isr.close();
////            return json;
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return null;
//
//    }

    public static List connectDBQuery(String user,String password,String connectURL,String sql){
        String driver="com.mysql.jdbc.Driver";
        List result=new ArrayList();
//        String user="yh_dev";
//        String password="DvpJe2x";
//        String url="jdbc:mysql://10.251.77.188:3306/order_fulfillment_center";
        try {
            //加载数据库驱动
            Class.forName(driver);
            //连接数据库
            Connection conn = DriverManager.getConnection(connectURL, user, password);
            System.out.println("连接成功!");
            //创建Statement对象
            Statement stmt = conn.createStatement();
            //建立结果集
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("查询成功!");
            while (rs.next()) {
                result.add(rs.toString());
                System.out.println(rs.getString(1) + " " + rs.getString("username"));
            }
            //关闭结果集
            rs.close();
            //关闭Statement对象
            stmt.close();
            //关闭数据库
            conn.close();
            return result;
        }catch (Exception e){

            e.printStackTrace();
            return null;
        }
    }
}
