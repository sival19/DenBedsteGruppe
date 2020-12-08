package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;

public class TestController extends Main {
    @FXML
    AnchorPane station, school, richroom, poorroom, pharmacy, library;

    @FXML
    Button poorChild;

    @FXML
    Label text;

    /*
    * Vi skifter rum ved at gøre det nuværende rum synligt, og det "næste" rum usynligt.
    * Meningen er at hver Pane/rum fra fxml, gerne skulle kunne få sin egen controller.
    * Men det er vi ikke nået til endnu
     */

    // Method to move away from station
    @FXML
    public void goSchoolStation() throws IOException {
        school.setVisible(true);
        station.setVisible(false);
    }

    @FXML
    public void goPharmacyStation() throws IOException {
    }

    @FXML
    public void goPoorRoomStation() throws IOException {
        poorroom.setVisible(true);
        station.setVisible(false);
    }

    // Methods to move away from school
    @FXML
    public void goLibrarySchool() throws IOException {
    }

    @FXML
    public void goPharmacySchool() throws IOException {
    }

    @FXML
    public void goRichRoomSchool() throws IOException {
    }

    @FXML
    public void goPoorRoomSchool() throws IOException {
    }

    @FXML
    public void goStationSchool() throws IOException {
        station.setVisible(true);
        school.setVisible(false);
    }

    public void goStationPoorRoom() throws IOException {
        station.setVisible(true);
        poorroom.setVisible(false);

    }

    // backpack method
    @FXML
    public void backpack() {
        getTest().seeInventory();
    }

    public void talkPoorChild() {
        poorChild.getId();
        // Somehow call getCharMessage from Game class with button id as argument. Make sure char name == buttonid
        text.setText("Jeg er sulten"); // set text to getCharMessage return value
    }

    public void talkPoorWoman(ActionEvent actionEvent) {
    }

    @FXML private ImageView apple, appleInv;
    public void pickApple() {
        getTest().pickUp(new Command(CommandWord.PICKUP , "æble", ""));
        apple.setVisible(false);
        appleInv.setVisible(true);
        getTest().seeInventory();
    }

    public void removeApple() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "æble", "");
        appleInv.setVisible(false);
        apple.setVisible(true);
    }
}

