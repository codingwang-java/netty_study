package com.dejavu.netty.netty.nio.common;

import java.net.InetSocketAddress;

import java.nio.charset.Charset;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyNioServer {
    public void server(int port) throws InterruptedException {
        final ByteBuf  byteBuffer = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("hi", Charset.forName("UTF-8")));
        EventLoopGroup group      = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(group)
                     .channel(NioServerSocketChannel.class)
                     .localAddress(new InetSocketAddress(port))
                     .childHandler(new ChannelInitializer<SocketChannel>() {
                                       protected void initChannel(SocketChannel socketChannel) throws Exception {
                                           socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                                                     @Override
                                                                     public void channelActive(
                                                                             ChannelHandlerContext ctx)
                                                                             throws Exception {
                                                                         ctx.writeAndFlush(byteBuffer.duplicate())
                                                                            .addListener(ChannelFutureListener.CLOSE);
                                                                     }
                                                                 });
                                       }
                                   });

            ChannelFuture channelFuture = bootstrap.bind().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
