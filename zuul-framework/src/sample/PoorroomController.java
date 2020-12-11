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
        text.setText("Jeg er så sulten, jeg har ikke spist i flere dage...");
    }

    public void talkPoorWoman() {
        text.setText("Åh hvor jeg fryser... Det kunne være rart med noget varmt");
    }



    // OBJECT INTERACTION
    /*
    * A simple remove method may not be enough. We need options when we
    * click on items. Maybe a little pop-up menu or drag-and-drop.
    * We need to figure interactions out.
     */

    public void giveAppleBoy(){
        giveItem(appleInv, appleChoice,"æble", "fattigDreng");
        text.setText("Tak "+getName()+", nu er jeg endelig mæt!");
    }

    public void giveAppleLady(){
        giveItem(appleInv, appleChoice,"æble", "fattigDame");
        text.setText("Tak "+getName()+", nu er jeg mæt, men jeg fryser stadig.");
    }

    public void giveMedicineBoy(){
        giveItem(medicineInv, medicineChoice, "medicin", "fattigDreng");
        text.setText("Tak "+getName()+", men jeg er stadig sulten.");
    }

    public void giveMedicineLady(){
        giveItem(medicineInv, medicineChoice, "medicin", "fattigDame");
        text.setText("Tak "+getName()+", men jeg fryser stadig!");
    }

    public void giveMoneyBoy(){
        giveItem(moneyInv, moneyChoice, "penge", "fattigDreng");
        text.setText("Tak "+getName()+", jeg kan bruge pengene til at købe mad!.");
    }
    public void giveMoneyLady() {
        giveItem(moneyInv, moneyChoice, "penge", "fattigDame");
        text.setText("Tak "+getName()+", jeg kan bruge pengene til at købe varme trøj!.");
    }

    public void giveScarfBoy(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "fattigDreng");
        text.setText("Tak " +getName()+", men jeg er stadig sulten!");
    }

    public void giveScarfLady(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "fattigDame");
        text.setText("Tak " +getName()+", nu er jeg endelig varm! Hvor er det rart!");
    }

    public void giveDrawingBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "fattigDreng");
        text.setText("Tak "+getName()+", men jeg er stadig sulten...");
    }

    public void giveDrawingLady(){
        giveItem(drawingInv, drawingChoice,"tegning", "fattigDame");
        text.setText("Tak "+getName()+", men jeg fryser stadig...");
    }

    public void giveBookBoy(){
        giveItem(bookInv, bookChoice,"bog", "fattigDreng");
        text.setText("Tak "+getName()+", men jeg er stadig sulten...");
    }

    public void giveBookLady(){
        giveItem(bookInv, bookChoice,"bog", "fattigDame");
        text.setText("Tak "+getName()+", men jeg fryser stadig...");
    }


    // NAVIGATION
    public void goStation() throws IOException {
        changeRooms("stationen", "station.fxml");
    }

    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }

    public void goRichroom() throws IOException {
        changeRooms("slottet", "richroom.fxml");
    }

    public void goPharmacy() throws IOException{
        changeRooms("apoteket", "pharmacy.fxml");
    }
}