package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

    private static final String UI_FILE = "library.fxml";

    @Override
    public void start (Stage stage_dummy) throws Exception {
        Stage stage = FXMLLoader.load(getClass().getResource(UI_FILE));
        stage.show();
    }
    public static void main (String[] args) {
        launch(args);
    }
}
