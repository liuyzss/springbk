package com.blueknight.demo.java;

import java.util.concurrent.TimeUnit;

public class Volatile {

    private static boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
//                    String currentThread = Thread.currentThread().getName();
                    System.out.println(bChanged);
                    if (bChanged) {
                        System.out.println("!=");
                        break;
                    }
                }
            }
        }.start();

        TimeUnit.MILLISECONDS.sleep(10L);

        new Thread() {
            @Override
            public void run() {
                bChanged = true;
                System.out.println(1);
            }
        }.start();

        TimeUnit.MILLISECONDS.sleep(10L);
        System.out.println("main thread ->> " + bChanged);
    }
}