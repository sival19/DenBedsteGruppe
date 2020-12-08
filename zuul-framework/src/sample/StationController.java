package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import worldofzuul.Command;
import worldofzuul.CommandWord;
import worldofzuul.CommandWords;
import worldofzuul.Game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StationController extends Main implements Initializable {

    @FXML
    private ImageView bookInv, appleInv, medicineInv, moneyInv;
    @FXML
    private Label text;

    // CHARACTER INTERACTION
    public void talkWizard() {
        text.setText("God du klikkede! Husk nu at tænke dig om når du spiller spillet,"
        + " hvem har brug for hvad? Prøv at klikke på manden ude til højre, han ligner en der har brug for hjælp.");
    }
    // CHARACTER INTERACTION
    public void talkMan() {
        text.setText("Jeg har mistet alt og nu bor jeg her på gaden... Har du måske lidt penge du kan undvære?");
    }

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    public void goPharmacy() throws IOException {
        changeRooms("apoteket", "pharmacy.fxml");
    }

    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }

    public void goPoorRoom() throws IOException {
        changeRooms("fattiggården", "poorroom.fxml");
    }

    public void backpack() {
        getTest().seeInventory();
    }
}
