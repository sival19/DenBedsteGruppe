package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RichroomController extends Main implements Initializable {

    @FXML
    private Label text;

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        money.setVisible(!checkInventory("penge"));
        init();
        apple.setVisible(!checkInventory("æble"));
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



    // CHARACTER INTERACTION
    public void talkRichman() {
        text.setText("Jeg er sulten");
    }

    @FXML
    public void seeInventory() {
        getTest().seeInventory();
    }

}
