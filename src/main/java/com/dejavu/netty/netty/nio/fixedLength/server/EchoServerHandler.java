package com.dejavu.netty.netty.nio.fixedLength.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author dejavu
 * @description
 * @create 2021-05-01 15:24
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelHandlerAdapter {
    int count = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;

        System.out.println("This is " + count++ + " times receive client:[ " + body + "]");
        body += "$_";

        ByteBuf byteBuf = Unpooled.copiedBuffer(body.getBytes());

        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
