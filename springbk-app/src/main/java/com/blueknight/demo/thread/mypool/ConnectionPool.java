package com.blueknight.demo.thread.mypool;

import java.util.LinkedList;

/**
 * Created by liuyang on 2018/1/30.
 */

public class ConnectionPool {
    private LinkedList<Integer> pool = new LinkedList<Integer>();
    private Integer getValue() throws InterruptedException {
        pool.wait();
        return 12;
    }

    public static void main(String[] args) {
        ConnectionPool conPool = new ConnectionPool();
        try {
            System.out.println(conPool.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("++++++");
        }finally {
            System.out.println("=====");
        }
    }
}