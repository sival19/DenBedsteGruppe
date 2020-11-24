package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import worldofzuul.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class LibraryController {



    

    @FXML private Button button;
    private ZuulGame test;

    @FXML
    public void initialize () {


        test = new Game();



    }



    @FXML
    public void goSkole(){

        //use command go and go to skolen
        test.processCommand(CommandWord.GO, "skolen");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("poorroom.fxml"));


    }

    @FXML
    public void backpack(){
        test.seeInventory();
    }

    }
