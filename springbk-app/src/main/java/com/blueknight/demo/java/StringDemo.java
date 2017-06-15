package com.blueknight.demo.java;

/**
 * Created by liuyang on 2017/5/10.
 */
public class StringDemo {
    public static void main(String args[]){
        String str = "boooo:and:foooo";
        String arr[] = str.split("o",-1);
        System.out.println(arr);
        System.out.println("A".compareTo("B")+"======");
    }
}
