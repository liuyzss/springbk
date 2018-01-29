package com.blueknight.demo.thread;

/**
 * 测试多线程上下文切换效率
 * Created by liuyang on 2017/9/6.
 */
public class ThreadContextSwitch {
    private static final long count = 100000000001L;

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(long i = 0;i<count;i++){
                    a += 5;
                }
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(long i = 0;i< 10000;i++){
                    a += 5;
                }
            }
        });

        int b = 0;
        for (long i = 0; i < count ; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency:"+time+"ms,b="+b);
    }

    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i = 0;i<count;i++){
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count ; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:"+time+"ms,b="+b);
    }

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

}
