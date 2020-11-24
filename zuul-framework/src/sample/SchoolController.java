package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import worldofzuul.CommandWord;

import java.io.IOException;

public class SchoolController extends StationController {

    public Button bib_skole;

    @FXML
    public void goLibrary() throws IOException {

        //use command go and go to skolen
        getTest().processCommand(CommandWord.GO, "biblioteket");
        Parent loader = FXMLLoader.load(getClass().getResource("library.fxml"));
        Stage stage = (Stage) bib_skole.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));



    }
}
