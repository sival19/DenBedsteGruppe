package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import worldofzuul.CommandWord;

import java.io.IOException;

public class RichroomController extends StationController {

    @FXML
    Button library_rich, school_rich, pharmacy_rich;

    @FXML
    public void talkRichman() {

    }

    @FXML
    public void goPharmacy() throws IOException {
        getTest().processCommand(CommandWord.GO, "apoteket");
        Parent loader = FXMLLoader.load(getClass().getResource("pharmacy.fxml"));
        Stage stage = (Stage) pharmacy_rich.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goSchool() throws IOException {
        getTest().processCommand(CommandWord.GO, "skolen");
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) school_rich.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goLibrary() throws IOException {
        getTest().processCommand(CommandWord.GO, "biblioteket");
        Parent loader = FXMLLoader.load(getClass().getResource("library.fxml"));
        Stage stage = (Stage) library_rich.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }


}
