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
import javafx.stage.Stage;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RichroomController extends Main implements Initializable {

    @FXML
    private Button richman;

    @FXML
    private Label text;

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        money.setVisible(!checkInventory("penge"));
        init();
    }

    // NAVIGATION
    public void goPharmacy() throws IOException {
        changeRooms("apoteket", "pharmacy.fxml");
    }

    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }

    public void goLibrary() throws IOException {
        changeRooms("biblioteket", "library.fxml");
    }

    // OBJECT INTERACTION

    public void removeMoney() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "penge");
        moneyInv.setOpacity(0.1);
        money.setVisible(true);
    }

    // CHARACTER INTERACTION
    public void talkRichman() {
        richman.getId();
        text.setText("Det er fedt at være rig, men også et ensomt liv. Det ville være rart med en ven.");
    }

    @FXML
    public void seeInventory() {
        getTest().seeInventory();
    }

}
