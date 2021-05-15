package com.dejavu.netty.socket.newIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @author dejavu
 * @description
 * @create 2021-03-28 13:05
 **/
public class NIOsocket {
    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedList<SocketChannel> clients = new LinkedList<SocketChannel>();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9090));
        serverSocketChannel.configureBlocking(false);//操作系统的nonblocking
        while(true){
            //接受连接
            Thread.sleep(1000);
            SocketChannel client = serverSocketChannel.accept();//NIO(linux)如果来了连接就返回客户端的fd 不来就返回null(-1)
            //不会阻塞
            if(client == null){
                System.out.println("null....\n");
            }else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client port:"+port);
                clients.add(client);
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
            for(SocketChannel c:clients){
                int num = c.read(byteBuffer);
                if(num>0){
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.limit()];
                    byteBuffer.get(bytes);
                    String b = new String(bytes);
                    System.out.println(c.socket().getPort()+":"+b);
                    byteBuffer.clear();
                }
            }
        }
    }
}
