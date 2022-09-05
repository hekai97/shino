package com.hekai.backend.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateFormatUtil {
    public static String formatTime(Timestamp timestamp){
        if(timestamp==null){
            return null;
        }
        String pattern="yyyy-MM-dd HH:mm";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return simpleDateFormat.format(timestamp);
    }
}
