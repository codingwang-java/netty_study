package com.dejavu.netty.io;

import java.io.*;
import java.util.Arrays;

public class BasicIO {
  public static void readFileByte(String path){
    try {
        File file = new File(path);
        InputStream in;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
        while(bufferedReader.readLine()!=null){
            System.out.println(bufferedReader.readLine());
        }
        System.out.println(sb.toString());
    }catch (Exception e){
        System.out.println("读取文件失败");
    }
  }
  public static void writeFileByte(String path){


  }
  public static void printFile(File file){
     File[] files = file.listFiles();
     for(File f:files){
         if(f.isDirectory()){
             printFile(f);
         }else {
             System.out.println(f.getName());
         }
     }

  }
    public static void main(String[] args) {
      //打印所有文件名
        File file = new File("E:");
        //printFile(file);

        String path = "E:\\";
        //readFileByte(path);
        System.out.println(BasicIO.class.getResource("/").getPath());
        System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources");
    }
}
