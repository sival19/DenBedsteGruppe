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

public class StartPageController extends StationController {

    @FXML
    Button start;

    @FXML
    public void startGame() throws IOException {

        Parent loader = FXMLLoader.load(getClass().getResource("stationSecond.fxml"));
        Stage stage = (Stage) start.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));



    }
}
