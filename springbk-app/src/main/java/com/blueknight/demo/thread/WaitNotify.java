package com.blueknight.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyang on 2018/1/29.
 */
public class WaitNotify {
    volatile static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
        notifyThread.join();
        System.out.println("========end=======");

    }
    static class Wait implements Runnable{
        @Override
        public void run() {
            // lock 枷锁
            synchronized (lock){
                // 当条件不满足，继续wait，同事释放了lock的锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+" flag is true. wait@ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                        System.out.println(Thread.currentThread()+" flag is true. wait end@ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    } catch (InterruptedException e) {
                        System.out.println("wait is interrupted");
                    }
                }
                // flag 为false 完成工作
                System.out.println(Thread.currentThread()+" flag is false. runing@ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                flag = true;
            }

        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            // lock 枷锁
            synchronized(lock){
                // 获取lock锁，然后进行通知，通知时不会释放lock的锁
                System.out.println(Thread.currentThread()+" hold lock. notify@ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //Thread.yield();
            int i=0;
            while (!flag){
                i++;
                System.out.println("hello"+i);
            }
            // 再次加锁
            synchronized(lock){
                System.out.println(Thread.currentThread()+" hold lock again. sleep@ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

            }
        }
    }
}
