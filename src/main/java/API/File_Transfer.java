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
            backend backend =new backend();
            front font=new front();
            stage.setScene(new Scene(font));
            stage.show();

        }


        public static void main(String[] args) {
            launch();
        }
}
