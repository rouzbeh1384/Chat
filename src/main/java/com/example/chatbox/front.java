package com.example.chatbox;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class front extends VBox {

    private TextArea ShowText;
    private TextField chat;
    private Button btnsned;

    public front(){

        setShowText(new TextArea());
        ImageView imageView=new ImageView();
        HBox chatShow=new HBox(getShowText(),imageView);
        chatShow.setDisable(false);
        chatShow.setAlignment(Pos.BOTTOM_LEFT);
        Lighting lit= new Lighting();

        chatShow.setEffect(lit);

        setBtnsned(new Button("send"));
        setChat(new TextField());
        HBox chatSend=new HBox(getChat(), getBtnsned());
        chatSend.setAlignment(Pos.BOTTOM_LEFT);
        this.getChildren().addAll (chatShow,chatSend);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);

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
}
