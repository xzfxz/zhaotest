package com.zhao.dotest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zhao on 2016/4/17.
 */
public class TelnetDotest {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int i=0 ;
        try {
            serverSocket = new ServerSocket(8189);
            while (true){
                try {
                    Socket accept = serverSocket.accept();
                    System.out.println("starting....");
                    Thread thread = new Thread(new SocketServer(accept));
                    thread.start();
                    i++;
                    System.out.println("numbers: "+i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class SocketServer implements Runnable{
    private Socket socket;

    public SocketServer(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Scanner scanner = new Scanner(inputStream);
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                printWriter.println("hello,enter bye to exit");
                boolean flag =false;
                while (!flag&&scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    printWriter.println("echo:"+line);
                    if(line.trim().equals("bye")){
                        flag=true;
                    }
                }
            } finally {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
