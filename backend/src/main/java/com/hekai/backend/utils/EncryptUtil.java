package com.hekai.backend.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
    public static String encryptSHA3(String password){
        try {
            MessageDigest sha256=MessageDigest.getInstance("SHA3-256");
            byte[] bytes=sha256.digest(password.getBytes());
            StringBuilder stringBuilder=new StringBuilder();
            for (byte b:bytes){
                stringBuilder.append(String.format("%02x",b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
