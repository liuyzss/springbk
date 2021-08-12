package com.blueknight.demo.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by liuyang on 2018/4/8.
 */
public class NIOClientHandle implements Runnable {
    private String host;
    private Integer port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean started;

    public NIOClientHandle(String host, Integer port) {
        this.host = host;
        this.port = port;

        try {
            this.selector = Selector.open();
            this.socketChannel = SocketChannel.open();
            this.socketChannel.configureBlocking(false);
            this.started = true;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        started = false;
    }

    @Override
    public void run() {

        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (started){
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();

                    handleInput(key);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if(!key.isValid())return;
        SocketChannel sc = (SocketChannel) key.channel();
        if(key.isConnectable()){
            if(sc.finishConnect());
            else System.exit(1);
        }
        if(key.isReadable()){
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int length = sc.read(byteBuffer);
            if(length>0){
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                String msg = new String(bytes,"UTF-8");
                System.out.println("client received msg:"+msg);
            }else {
                key.cancel();
                sc.close();
            }
        }

    }

    private void doConnect() throws IOException {
        if(this.socketChannel.connect(new InetSocketAddress(this.host,this.port)));
        else socketChannel.register(selector, SelectionKey.OP_CONNECT);
        System.out.println("ok");
    }

    public  void sendMsg(String msg) throws IOException {
        socketChannel.register(selector, SelectionKey.OP_READ);
        doWrite(socketChannel,msg);

    }

    private void doWrite(SocketChannel socketChannel, String msg) throws IOException {
        byte[] bytes = msg.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        socketChannel.write(buffer);
    }
}
