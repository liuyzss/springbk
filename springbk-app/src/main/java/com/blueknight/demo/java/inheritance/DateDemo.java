package com.blueknight.demo.java.inheritance;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by liuyang on 2017/3/27.
 */
public class DateDemo {
    public static void main(String[] args){
        long b = 25 * 24*60*60*1000;
        System.out.println(b);
        long a = System.currentTimeMillis() + 25 * 24*60*60*1000l;
        Timestamp date = new Timestamp(a) ;
        System.out.println(date);
    }
}
