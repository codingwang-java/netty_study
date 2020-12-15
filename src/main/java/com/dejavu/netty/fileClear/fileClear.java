package com.dejavu.netty.fileClear;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class fileClear {
    public static void clearFiles(String path) throws IOException {
        File file = new File(path);
        for(File f:file.listFiles()){
            if(f.isDirectory()){
                clearFiles(f.getAbsolutePath());
            }else if(f.length()>10*1024*1024){
                System.out.println("开始复制文件:"+f.getName());
                FileUtils.copyFileToDirectory(f,new File("G:\\afterProcess"));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        clearFiles("G:\\movie");
    }
}
