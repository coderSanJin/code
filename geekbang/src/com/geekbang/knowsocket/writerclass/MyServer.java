package com.geekbang.knowsocket.writerclass;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyServer {

    public static final int SERVER_PORT = 54321;
    public static final Charset MY_COMM_CHARSET = StandardCharsets.UTF_8;
    public static final String BYE = "bye";

    public static void main(String[] args) {
        commWithClient();
    }

    private static void commWithClient() {

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            Socket ss = serverSocket.accept();
            MyChat chat = new MyChat(ss, "客户端", "你已经连接上服务器了！");
            chat.chatting();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
