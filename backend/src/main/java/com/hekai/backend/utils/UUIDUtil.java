package com.hekai.backend.utils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class UUIDUtil {
    public static String generationOrderNumber(){
        UUID uuid=UUID.randomUUID();
        String s=DateFormatUtil.formatTimeNoSecond(new Timestamp(new Date().getTime()));
        String s1=uuid.toString().replace("-","");
        String s2=s.replace("-","");
        s2=s2.replace(" ","");
        s2=s2.replace(":","");
        return s2+s1;
    }
}
