package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import worldofzuul.CommandWord;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PoorroomController extends Main implements Initializable {

    @FXML
    private Label text;

    @FXML
    public ImageView poorChild;


    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    public void giveAppleBoy(){
        getTest().processCommand(CommandWord.GIVEITEM, "æble", "dreng");
        appleInv.setOpacity(0.1);
        appleInv.setDisable(true);
        appleChoice.setDisable(true);
        appleChoice.setOpacity(0.0);
        getTest().processCommand(CommandWord.REMOVEITEMS, "æble", "");
        text.setText("Tak, nu er jeg endelig mæt!");

    }

    public void giveAppleLady(){
        giveItem(appleInv, appleChoice,"æble", "Dame");
        text.setText("Tak, nu er jeg mæt, men jeg fryser stadig.");

    }





    // NAVIGATION
    public void goStation() throws IOException {
        changeRooms("stationen", "station.fxml");
    }

    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }
}