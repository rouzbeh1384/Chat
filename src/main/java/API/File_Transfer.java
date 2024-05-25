package API;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class File_Transfer extends Application {
        @Override
        public void start(Stage stage) throws IOException, InterruptedException, URISyntaxException {
            backend backend=new backend("rouzbeg");

            stage.setScene(new Scene(backend.getShow()));
            stage.show();

        }


        public static void main(String[] args) {
            launch();
        }
}
