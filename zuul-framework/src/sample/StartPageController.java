package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;

public class StartPageController extends Main {

    @FXML
    Button start;

    @FXML
    public void startGame() throws IOException {
        /* Metoder er/skal flyttes til test.fxml.
        * Indtil videre er det bare nogle ting, som er flyttet for at se om det virkede
        *
         */


        //den som er udkommenteret gidder ikke at funge, kig i Main>>start og getScene methods

        //Parent loader = FXMLLoader.load(getClass().getResource("station.fxml"));
        Parent loader = getScene("station");
        Stage stage = (Stage) start.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));
    }
}
