package com.hekai.backend.utils;

import java.util.regex.Pattern;

public class RegexUtil {
    public enum AccountType{
        PHONE_NUMBER,
        EMAIL,
        UN_KNOW
    };
    public static AccountType getAccountType(String account){
        if(isPhoneNumber(account)) {
            return AccountType.PHONE_NUMBER;
        }
        if(isEmail(account)) {
            return AccountType.EMAIL;
        }
        return AccountType.UN_KNOW;
    }
    private static boolean isPhoneNumber(String account){
        String pattern = "(13\\d|14[579]|15[^4\\D]|17[^49\\D]|18\\d)\\d{8}$";
        Pattern p = Pattern.compile(pattern);
        return p.matcher(account).matches();
    }
    private static boolean isEmail(String account){
        String pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern p = Pattern.compile(pattern);
        return p.matcher(account).matches();
    }
}
