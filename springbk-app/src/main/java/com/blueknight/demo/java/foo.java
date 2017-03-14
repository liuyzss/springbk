package com.blueknight.demo.java;

/**
 * Created by liuyang on 2017/3/5.
 */
public class foo {
    public static void main(String sgf[]) {
        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");
        operate(a,b);
        System.out.println(a+"."+b);
    }
    static void operate(StringBuffer x,StringBuffer y) {
        x.append(y);
        y=x;
    }
}
