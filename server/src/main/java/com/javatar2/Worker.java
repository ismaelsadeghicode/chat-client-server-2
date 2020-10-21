package com.javatar2;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;

public class Worker extends Thread {
    private final Socket clientSoket;
    private String login =null;

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
        while ((line = reader.readLine()) != null) {
            String[] tokens = StringUtils.split(line);
            if (tokens != null && tokens.length > 0) {
                String cmd = tokens[0];
                if ("quit".equalsIgnoreCase(line)) {
                    break;
                } else if ("login".equalsIgnoreCase(cmd)) {
                    handleLogin(outputStream, tokens);
                }else{
                    String msg = "unknown " + cmd + "\n";
                    outputStream.write(msg.getBytes());
                }
//                String msg = "You typed: " + line + "\n";
//                outputStream.write(msg.getBytes());
            }
        }
        clientSoket.close();
    }

    private void handleLogin(OutputStream outputStream, String[] tokens) throws IOException {
        if(tokens.length == 3){
            String login = tokens[1];
            String password = tokens[2];

            if((login.equals("guest") && password.equals("guest")) || (login.equals("jim") && password.equals("jim"))){ // login jim jim
                String msg = "Ok Login";
                outputStream.write(msg.getBytes());
                this.login = login;
                System.out.println("User logged in succesfully " + login);
            } else {
                String msg = "Error Login";
                outputStream.write(msg.getBytes());
            }

        }
    }
}
