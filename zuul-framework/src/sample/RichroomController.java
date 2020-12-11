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
        apple.setVisible(!checkInventory("æble") && !getUsedItems().contains("æble"));
        init();
    }

    // NAVIGATION
    public void goPoorroom() throws IOException {
        changeRooms("fattiggården", "poorroom.fxml");
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
        giveItem(appleInv, appleChoice, "æble", "rigmand");

        text.setText("Tak " +getName()+", men jeg har penge til at købe alle æbler i verden!");
    }

    public void giveBookRich(){
        giveItem(bookInv, bookChoice, "bog", "rigmand");

        text.setText("Tak " +getName()+", men jeg har penge til at købe alle bøger i verden!");
    }

    public void giveScarfRich(){
        giveItem(scarfInv, scarfChoice, "halstørklæde", "rigmand");

        text.setText("Tak "+getName()+", men jeg har penge til at købe alle halstørklæder i verden!");
    }

    public void giveDrawingRich(){
        giveItem(drawingInv, drawingChoice,"tegning", "rigmand");
        text.setText("Tak " +getName()+", det her var det eneste jeg manglede: et tegn på at der er nogen derude, som vil være min ven!");
    }

    public void giveMedicineRich(){
       giveItem(medicineInv, medicineChoice, "medicin", "rigmand");
        text.setText("Tak " +getName()+", men jeg har penge til at købe alt medicin i verden!");
    }

    // CHARACTER INTERACTION
    public void talkRichman() {
        if (!getUsedItems().contains("penge") && !checkInventory("penge")) {
            text.setText("Hej! jeg har mega mange penge, og aner ikke hvad jeg skal bruge dem til, jeg har hellere ingen venner " );
            pickMoney();
        } else if (getUsedItems().contains("penge")) {
            text.setText("Jeg håber at nogen fik gavn af pengene");
        }
    }

    @FXML
    public void seeInventory() {
        getGame().seeInventory();
    }
}
