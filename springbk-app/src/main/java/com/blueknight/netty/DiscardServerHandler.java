package com.blueknight.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by liuyang on 2018/1/1.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()){
//                System.out.println((char)in.readByte());
//                System.out.flush();
//                ctx.write("server had recived:"+msg);
//                ctx.flush();
//            }
//        }finally {
//            ReferenceCountUtil.release(msg);
//        }
        ByteBuf b = ctx.alloc().buffer();
        b.writeBytes("aaa\n".getBytes());
        //ctx.pipeline().write(b);
        //ctx.write(msg);
        ctx.write(b);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
