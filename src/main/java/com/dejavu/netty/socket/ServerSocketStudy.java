package com.dejavu.netty.socket;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketStudy{
    public static void socketTest()throws Exception{
        ServerSocket serverSocket = new ServerSocket(9527);
        Socket socket = serverSocket.accept();
        System.out.println("连接到socket");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response;
        String request;
        while(true){
            request=in.readLine();
            System.out.println("receive message:"+request);
            if ("Done".equals(request)){
                break;
            }
        }
        serverSocket.close();
        socket.close();
    }

    public static void main(String[] args) throws Exception {
        socketTest();
    }

}
