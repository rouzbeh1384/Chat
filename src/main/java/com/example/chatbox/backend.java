package com.example.chatbox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;



public  class backend {


    private front Show;




    String text ;
    private static final String SERVER_IP = "127.0.0.1";
    // Port of the server to connect to
    private static final int SERVER_PORT = 3000;


    public  backend() throws IOException {
        this.Show = new front();
        text = "";

        Runnable runnable = () -> {
            DataOutputStream out;
            DataInput in;

            Socket client = null;
            try {
                client = new Socket(SERVER_IP, SERVER_PORT);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                out = new DataOutputStream(client.getOutputStream());
                in= new DataInputStream(client.getInputStream());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //TODO set lable for connect

            HandleServerResponse handleServerResponse = null;
            try {
                handleServerResponse = new HandleServerResponse(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            new Thread(handleServerResponse).start();

            while (true) {
                Action(out);
//                massage(in);
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();

    }

    private void massage(DataInput in) {
        getShow().getBtnsned().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String s= getShow().getChat().getText();

                text=s;
                try {
                    s+=in.readUTF();
                    getShow().setText("my :"+s+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void Action(DataOutputStream out){
        getShow().getBtnsned().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String s= getShow().getChat().getText();

                text=s;
                try {
                    out.writeUTF(text);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public class HandleServerResponse implements  Runnable {
        private DataInputStream in; // Input stream to receive server responses
        public HandleServerResponse(Socket client) throws IOException {
            this.in = new DataInputStream(client.getInputStream());
        }
        @Override
        public void run() {
            try {
                while(true) {
                    getShow().setText(getShow().getShowText().getText()+"\nServer says:!! " + this.in.readUTF());
                    System.out.println(this.in.readUTF());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public front getShow() {
        return Show;
    }
}