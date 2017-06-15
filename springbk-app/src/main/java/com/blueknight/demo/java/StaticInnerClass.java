package com.blueknight.demo.java;

/**
 * Created by liuyang on 2017/3/20.
 */
public class StaticInnerClass {
    public static class InnerClass{
        static {
            System.out.println(" static HELLO");
        }
        private static String hi = "123" ;
        public static void say(){
            System.out.println("say");
        }
    }

    public static void main(String args[]){
        System.out.println("HELLO");
        InnerClass.say();
    }
}
