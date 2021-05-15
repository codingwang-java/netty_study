package com.dejavu.netty.netty.nio.pack.msgpack;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author dejavu
 * @description
 * @create 2021-05-04 01:55
 **/
@Data
@Accessors(chain = true)
public class Student {
    private String name;
    private int age;
    public Student(){

    }
}
