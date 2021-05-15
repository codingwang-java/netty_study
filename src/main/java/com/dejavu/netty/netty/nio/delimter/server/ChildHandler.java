package com.dejavu.netty.netty.nio.delimter.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author dejavu
 * @description
 * @create 2021-05-01 15:16
 */
public class ChildHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(io.netty.channel.socket.SocketChannel socketChannel) throws Exception {
        ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());

        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
        socketChannel.pipeline().addLast(new StringDecoder());
        socketChannel.pipeline().addLast(new EchoServerHandler());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
