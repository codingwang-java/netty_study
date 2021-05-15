package com.dejavu.netty.netty.nio.common.timeClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * ��������
 *
 * @ClassName TimeClientHandler
 * @Description TODO
 * @Author DEJAVU
 * @Date 2021/4/11 17:10
 * @Version 1.0
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
    private final ByteBuf msg;

    public TimeClientHandler() {
        byte[] req = "time order".getBytes();

        msg = Unpooled.buffer(req.length);
        msg.writeBytes(req);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(msg);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[]  req     = new byte[byteBuf.readableBytes()];

        byteBuf.readBytes(req);

        String body = new String(req, "UTF-8");

        System.out.println("now is" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
