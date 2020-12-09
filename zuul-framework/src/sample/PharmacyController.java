package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PharmacyController extends Main implements Initializable {

    @FXML
    private Label text;

    // CHARACTER INTERACTION
    public void talkDoctor() {
        text.setText("Jeg er læge");
    }

    // CHARACTER INTERACTION
    public void talkSickboy() {
        text.setText("Jeg er syg, men jeg har ikke råd til medicin. ");
    }

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        medicine.setVisible(!checkInventory("medicin") && !getUsedItems().contains("medicin"));
        init();
    }

    // OBJECT INTERACTION

    public void pickMedicine() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "medicin", ""));
        medicine.setVisible(false);
        medicineInv.setOpacity(1.0);
        getTest().seeInventory();
    }


    // NAVIGATION
    public void goRichroom() throws IOException {
        changeRooms("rigmandsrum", "richroom.fxml");
    }

    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }

    public void goStation() throws IOException {
        changeRooms("stationen", "station.fxml");
    }
}
