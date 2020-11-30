package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import worldofzuul.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class LibraryController extends StationController {


    @FXML private Button school_lib, richroom_lib, lady;

    @FXML
    public void goSchool() throws IOException{
        getTest().processCommand(CommandWord.GO, "skolen");
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) school_lib.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));
    }

    @FXML
    public void goRichroom() throws IOException {

        getTest().processCommand(CommandWord.GO, "rigmandsgården");
        Parent loader = FXMLLoader.load(getClass().getResource("richroom.fxml"));
        Stage stage = (Stage) richroom_lib.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }
    @FXML
    private TextField text;
    public void talkOldLady(){
        lady.getId();
        // Somehow call getCharMessage from Game class with button id as argument. Make sure char name == buttonid
        text.setText("Jeg har strukket alt for mange halstertørklælder, kender du nogen som kunne bruge dem?"); // set text to getCharMessage return value
    }

    }
