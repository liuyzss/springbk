package com.blueknight.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * User: liuyang
 * Date: 2018/12/18
 * Description:
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        //LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2000));
        //LockSupport.parkNanos(new Object(), TimeUnit.SECONDS.toNanos(2000));
        Thread t = new Thread(()->{
            System.out.println("before park");
            LockSupport.park();
            System.out.println("after park");
        });
        t.start();
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start interrupt");
        System.out.println("t isInterrupt a:"+t.isInterrupted());
        t.interrupt();
        System.out.println("t isInterrupt main c1:"+Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("t isInterrupt main c2:"+Thread.currentThread().isInterrupted());
        try {
            TimeUnit.SECONDS.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t isInterrupt main c3:"+Thread.currentThread().isInterrupted());
        System.out.println("t isInterrupt b:"+t.isInterrupted());
        System.out.println("t isInterrupt b1:"+t.isInterrupted());
        System.out.println("t isInterrupt d:"+t.isInterrupted());
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
