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
        giveItem(appleInv, appleChoice,"æble", "poorBoy");
        text.setText("Tak, nu er jeg endelig mæt!");
    }

    public void giveAppleLady(){
        giveItem(appleInv, appleChoice,"æble", "poorLady");
        text.setText("Tak, nu er jeg mæt, men jeg fryser stadig.");
    }

    public void giveMedicineBoy(){
        giveItem(medicineInv, medicineChoice, "medicin", "poorBoy");
        text.setText("Tak, men jeg er stadig sulten.");
    }

    public void giveMedicineLady(){
        giveItem(medicineInv, medicineChoice, "medicin", "poorLady");
        text.setText("Tak, men jeg fryser stadig!");
    }

    public void giveMoneyBoy(){
        giveItem(moneyInv, moneyChoice, "penge", "poorBoy");
        text.setText("Tak, jeg bruger penge til at købe mad!.");
    }
    public void giveMoneyLady() {
        giveItem(moneyInv, moneyChoice, "penge", "poorLady");
        text.setText("Tak, jeg bruger penge til at købe varme trøj!.");
    }

    public void giveScarfBoy(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "poorBoy");
        text.setText("Tak, men jeg er stadig sulten!");
    }

    public void giveScarfLady(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "poorLady");
        text.setText("Tak, nu er jeg endelig varm!.");
    }

    public void giveDrawingBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "poorBoy");
        text.setText("Tak, men jeg er stadig sulten!");
    }

    public void giveDrawingLady(){
        giveItem(drawingInv, drawingChoice,"tegning", "poorLady");
        text.setText("Tak, men jeg fryser stadig.");
    }

    public void giveBookBoy(){
        giveItem(bookInv, bookChoice,"bog", "poorBoy");
        text.setText("Tak, men jeg er stadig sulten!");
    }

    public void giveBookLady(){
        giveItem(bookInv, bookChoice,"bog", "poorLady");
        text.setText("Tak, men jeg fryser stadig.");
    }




    // NAVIGATION
    public void goStation() throws IOException {
        changeRooms("stationen", "station.fxml");
    }

    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }
}