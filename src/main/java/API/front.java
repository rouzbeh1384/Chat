package API;

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
import javafx.scene.shape.Circle;

import java.io.File;

public class front extends AnchorPane {

    private ImageView imageView;
    private Label chose;
    private Button down;

    private ComboBox<?> comboBox ;
    private Label pathlbl;
    private Label labelnote;

    TextField pathtet;
    public front(){
        chose=new Label("chose your file ");
        labelnote=new Label("click to download");
//        chose.setText("chose your file ");
        down=new Button("DOWNLOAD");
//        down.setText("DOWNLOAD");
        comboBox = new ComboBox<>();
        pathlbl=new Label("PATH");
//        pathlbl.setText("PATH");

        pathtet=new TextField("C:\\Users\\Asus\\Downloads");
        File existingImageFile = new File("src/main/java/API/pngtree-rainbow-curves-abstract-colorful-background-image_2164067.jpg");
        Image image = new Image(existingImageFile.toURI().toString());
        imageView=new ImageView(image);


        HBox hBox=new HBox();

        VBox vBox=new VBox(comboBox,pathtet,down);
        vBox.setSpacing(40);
        vBox.setAlignment(Pos.CENTER);
        VBox vBox1=new VBox(chose,pathlbl,labelnote);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(50);
        hBox.getChildren().addAll(vBox1,vBox);
        hBox.setPrefHeight(290);
        hBox.setPrefWidth(600);
        hBox.setAlignment(Pos.CENTER);


        this.getChildren().addAll(imageView,hBox);



    }






}
