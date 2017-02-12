package org.jeecgframework.core.util.base64;

import java.util.Map;

public class MainTest {

	
	static String publicKey;
    static String privateKey;

    static {
        try {
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);
            System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);
        	publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChRk5ev/kLtCvo7QdcSFgEwTgx7mKJsmT83WVkX9J1L5k+MtdALwZtuMUjYSl2AUqtpPIbJXEn3XfI9t18yTTWND99AoBjuvDvCSCjMg7GAIi1Tc5R6k9quD5VjyXKEANxnT5t0427f9ROOEuBmPORFcg0lPJFnfgM4/yfMvPD2QIDAQAB";
        	privateKey="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKFGTl6/+Qu0K+jtB1xIWATBODHuYomyZPzdZWRf0nUvmT4y10AvBm24xSNhKXYBSq2k8hslcSfdd8j23XzJNNY0P30CgGO68O8JIKMyDsYAiLVNzlHqT2q4PlWPJcoQA3GdPm3Tjbt/1E44S4GY85EVyDSU8kWd+Azj/J8y88PZAgMBAAECgYAjvGp9QFi1KTVZpbwtzLIES7RiDAq1rFwIVB61gS4nXWa9i5J63HC2O20ji9IeHecoVxZ2wXMzfDWgyGMH1aXpPtkHt8buM6tCZRyMR/8ARAtEll70bO4leFqcbfMNaovlMJ0IkJpyJdUZFsk6p5/PQ17DukVKs104zNpA0QKOAQJBANsIQLPqhpZQ/8Bigp+67Y2j/PX1Eq/Q2VsnERSUPwWJ0bJe+TSa2Z7oXtDAfCQe1q5hwwqEIibVX4+a8JzcjqECQQC8foPUMouwbXskPDdoj5Dk7Bzm7dKst24ZFDi6dowtHAW69HKnJVJX0i5yHU/VUh8Bk/DVwZMKr86uaLQ0gsI5AkEAk0ASF6J0hru/pHvVq0LFD3MOzd/Lh01VwtUZw4cCc1u7ETqOORJdeVpo29h73OCqnSN2NyyrtQW/r9CPMDWK4QJBALta8UPY3doGaDDTHavzj2zLd8rdttrwFCIfZGeKb7hisxtp4BBdW2RpSLsqgXCiiKkz2F1PZA1qRAA9mGjdU5kCQQChThvnqNeslXLenpHCHsZV7sUylWlF8DyaG1fbhueenLTknjsDE0bJFO4bfsH7Op6nnaNqJR5SODju/1hcjAap";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) throws Exception {  
//        String filepath="d:/tmp/";  
//        RSAEncrypt.genKeyPair(filepath);  
//        System.exit(0);
        String plainText="{\"timestamp\":1484409752002,\"result\":1,\"apiname\":\"BaseController_list\",\"msg\":\"请求成功\",\"key\":\"wcnmdgbingbi123\"}";  
        //公钥加密过程  
        byte[] cipherData=RSAEncrypt.encryptByPublicKey(plainText.getBytes(),publicKey);
        String cipher=Base64Utils.encode(cipherData);  
        //私钥解密过程  
        System.out.println("--------------公钥加密私钥解密过程-------------------");
        byte[] res= RSAEncrypt.decryptByPrivateKey(cipherData, privateKey);
        String restr=new String(res);  
        System.out.println("原文："+plainText);  
        System.out.println("加密："+cipher);  
        System.out.println("解密："+restr);  
        System.out.println();  
          
        
        String s2="G3";
        byte[] b2=s2.getBytes();
        String s3=new String(b2);
        System.out.println(s3);
        
        
        
//        System.out.println("--------------私钥加密公钥解密过程-------------------");  
////        plainText="ihep_私钥加密公钥解密";  
//        //私钥加密过程  
////        cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),plainText.getBytes());
//        
//        cipherData=RSAEncrypt.encryptByPrivateKey(plainText.getBytes(),privateKey);
//        cipher=Base64.encode(cipherData);  
//        //公钥解密过程  
////        res=RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(cipher));  
//        res= RSAEncrypt.decryptByPublicKey(cipherData, publicKey);
//        restr=new String(res);  
//        System.out.println("原文："+plainText);  
//        System.out.println("加密："+cipher);  
//        System.out.println("解密："+restr);  
//        System.out.println();  
          
//        System.out.println("---------------私钥签名过程------------------");  
//        String content="ihep_这是用于签名的原始数据";  
//        String signstr=RSASignature.sign(content,RSAEncrypt.loadPrivateKeyByFile(filepath));  
//        System.out.println("签名原串："+content);  
//        System.out.println("签名串："+signstr);  
//        System.out.println();  
//          
//        System.out.println("---------------公钥校验签名------------------");  
//        System.out.println("签名原串："+content);  
//        System.out.println("签名串："+signstr);  
//          
//        System.out.println("验签结果："+RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));  
//        System.out.println();  
          
    }  
}
