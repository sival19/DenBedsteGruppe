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

    public void giveMedicineSick(){
        giveItem(medicineInv, medicineChoice,"medicin", "sickMan");
        text.setText("Tusind tak! Nu kan det være jeg endelig får det bedre!");
    }

    public void giveDrawingSick(){
        giveItem(drawingInv, drawingChoice,"tegning", "sickMan");
        text.setText("Tak... *host* det er en fin tegning! *host* puha jeg har det skidt...");
    }

    public void giveMoneySick(){
        giveItem(moneyInv, moneyChoice,"penge", "sickMan");
        text.setText("Tak, nu kan det måske være jeg har råd til at købe noget medicin.");
    }

    public void giveScarfSick(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "sickMan");
        text.setText("Tak... *host* det gør mig nok ikke rask, men det kan holde mig varm *host* ");
    }

    public void giveBookSick(){
        giveItem(bookInv, bookChoice,"bog", "sickMan");
        text.setText("Tak... *host* kan være jeg kan læse den når jeg får det bedre *host* ");
    }

    public void giveAppleSick(){
        giveItem(appleInv, appleChoice,"æble", "sickMan");
        text.setText("Tak... *host* jeg har det dog lidt for dårligt til at spise, men jeg gemmer det til senere *host* ");
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
