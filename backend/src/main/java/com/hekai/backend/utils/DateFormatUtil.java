package com.hekai.backend.utils;

import java.sql.Time;
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
    public static String formatDateToString(Date date){
        if(date==null){
            return null;
        }
        String pattern="yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
    public static Timestamp formatToTimestamp(String time){
        if(time==null){
            return null;
        }
        String pattern="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        try {
            Date date=simpleDateFormat.parse(time);
            return new Timestamp(date.getTime());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static Timestamp formatToTimestamp(String time, String pattern){
        if(time==null){
            return null;
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        try {
            Date date=simpleDateFormat.parse(time);
            return new Timestamp(date.getTime());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Date formatToDate(String time){
        if(time==null){
            return null;
        }
        String pattern="yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(time);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static Time formatTime(String time){
        if(time==null){
            return null;
        }
        String pattern="HH:mm:ss";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        try {
            Date date=simpleDateFormat.parse(time);
            return new Time(date.getTime());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
