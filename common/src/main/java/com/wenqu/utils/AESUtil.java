package com.wenqu.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.SecretKey;


public class AESUtil {
    /** 密钥长度: 128, 192 or 256 */
    private static final int KEY_SIZE = 128;

    /**
     * 加密/解密算法名称
     */
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    /**
     * 秘钥算法
     */
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 十六位十六进制数作为密钥
     */
    private static final String key = "Wenqu9527~!@#$%^";

    /**
     * 秘钥对象
     */
    private static final SecretKey secKey = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);

    /**
     * 数据加密: 明文 -> 密文
     */
    public static String encrypt(String plainString) throws Exception {
        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 初始化密码器（加密模型）
        cipher.init(Cipher.ENCRYPT_MODE, secKey);
        // 加密数据, 返回密文，使用base64编码密文byte数组，返回密文字符串
        return new String(Base64.encodeBase64(cipher.doFinal(plainString.getBytes("utf-8"))));
    }

    /**
     * 数据解密: 密文 -> 明文
     */
    public static String decrypt(String cipherString) throws Exception {
        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 初始化密码器（解密模型）
        cipher.init(Cipher.DECRYPT_MODE, secKey);
        // 解密数据, 返回明文，对base64编码的密文解码成密文byte数组，再使用AES解码
        byte[] plainBytes = cipher.doFinal(Base64.decodeBase64(cipherString));
        return new String(plainBytes);
    }
}