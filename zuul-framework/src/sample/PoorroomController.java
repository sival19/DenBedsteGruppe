package sample;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import worldofzuul.Character;
import worldofzuul.CommandWord;


import java.io.IOException;

public class PoorroomController extends StationController {

    @FXML private Button poorChild, school_poor, station_poor, dreng;
    @FXML private ImageView apple, appleInv;



    @FXML
    public void goStation() throws IOException {
        getTest().processCommand(CommandWord.GO, "stationen");
        Parent loader = FXMLLoader.load(getClass().getResource("stationSecond.fxml"));
        Stage stage = (Stage) station_poor.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goSchool() throws IOException {

        //use command go and go to skolen
        getTest().processCommand(CommandWord.GO, "skolen");
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) school_poor.getScene().getWindow();


        stage.setScene(new Scene(loader, 731, 439));

    }



    @FXML
    private TextField text;
    public void talkPoorChild() {
        dreng.getId();
        // Somehow call getCharMessage from Game class with button id as argument. Make sure char name == buttonid
        text.setText("Jeg er sulten"); // set text to getCharMessage return value

        // 
    }



    @FXML
    public void talkWoman(){

    }

    public void pickApple() {
        getTest().processCommand(CommandWord.PICKUP, "æble");
        apple.setVisible(false);
        appleInv.setVisible(true);
        getTest().seeInventory();

    }

    public void removeApple() {

        getTest().processCommand(CommandWord.REMOVEITEMS, "æble");
        appleInv.setVisible(false);
        apple.setVisible(true);


    }
}
