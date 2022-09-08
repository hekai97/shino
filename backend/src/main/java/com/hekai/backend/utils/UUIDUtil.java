package com.hekai.backend.utils;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class UUIDUtil {
    public static String generationOrderNumber(){
        return generationFileName().substring(0,50);
    }
    public static String generationFileName(){
        UUID uuid=UUID.randomUUID();
        String s=DateFormatUtil.formatTimeFull(new Timestamp(new Date().getTime()));
        String s1=uuid.toString().replace("-","");
        String s2=s.replace("-","").replace(" ","").replace(":","");
        BigInteger bigInteger=new BigInteger(s1,16);
        return s2+ bigInteger;
    }
}
