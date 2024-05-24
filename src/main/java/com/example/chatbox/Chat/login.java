package com.example.chatbox.Chat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class login extends VBox {

    Label  username;
    TextField usernameText;

    boolean b=false;
    Label  pass;
    TextField passText;

    public static login login;
    Button log;
    public login(){
       login =new login();
        username.setText("userName ");
        HBox usernam=new HBox(username,usernameText);
        pass.setText("pass Word ");
        HBox pas=new HBox(pass,passText);

        log.setText("inter");
        HBox login=new HBox(log);

        this.getChildren().addAll(usernam,pas,login);


    }
    public void Action(){
        log.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
             b=true;
            }
        });
    }

    public static login getLogin() {
        return login;
    }
}
