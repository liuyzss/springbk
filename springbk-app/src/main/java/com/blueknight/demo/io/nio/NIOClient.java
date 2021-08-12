package com.blueknight.demo.io.nio;

import java.io.IOException;

/**
 * Created by liuyang on 2018/4/8.
 */
public class NIOClient {
    private static String DEFAULT_HOST = "127.0.0.1";
    private static Integer DEFAULT_PORT = 9901;
    private static NIOClientHandle nioClientHandle;

    public static void start() {
        start(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static void start(String host, Integer port) {
        if (null != nioClientHandle) nioClientHandle.stop();
        nioClientHandle = new NIOClientHandle(host, port);
        Thread thread = new Thread(nioClientHandle);
        thread.start();
    }

    public static boolean sendMsg(String msg) throws IOException {
        if (msg.equals("q")) return false;
        nioClientHandle.sendMsg(msg);
        return true;
    }

    public static void main(String[] args) {
        NIOClient.start();
    }
}
