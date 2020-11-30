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

import java.util.HashMap;

public class Main extends Application {
    private static ZuulGame test;

    public ZuulGame getTest() {
        return test;
    }


    private HashMap<String, Parent> scenes;

    public Parent getScene(String roomName) {
        return this.scenes.get(roomName);
    }

    private static final String UI_FILE = "station.fxml";

    @Override
    public void start (Stage stage_dummy) throws Exception {
        Stage stage = FXMLLoader.load(getClass().getResource(UI_FILE));
        scenes = new HashMap<>();
        Parent richroom = FXMLLoader.load(getClass().getResource("richroom.fxml"));

        scenes.put("richroom", richroom);
        stage.show();
    }


    public static void main (String[] args) {
        test = new Game();
        launch(args);
    }
}
