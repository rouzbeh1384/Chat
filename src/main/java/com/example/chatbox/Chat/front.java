package com.example.chatbox.Chat;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.WindowEvent;

import java.io.File;

public class front extends AnchorPane {

    private TextArea ShowText;
    private TextField chat;
    private Button btnsned;

    public front(){


        File file=new File("src/main/java/com/example/chatbox/Chat/image/f870db90-8039-11ee-9772-4f8ebbd9a655.jpg");
//        File file2=new File("src/main/java/com/example/chatbox/Chat/image/poster_eeb21cb2-1f9f-491b-8b3f-b7f69d60c04f.jpg");

        Image image=new Image(file.toURI().toString());
//        Image image2=new Image(file2.toURI().toString());

        ImageView imageView=new ImageView(image);
//        ImageView imageView1=new ImageView(image2);
        setShowText(new TextArea());

        HBox chatShow=new HBox(getShowText());
        chatShow.setSpacing(20);
        chatShow.setDisable(false);
        chatShow.setAlignment(Pos.BOTTOM_LEFT);

        Lighting lit= new Lighting();
        getShowText().setEditable(false);
        chatShow.setEffect(lit);

        setBtnsned(new Button("send"));
        setChat(new TextField());


        HBox chatSend=new HBox(getChat(), getBtnsned());
        chatSend.setAlignment(Pos.CENTER);
        VBox vBox=new VBox(chatShow,chatSend);

        vBox.setAlignment(Pos.CENTER);

        vBox.setSpacing(15);
        this.getChildren().addAll(imageView,vBox);

    }


    public TextArea getShowText() {
        return ShowText;
    }

    public void setShowText(TextArea showText) {
        ShowText=(showText);
    }
    public void setText(String s){
        ShowText.setText(s);
    }
    public TextField getChat() {
        return chat;
    }

    public void setChat(TextField chat) {
        this.chat = chat;
    }

    public Button getBtnsned() {
        return btnsned;
    }

    public void setBtnsned(Button btnsned) {
        this.btnsned = btnsned;
    }

    public void appendToChat(String message) {

    }

    public void setOnCloseRequest(EventHandler<WindowEvent> eventHandler) {
    }
}
