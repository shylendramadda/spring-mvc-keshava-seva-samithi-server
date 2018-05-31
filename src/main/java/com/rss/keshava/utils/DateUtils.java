package com.rss.keshava.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static  String  DEFAULT_FORMAT  = "YYYY-MM-DD HH:MM:SS";

    public static String getDate1(long time, String dateFormat){

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        date.setTime(time);
        return  format.format(date);

    }
}
