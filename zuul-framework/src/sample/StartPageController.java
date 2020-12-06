package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;

public class StartPageController extends Main {

    @FXML
    Button start;

    @FXML
    public void startGame() throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("station.fxml"));
        Stage stage = getStage();
        stage.setScene(new Scene(loader));
    }
}
