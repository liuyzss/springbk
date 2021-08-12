package com.blueknight.demo.io.nio;

/**
 * Created by liuyang on 2018/3/19.
 */
public class NIOServer {
    private static final Integer DEFAULT_PROT = 9901;
    private static NIOServerHandle nioServerHandle;

    public static void start() {
        start(DEFAULT_PROT);
    }

    public static synchronized void start(int port) {
        if (null != nioServerHandle) {
            nioServerHandle.stop();
        }
        nioServerHandle = new NIOServerHandle(port);
        Thread server = new Thread(nioServerHandle);
        server.start();
    }

    public static void main(String[] args) {
        start();
    }
}
