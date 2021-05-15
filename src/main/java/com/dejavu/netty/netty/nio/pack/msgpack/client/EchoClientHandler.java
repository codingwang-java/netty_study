package com.dejavu.netty.netty.nio.pack.msgpack.client;

import com.dejavu.netty.netty.nio.pack.msgpack.Student;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dejavu
 * @description
 * @create 2021-05-01 15:36
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends ChannelHandlerAdapter {
    static final String echo_req = "hi this is client.$_";
    int                 count    = 0;

    public EchoClientHandler() {}

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        List<Student> students = students();

        for(Student s:students){
            ctx.write(s);
        }

        ctx.flush();
        System.out.println("发送消息");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("this is server " + count++ + "times return:" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    protected List<Student> students(){
        int i =0;
        List<Student> students = new ArrayList<>();
        for(;i<9;i++){
            Student student = new Student();
            student.setAge(i).setName("name: TT"+i);
            students.add(student);
        }
        return students;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
