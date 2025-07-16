//package utils;
//
//
//
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.security.SecureRandom;
//
//public class EncryptUtil {
//    public static final String DES = "AES";
//    public static final String CIPHER_ALGORITHM = "AES";
//
//    public  static Key getKey(String strKey){
//        try {
//            if (strKey == null){
//                strKey = "";
//            }
//            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
//            secureRandom.setSeed(strKey.getBytes(StandardCharsets.UTF_8));
//            keyGenerator.init(128,secureRandom);
//            return  keyGenerator.generateKey();
//        }catch (Exception e){
////         throw new Exception("----");
//        }
//        return  null;
//    }
//
//    // 加密逻辑
//    public  static String  encrypt(String data){
//        if (data == null) return null;
//        String encode = null;
//        try{
//            SecureRandom sr = new SecureRandom();
//            Key secureKey = getKey("");
//            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//            cipher.init(cipher.ENCRYPT_MODE,secureKey,sr);
//            byte[] bt = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
//            encode = new BASE64Encoder().encode(bt);
//            return  encode;
//        }catch (Exception e){
//
//        }
//      return  encode;
//    }
//
//    // 加密逻辑
//    public  static String  decrypt(String data){
//        if (data == null) return null;
//        String decode = null;
//        try{
//            SecureRandom sr = new SecureRandom();
//            Key secureKey = getKey("");
//            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//            cipher.init(cipher.DECRYPT_MODE,secureKey,sr);
//            BASE64Decoder base64Decoder = new BASE64Decoder();
//            byte[] res = base64Decoder.decodeBuffer(data);
//            res = cipher.doFinal(res);
//            decode = new String(res);
//            return  decode;
//        }catch (Exception e){
//
//        }
//        return  decode;
//    }
//
//    public static void main(String[] args) {
//        String decrypt = decrypt("tG8QmfWDTxIcuLXh2Vpbng==");
//        System.out.println(decrypt);
//    }
//}
