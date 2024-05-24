module com.example.chatbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatbox to javafx.fxml;
//    exports com.example.chatbox;
    exports com.example.chatbox.Chat;
//    exports API;
    opens com.example.chatbox.Chat to javafx.fxml;
}