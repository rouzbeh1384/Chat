package com.example.chatbox.Chat;


import com.example.chatbox.Chat.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * WebSocket server implementation.
 */
public class server {
    private static final int PORT = 3000;

    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(8);

    public static void main(String[] args) {
        ServerSocket listener = null;
        try {
            listener = new ServerSocket(PORT);
            System.out.println("[SERVER] Server started. Waiting for client connections...");

            while (true) {
                Socket client = listener.accept();
                System.out.println("[SERVER] Connected to client: " + client.getInetAddress());

                ClientHandler clientThread = new ClientHandler(client, clients);
                clients.add(client);
                pool.execute(clientThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (listener != null) {
                try {
                    listener.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            pool.shutdown();
        }
    }
}