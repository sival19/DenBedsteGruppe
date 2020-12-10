package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartPageController extends Main {

    @FXML
    Button start;

    @FXML
    TextField nameInput;

    @FXML
    public void startGame() throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("station.fxml"));
        Stage stage = getStage();
        stage.setScene(new Scene(loader));
        setName(nameInput.getText());
    }

    public void checkName() {
        start.setDisable(nameInput.getText().length() < 1);
    }
}
