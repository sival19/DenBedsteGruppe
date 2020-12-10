package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RichroomController extends Main implements Initializable {

    @FXML
    private Label text;

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        money.setVisible(!checkInventory("penge") && !getUsedItems().contains("penge"));
        apple.setVisible(!checkInventory("æble") && !getUsedItems().contains("æble"));
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
    public void pickMoney(){
        pickItem(money, moneyInv, "penge");
        
    }

    public void pickApple() {
        pickItem(apple, appleInv, "æble");

    }

    public void giveAppleRich(){

        text.setText("Tak, men jeg har penge til at købe alle æbler i verden!");
    }

    public void giveBookRich(){

        text.setText("Tak, men jeg har penge til at købe alle bøger i verden!");
    }

    public void giveScarfRich(){

        text.setText("Tak, men jeg har penge til at købe alle halstørklæder i verden!");
    }

    public void giveDrawingRich(){
        giveItem(drawingInv, drawingChoice,"tegning", "rigmand");
        text.setText("Tak, det her var det eneste jeg manglede: et tegn på at der er nogen derude, som vil være min ven!");
    }

    public void giveMedicineRich(){
       giveItem(medicineInv, medicineChoice, "medicin", "rigmand");
        text.setText("Tak, men jeg har penge til at købe alt medicin i verden!");
    }

    // CHARACTER INTERACTION
    public void talkRichman() {
        text.setText("Jeg er sulten DET HER SKAL ÆNDRES");
    }

    @FXML
    public void seeInventory() {
        getTest().seeInventory();
    }
}
