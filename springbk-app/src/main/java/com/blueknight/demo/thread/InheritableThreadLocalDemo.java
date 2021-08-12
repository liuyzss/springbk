package com.blueknight.demo.thread;

/**
 * User: liuyang
 * Date: 2018/12/13
 * Description:
 */
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        InheritableThreadLocal<String> local = new InheritableThreadLocal<String>();
        local.set("ehllo");
        new Thread(()->{
            System.out.println(local.get());
        }).start();
        System.out.println(local.get());
    }
}
