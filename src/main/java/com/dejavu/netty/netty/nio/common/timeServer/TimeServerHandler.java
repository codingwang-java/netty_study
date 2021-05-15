package com.dejavu.netty.netty.nio.common.timeServer;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * ��������
 *
 * @ClassName TimeServerHandler
 * @Description TODO
 * @Author DEJAVU
 * @Date 2021/4/11 16:42
 * @Version 1.0
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[]  req     = new byte[byteBuf.readableBytes()];

        byteBuf.readBytes(req);

        String body = new String(req, "UTF-8");

        System.out.println("time server receiver :" + body);

        String  currentTime = "time order".equalsIgnoreCase(body)
                              ? new Date(System.currentTimeMillis()).toString()
                              : "bad order";
        ByteBuf resp        = Unpooled.copiedBuffer(currentTime.getBytes());

        ctx.write(resp);
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
