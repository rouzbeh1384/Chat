package API;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private  static final int port=3000;

    private static ArrayList<Socket> Clients=new ArrayList<>();

    private static ExecutorService pool = Executors.newFixedThreadPool(8);

    public static void main(){
        ServerSocket lisnert=null;
        System.out.println("[SERVER] Server started. Waiting for client connections...");

        while (true){

        }

    }






}
