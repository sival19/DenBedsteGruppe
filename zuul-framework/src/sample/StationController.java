package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import worldofzuul.CommandWord;
import worldofzuul.Game;

import java.io.IOException;

public class StationController {

    public ZuulGame getTest() {
        return test;
    }

    private ZuulGame test;

    @FXML
    Button skole_tr;

    @FXML
    public void initialize () {
        test = new Game();
    }


    @FXML
    public void goSkolen() throws IOException {

        //use command go and go to skolen
        test.processCommand(CommandWord.GO, "skolen");
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) skole_tr.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));



    }

    @FXML
    public void backpack(){
        test.seeInventory();
    }
}
