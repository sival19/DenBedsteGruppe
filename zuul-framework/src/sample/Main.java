package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import worldofzuul.Game;

public class Main extends Application {
    private static ZuulGame test;

    public ZuulGame getTest() {
        return test;
    }




    private static final String UI_FILE = "station.fxml";

    @Override
    public void start (Stage stage_dummy) throws Exception {
        Stage stage = FXMLLoader.load(getClass().getResource(UI_FILE));
        stage.show();
    }


    public static void main (String[] args) {
        test = new Game();
        launch(args);
    }
}
