package com.geekbang.knowsocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ShowSocketClass {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        Socket socket = new Socket();
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

    }
}
