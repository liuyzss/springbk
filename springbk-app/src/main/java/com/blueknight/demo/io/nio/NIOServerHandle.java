package com.blueknight.demo.io.nio;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by liuyang on 2018/3/19.
 */
public class NIOServerHandle implements Runnable {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean started;

    public NIOServerHandle(int port) {
        try {
            // 创建选择器
            selector = Selector.open();
            // 开开监听通道
            serverSocketChannel = ServerSocketChannel.open();
            //开启非阻塞模式
            serverSocketChannel.configureBlocking(false);
            // 绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            //监听客户端连接请求
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //标记服务器启动
            started = true;

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {

        System.out.println(SelectionKey.OP_READ);
        System.out.println(SelectionKey.OP_WRITE);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_ACCEPT);
        System.out.println(SelectionKey.OP_READ + SelectionKey.OP_WRITE);
    }

    public void stop() {
        started = false;
    }

    @Override
    public void run() {
        while (started) {
            try {
                //无论是否有读写事件发生，selector每隔1s被唤醒一次
                selector.select(1000);
                //阻塞,只有当至少一个注册的事件发生的时候才会继续.
                //selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
