package com.javatar2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        int port = 8060;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("About to accept client connection...");
                final Socket clientSoket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSoket);
                Worker worker = new Worker(clientSoket);
                worker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
