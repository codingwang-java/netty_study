package com.dejavu.netty.netty.nio.fixedLength.client;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author dejavu
 * @description
 * @create 2021-05-01 15:36
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends ChannelHandlerAdapter {
    static final String echo_req = "hi this is client.$_";
    int                 count    = 0;

    public EchoClientHandler() {}

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 20; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(echo_req.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("this is server " + count++ + "times return:" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
