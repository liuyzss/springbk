package com.blueknight.demo.io.nio;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by liuyang on 2018/4/8.
 */
public class NIODemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        NIOServer.start();
        Thread.sleep(100);
        NIOClient.start();
        while(NIOClient.sendMsg(new Scanner(System.in).nextLine()));
    }
}
