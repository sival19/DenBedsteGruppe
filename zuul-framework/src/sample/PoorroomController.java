package sample;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import worldofzuul.Character;
import worldofzuul.Command;
import worldofzuul.CommandWord;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PoorroomController extends Main implements Initializable {

    @FXML
    private Label text;


    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // "apple" cannot be part of the generic init()
        // because it isn't in all rooms/fxml-files atm.
        apple.setVisible(!checkInventory("æble"));
        init();
    }

    // CHARACTER INTERACTION
    public void talkPoorChild() {
        text.setText("Jeg er sulten");
    }

    public void talkPoorWoman() {
        text.setText("Åh hvor jeg fryser");
    }



    // OBJECT INTERACTION
    /*
    * A simple remove method may not be enough. We need options when we
    * click on items. Maybe a little pop-up menu or drag-and-drop.
    * We need to figure interactions out.
     */





    // NAVIGATION
    public void goStation() throws IOException {
        changeRooms("stationen", "station.fxml");
    }

    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }
}