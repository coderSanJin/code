package com.geekbang.knowsocket.writerclass;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static com.geekbang.knowsocket.writerclass.MyServer.BYE;
import static com.geekbang.knowsocket.writerclass.MyServer.MY_COMM_CHARSET;

public class MyChat {
    private Socket socket;
    private String from;
    private String greeting;

    public MyChat(Socket socket, String from, String greeting) {
        this.socket = socket;
        this.from = from;
        this.greeting = greeting;
    }

    public void chatting() {
        Scanner in = new Scanner(System.in);
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), MY_COMM_CHARSET));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), MY_COMM_CHARSET));
        ){
            if (null != greeting) {
                pw.println(greeting );
                pw.flush();
            }

            while (true) {
                String line = br.readLine();
                if (line.equals(BYE)) {
                    pw.write(BYE);
                    break;
                } else {
                    System.out.println(from + "：" + line);
                    String myWork = in.nextLine();
                    pw.println(myWork);
                    pw.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
