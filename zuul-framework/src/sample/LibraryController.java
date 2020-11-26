package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import worldofzuul.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class LibraryController extends StationController {


    @FXML private Button school_lib, richroom_lib;

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


    }
