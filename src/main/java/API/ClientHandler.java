package API;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Handles communication with a single client in the WebSocket server.
 */
public class ClientHandler implements Runnable {
    private Socket client;
    private static ArrayList<Socket> clients;
    private DataInputStream in;
    private DataOutputStream out;

    ArrayList<String>massage;

    public ClientHandler(Socket client, ArrayList<Socket> clients) throws IOException {
        this.clients = clients;
        this.client = client;
        massage=new ArrayList<>();
        // Initialize input and output streams for communication with the client
        this.in = new DataInputStream(client.getInputStream());
        this.out = new DataOutputStream(client.getOutputStream());
    }


    @Override
    public void run() {
        try {
            String request;
            while (true) {
                request = this.in.readUTF();
                File  file=new File("C:\\Users\\Asus\\Desktop\\exercise javafx\\chatBox\\data\\"+request);
                Scanner scanner=new Scanner(file);
                while (scanner.hasNext()){
                    System.out.println(scanner.nextLine());
                    out.writeUTF(scanner.nextLine());
                }
            }
        } catch (IOException e) {
            System.err.println("IO Exception in client handler!!!!!!");
            e.printStackTrace();
        } finally {
            try {
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





