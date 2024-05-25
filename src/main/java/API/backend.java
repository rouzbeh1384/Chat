package API;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class backend {


    private static final String SERVER_IP = "127.0.0.1";
    // Port of the server to connect to
    private static final int SERVER_PORT = 3000;
    public front Show;

    public backend() {
        Show = new front();


        Show.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });



        Runnable runnable = () -> {
            DataOutputStream out;
            DataInput in;

            Socket client = null;
            try {
                client = new Socket(SERVER_IP, SERVER_PORT);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            HandleServerResponse handleServerResponse = null;
            try {
                handleServerResponse = new HandleServerResponse(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            new Thread(handleServerResponse).start();
            while (true) {
                try {
//                    System.out.println("1234");
                    action(client);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        };
        Thread thread = new Thread(runnable);
        thread.start();


    }


public void Action3(Socket socket) throws IOException {
    DataOutputStream   out = new DataOutputStream(socket.getOutputStream());

    Show.getDown().setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            try {
                out.writeUTF(getShow().getComboBox().getValue().toString());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    });
}
//    public void Action(Socket socket) throws IOException {
//        DataOutputStream   out = new DataOutputStream(socket.getOutputStream());
//        Show.down.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                try {
//                    out.writeUTF("text");
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//        });
//    }

    public void action(Socket socket) throws IOException {
         DataOutputStream   out = new DataOutputStream(socket.getOutputStream());

        Show.down.setOnAction(event -> {
            try {
                out.writeUTF("String");
            } catch (IOException e) {
                e.printStackTrace();
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
                    System.out.println(this.in.readUTF());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public front getShow(){
    return Show;
    }



}


