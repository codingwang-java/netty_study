package com.dejavu.netty.netty.nio.pack.msgpack.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author dejavu
 * @description
 * @create 2021-05-01 15:33
 */
public class EchoClient {
    public void connect(int port, String host) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();

            b.group(group)
             .channel(NioSocketChannel.class)
             .option(ChannelOption.TCP_NODELAY, true)
             .handler(new ChannelInitializer<SocketChannel>() {
                          @Override
                          protected void initChannel(SocketChannel socketChannel) throws Exception {
                              //socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, b));
                              socketChannel.pipeline().addLast("msgpack decoder",new MsgpackDecoder());
                              socketChannel.pipeline().addLast("msgpack encoder",new MsgpackEncoder());
                              socketChannel.pipeline().addLast(new EchoClientHandler());
                          }
                      });

            ChannelFuture f = b.connect(host, port).sync();

            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 9527;

        new EchoClient().connect(port, "127.0.0.1");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
