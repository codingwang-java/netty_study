package com.dejavu.netty.netty.nio.common.timeServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * ��������
 *
 * @ClassName ChildChannelhandler
 * @Description TODO
 * @Author DEJAVU
 * @Date 2021/4/11 16:23
 * @Version 1.0
 */
public class ChildChannelhandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new TimeServerHandler());

        // socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // socketChannel.pipeline().addLast(new StringDecoder());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
