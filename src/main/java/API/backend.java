package API;

import API.front;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

import java.io.*;
import java.net.Socket;



public  class backend {


    private front Show;




    String text ;
    private static final String SERVER_IP = "127.0.0.1";
    // Port of the server to connect to
    private static final int SERVER_PORT = 3000;
    String name ;

    public  backend(String name) throws IOException {

        this.name=name;
        this.Show = new front();
        text = "";
        Show.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        Runnable runnable = () -> {
//            DataOutputStream out;
//            DataInput in;

            Socket client = null;
            try {
                client = new Socket(SERVER_IP, SERVER_PORT);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



            HandleServerResponse handleServerResponse1 = null;
            try {
                handleServerResponse1 = new HandleServerResponse(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            new Thread(handleServerResponse1).start();
            while (true) {
                try {
                    Action(client);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        };
        Thread thread=new Thread(runnable);
        thread.start();

    }



    public void Action(Socket socket) throws IOException {
        DataOutputStream   out = new DataOutputStream(socket.getOutputStream());
        getShow().getDown().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    System.out.println( Show.getComboBox().getValue().toString());
                    out.writeUTF(Show.getComboBox().getValue().toString());
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
                System.out.println("asdasdadasd");

                    while (true) {
                        String s = this.in.readUTF();
//                        File file1=new File("C:\\Users\\Asus\\Desktop\\exercise javafx\\chatBox\\src\\main\\java\\API");
                        FileWriter file=new FileWriter(Show.getPathtet().getText());

                        System.out.println(s);
                        System.out.println(s);
                        file.append(s+"\n");
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