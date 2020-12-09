package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SchoolController extends Main implements Initializable {


    @FXML
    private Label text;

    //Object INTERRACTIION

    public void pickDrawing() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "tegning", ""));
        drawing.setVisible(false);
        drawingInv.setOpacity(1.0);
        getTest().seeInventory();
    }

    // CHARACTER INTERACTION
    public void talkGirl() {
        text.setText("Hej! Mig og nogle andre har tegnet en tegning til den rige mand, vil du give den til ham?" +
                " Vi må ikke gå ind på slottet...");

    }
    // CHARACTER INTERACTION
    public void talkBoy() {
        text.setText("Jeg vil så gerne klare mig godt i skolen så jeg kan få en god fremtid, men mine forældre har ikke råd til bøger...");
    }


    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       drawing.setVisible(!checkInventory("tegning"));
       init();
    }

    // NAVIGATION
    public void goLibrary() throws IOException {
        changeRooms("biblioteket", "library.fxml");
    }

    public void goPharmacy() throws IOException {
        changeRooms("apoteket", "pharmacy.fxml");
    }

    public void goRichRoom() throws IOException {
        changeRooms("rigmandsrum", "richroom.fxml");
    }

    public void goPoorroom() throws IOException {
        changeRooms("fattiggården", "poorroom.fxml");
    }

    public void goStation() throws IOException {
        changeRooms("stationen", "station.fxml");
    }
}
