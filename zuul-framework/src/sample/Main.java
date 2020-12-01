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

//hashmap for rooms
    private HashMap<String, Parent> scenes = new HashMap<>();


    public Parent getScene(String roomName) {
        return this.scenes.get(roomName);
    }

    private static final String UI_FILE = "startPage.fxml";

    @Override
    public void start (Stage stage_dummy) throws Exception {


        Parent richroom = FXMLLoader.load(getClass().getResource("richroom.fxml"));
        Parent poorroom = FXMLLoader.load(getClass().getResource("poorroom.fxml"));
        Parent station = FXMLLoader.load(getClass().getResource("station.fxml"));

        //når man bruger getScene() andre steder istedet for FXMLLoader..... burde det virke meeeen, det er javaFX, så nej :(
        scenes.put("richroom", richroom);
        scenes.put("poorroom", poorroom);
        scenes.put("station", station);






        Stage stage = FXMLLoader.load(getClass().getResource(UI_FILE));




        stage.show();
    }


    public static void main (String[] args) {
        test = new Game();
        launch(args);
    }
}
