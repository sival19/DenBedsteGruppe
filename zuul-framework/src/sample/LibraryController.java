package sample;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import worldofzuul.*;

import java.io.IOException;


public class LibraryController {



    

    @FXML
    Button skole;

    private ZuulGame test;

    public ZuulGame getTest() {
        return test;
    }

    @FXML
    public void initialize () {


        test = new Game();

    }



    @FXML
    public void goSkole() throws IOException {

        //use command go and go to skolen
        test.processCommand(CommandWord.GO, "skolen");
        Parent loader = FXMLLoader.load(getClass().getResource("poorroom.fxml"));
        Stage stage = (Stage) skole.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));



    }

    @FXML
    public void backpack(){
        test.seeInventory();
    }

    }
