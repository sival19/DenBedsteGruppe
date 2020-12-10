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

    //Object INTERACTIION
    public void pickDrawing(){
        pickItem(drawing, drawingInv, "tegning");
    }

    // CHARACTER INTERACTION
    public void talkGirl() {
        clearMenu();
        text.setText("Hej! Mig og nogle andre har tegnet en tegning til den rige mand, vil du give den til ham?" +
                " Vi må ikke gå ind på slottet...");
    }

    // CHARACTER INTERACTION
    public void talkBoy() {
        clearMenu();
        text.setText("Jeg vil så gerne klare mig godt i skolen så jeg kan få en god fremtid, men mine forældre har ikke råd til bøger...");
    }

    public void giveAppleBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveAppleGirl(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveBookBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveBookGirl(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveScarfBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveScarfGirl(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveMoneyBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveMoneyGirl(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveDrawingBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveMedicineBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }

    public void giveMedicineGirl(){
        giveItem(drawingInv, drawingChoice,"tegning", "boy");
        text.setText("Tak, den er fin!");
    }


    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        drawing.setVisible(!checkInventory("tegning") && !getUsedItems().contains("tegning"));
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
