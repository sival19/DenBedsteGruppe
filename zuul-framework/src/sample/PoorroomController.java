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
import worldofzuul.Command;
import worldofzuul.CommandWord;


import java.io.IOException;

public class PoorroomController extends Main {

    @FXML private Button poorChild, school_poor, station_poor, dreng, poorWoman;
    @FXML private ImageView apple, appleInv;



    @FXML
    public void goStation() throws IOException {
        getTest().goRoom(new Command(CommandWord.GO, "stationen"));
        //Parent loader = FXMLLoader.load(getClass().getResource("station.fxml"));
        Scene scene = school_poor.getScene();
        Parent root = getScene("station");
        scene.setRoot(root);

    }

    @FXML
    public void goSchool() throws IOException {

        //use command go and go to skolen
        getTest().goRoom(new Command(CommandWord.GO, "skolen"));
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

    }

    @FXML
    public void talkPoorWoman(){
        poorWoman.getId();
        // Somehow call getCharMessage from Game class with button id as argument. Make sure char name == buttonid
        text.setText("Åh hvor jeg fryser"); // set text to getCharMessage return value
    }


    public void pickApple() {
        getTest().pickUp(new Command(CommandWord.PICKUP , "æble"));
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
