package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import worldofzuul.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class LibraryController extends StationController {


    @FXML private Button school_lib, richroom_lib, oldLady;
    @FXML
    ImageView book, bookInv;

    @FXML
    private TextField text;
    public void talkOldLady() {
        oldLady.getId();
        // Somehow call getCharMessage from Game class with button id as argument. Make sure char name == buttonid
        text.setText("Jeg har strukket for mange halstørklæder, kender du nogen som kan bruge dem?"); // set text to getCharMessage return value

    }

    @FXML
    public void goSchool() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "skolen"));
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) school_lib.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));
    }

    @FXML
    public void goRichroom() throws IOException {

        getTest().goRoom(new Command(CommandWord.GO, "rigmandsgården"));
        Parent loader = FXMLLoader.load(getClass().getResource("richroom.fxml"));
        Stage stage = (Stage) richroom_lib.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    public void pickBook() {
        getTest().pickUp(new Command(CommandWord.PICKUP , "bog"));
        book.setVisible(false);
        bookInv.setVisible(true);
        getTest().seeInventory();
    }

    public void removeBook() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "bog");
        bookInv.setVisible(false);
        book.setVisible(true);
    }


    }
