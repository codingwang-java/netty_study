package com.dejavu.netty.netty.nio.pack.msgpack.server;

import com.dejavu.netty.netty.nio.pack.msgpack.Student;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dejavu
 * @description
 * @create 2021-05-01 15:24
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelHandlerAdapter {
    int count = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("server receive msg: "+msg);

        ctx.write(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        List<Student> students = students();
        for(Student s:students){
            ctx.write(s);
        }
        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    protected List students(){
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
