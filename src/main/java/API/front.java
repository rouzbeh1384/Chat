package API;

import javafx.collections.ObservableArray;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;

import java.io.File;

public class front extends AnchorPane {

    private ImageView imageView;
    private Label chose;
    public Button down;

    private ComboBox<String> comboBox ;
    private Label pathlbl;
    private Label labelnote;

    private TextField pathtet;
    public front(){
        chose=new Label("chose your file ");
        labelnote=new Label("click to download");
//        setDown(new Button("DOWNLOAD"));
//        down.setText("DOWNLOAD");
        setComboBox(new ComboBox<>());
        pathlbl=new Label("PATH");
//        pathlbl.setText("PATH");

        down=new Button("DOWNLOAD");
        setPathtet(new TextField());
        this.pathtet.setPromptText("C:\\Users\\Asus\\Desktop\\exercise javafx\\chatBox\\File_test");
        File existingImageFile = new File("src/main/java/API/image/pngtree-rainbow-curves-abstract-colorful-background-image_2164067.jpg");
        Image image = new Image(existingImageFile.toURI().toString());
        imageView=new ImageView(image);


        HBox hBox=new HBox();

        VBox vBox=new VBox(getComboBox(), getPathtet(), getDown());
        vBox.setSpacing(40);
        vBox.setAlignment(Pos.CENTER);
        VBox vBox1=new VBox(chose,pathlbl,labelnote);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(50);
        hBox.getChildren().addAll(vBox1,vBox);
        hBox.setPrefHeight(290);
        hBox.setPrefWidth(600);
        hBox.setAlignment(Pos.CENTER);


        comboBox.getItems().addAll(
                "birds-imagine-dragons.txt",
                "blinding-lights-the-weekend.txt",
                "dont-matter-to-me-drake.txt",
                "out-of-time-the-weekend.txt",
                "why-you-wanna-trip-on-me-michael-jackson.txt",
                "you-put-a-spell-on-me-austin-giorgio.txt"
        );
        this.getChildren().addAll(imageView,hBox);



    }


    public void setOnCloseRequest(EventHandler<WindowEvent> eventHandler) {
    }

    public Button getDown() {
        return down;
    }

    public void setDown(Button down) {
        this.down = down;
    }

    public ComboBox<?> getComboBox() {
        return comboBox;
    }

    public void setComboBox(ComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    public TextField getPathtet() {
        return pathtet;
    }

    public void setPathtet(TextField pathtet) {
        this.pathtet = pathtet;
    }
}
