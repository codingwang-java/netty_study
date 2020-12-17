package com.dejavu.netty.io;

import com.sun.source.tree.SwitchTree;

import java.io.*;
import java.util.Scanner;

public class FileCreateUtils {
    static String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\files\\";
    public static void createFile(){
        InputStream inputStream;
        inputStream = System.in;
        Scanner scanner = new Scanner(System.in);
        System.out.println("print fileName:");
        String fileName = scanner.nextLine();
        try {
            File file = new File(filePath,fileName+".txt");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void printResourceFiles(File file){
        File[] files = file.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                printResourceFiles(f);
            }else {
                System.out.println(f.getName());
            }
        }
    }
    public static void readFile(String fileName,String type){
        String file = filePath+fileName;
        switch (type){
            case "byChar":
                readFileByChar(file);
                break;
            case "byLine":
                readFileByLine(file);
                break;
            default:
                break; 

        }
    }
    public static void readFileByChar(String filename){

    }
    public static void readFileByLine(String filename){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = bufferedReader.readLine())!=null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void  writeFile(String fileName){
        File file = new File(filePath + fileName);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            Scanner scanner = new Scanner(System.in);
            String str;
            while (true){
                if ("exit".equals(str=scanner.nextLine())){
                    break;
                }
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //createFile();
        //readFile("test.txt","byLine");
        writeFile("test.txt");
    }
}
