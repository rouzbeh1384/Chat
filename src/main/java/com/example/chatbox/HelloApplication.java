package com.example.chatbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        System.out.println("inter username ");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        backend backend=new backend(name);
        stage.setScene(new Scene(backend.getShow()));
        stage.show();}


    public static void main(String[] args) {
        launch();



    }
}