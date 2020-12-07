package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        medicine.setVisible(!checkInventory("medicin"));
        init();
    }

    // OBJECT INTERACTION
    public void removeMedicine() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "medicin");
        medicineInv.setOpacity(0.1);
        medicine.setVisible(true);
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
