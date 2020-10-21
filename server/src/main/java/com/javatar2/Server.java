package com.javatar2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {
    private final int serverPort;
    private ArrayList<ServerWorker> workerList = new ArrayList<ServerWorker>();

    public List<ServerWorker> getServerWorkers(){
        return workerList;
    }

    public Server(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while (true) {
                System.out.println("About to accept client connection...");
                final Socket clientSoket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSoket);
                ServerWorker serverWorker = new ServerWorker(this, clientSoket);
                serverWorker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeWorker(ServerWorker serverWorker) {
        workerList.remove(serverWorker);
    }
}
