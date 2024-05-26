package com.example.chatbox.Chat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


    /**
     * Handles communication with a single client in the WebSocket server.
     */
    public class ClientHandler implements Runnable {
        private Socket client;
        private static ArrayList<Socket> clients;
        private DataInputStream in;
        private DataOutputStream out;

        Boolean b=true;
        ArrayList<String>massage;
        FileWriter file;
        public ClientHandler(Socket client, ArrayList<Socket> clients) throws IOException {
            this.clients = clients;
            this.client = client;
            // Initialize input and output streams for communication with the client
            this.in = new DataInputStream(client.getInputStream());
            this.out = new DataOutputStream(client.getOutputStream());

        }


        @Override
        public void run() {
            try {
                File file1=new File("C:\\Users\\Asus\\Desktop\\exercise javafx\\chatBox\\src\\main\\java\\API\\dont-matter-to-me-drake.txt");
                System.out.println(file1.exists());

                String request;
                while (true) {
                    request = this.in.readUTF();

                    if (request != null) {
                        this.file=new FileWriter(file1,true);
                        sendToAll(request);
                        System.out.println("[SERVER] request: " + request);
                        file.append(request+"\n");
                        file.close();
                    }
                }
            } catch (IOException e) {
                System.err.println("IO Exception in client handler!!!!!!");
                e.printStackTrace();
            } finally {
                try {
                    file.close();

                    // Close input and output streams and the client socket when done
                    in.close();
                    out.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



        private void sendToAll(String msg) throws IOException {
            for (Socket aClient : clients) {
                DataOutputStream out = new DataOutputStream(aClient.getOutputStream());
                out.writeUTF(msg);
            }
        }


    }





