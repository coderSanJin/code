package com.geekbang.knowsocket.writerclass;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import static com.geekbang.knowsocket.writerclass.MyServer.SERVER_PORT;

public class MyClient {

    public static void main(String[] args) {
        commWithServe();
    }

    private static void commWithServe() {
        try {
            Socket socket = new Socket("localhost", SERVER_PORT);
            MyChat chat = new MyChat(socket, "服务端", null);
            chat.chatting();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
