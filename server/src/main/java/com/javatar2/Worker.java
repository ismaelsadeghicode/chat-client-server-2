package com.javatar2;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Worker extends Thread {
    private final Socket clientSoket;

    public Worker(Socket clientSoket) {
        this.clientSoket = clientSoket;
    }

    @Override
    public void run() {
        try {
            handleClientSoket();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handleClientSoket() throws IOException, InterruptedException {
        InputStream inputStream = clientSoket.getInputStream();
        OutputStream outputStream = clientSoket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null){
            if("quit".equalsIgnoreCase(line)){
                break;
            }
            String msg = "You typed: " + line + "\n";
            outputStream.write(msg.getBytes());
        }
        clientSoket.close();
    }
}
