package com.javatar2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerApp {
    public static void main(String[] args) {
        int port = 8060;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("About to accept client connection...");
                Socket clientSoket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSoket);
                OutputStream outputStream = clientSoket.getOutputStream();
                for (int i = 0; i < 10; i++) {
                    outputStream.write(("Time now is" + new Date() + "\n").getBytes());
                    Thread.sleep(1000);
                }
                clientSoket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
