package com.dejavu.netty.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void clientSocket() throws IOException {
        String host="127.0.0.1";
        int port = 4396;
        Socket clientSocket = new Socket(host,port);
        Scanner scanner = new Scanner(System.in);
        OutputStream out = clientSocket.getOutputStream();
        PrintWriter outPrint = new PrintWriter(out,true);
        String str;
        while (scanner.hasNextLine()){
            str = scanner.nextLine();
            outPrint.println(str);
        }
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        clientSocket();
    }
}
