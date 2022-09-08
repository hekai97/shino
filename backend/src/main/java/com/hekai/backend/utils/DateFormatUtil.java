package com.hekai.backend.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    public static String formatTimeNoSecond(Timestamp timestamp){
        if(timestamp==null){
            return null;
        }
        String pattern="yyyy-MM-dd HH:mm";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return simpleDateFormat.format(timestamp);
    }
    public static String formatTimeFull(Timestamp timestamp){
        if(timestamp==null){
            return null;
        }
        String pattern="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return simpleDateFormat.format(timestamp);
    }
    public static String formatDate(Date date){
        if(date==null){
            return null;
        }
        String pattern="yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

}
