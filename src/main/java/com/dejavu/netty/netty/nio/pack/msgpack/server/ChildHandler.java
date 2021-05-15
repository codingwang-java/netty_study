package com.dejavu.netty.netty.nio.pack.msgpack.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author dejavu
 * @description
 * @create 2021-05-01 15:16
 */
public class ChildHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        //socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(20));
        socketChannel.pipeline().addLast("msgpack decoder",new MsgpackDecoder());
        socketChannel.pipeline().addLast("msgpack encoder",new MsgpackEncoder());
        socketChannel.pipeline().addLast(new EchoServerHandler());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
