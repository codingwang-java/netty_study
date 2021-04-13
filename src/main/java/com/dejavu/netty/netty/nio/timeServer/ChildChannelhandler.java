package com.dejavu.netty.netty.nio.timeServer;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * 类描述：
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
    }
}
