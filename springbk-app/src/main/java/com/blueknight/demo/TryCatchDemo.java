package com.blueknight.demo;

/**
 * Created by liuyang on 2018/2/24.
 */
public class TryCatchDemo {
    public int test1(int a){
        try {
            System.out.println(a);
            return a;
        } catch (Exception e) {
            System.out.println("==========");
            return a;
        } finally {
            a++;
        }
    }

    public static void main(String[] args) {
        TryCatchDemo tryDemo = new TryCatchDemo();
        System.out.println(tryDemo.test1(1));

    }
}
