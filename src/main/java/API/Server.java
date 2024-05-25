package API;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private  static final int port=3000;

    private static ArrayList<Socket> Clients=new ArrayList<>();

    private static ExecutorService pool = Executors.newFixedThreadPool(8);


    public static void main(String [] arg){
        ServerSocket lisnert=null;
//        System.out.println("[SERVER] Server started. Waiting for client connections...");

        while (true){
            try {
            lisnert = new ServerSocket(port);
            System.out.println("[SERVER] Server started. Waiting for client connections...");

            while (true) {
                Socket client = lisnert.accept();
                System.out.println("[SERVER] Connected to client: " + client.getInetAddress());

                ClientHandler clientThread = new ClientHandler(client, Clients);
                Clients.add(client);
                pool.execute(clientThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (lisnert != null) {
                try {
                    lisnert.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            pool.shutdown();
        }
    }
        }

}






