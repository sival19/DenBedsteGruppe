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
        if (!getUsedItems().contains("medicin") && !checkInventory("medicin")) {
            text.setText("Hej, jeg har set en syg dreng der virkeligt kunne broge noget medicin men har ikke råd til det, " +
                    " kan du give det til ham? ");
            pickMedicine();
        } else if (getUsedItems().contains("medicin")) {
            text.setText("Jeg håber den rige mand blev glad!");
        }
    }


    public void talkSickboy() {
        text.setText("Jeg er syg, men jeg har ikke råd til medicin. ");
    }

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    // OBJECT INTERACTION

    public void pickMedicine() {
        pickItem(medicine, medicineInv, "medicin");
    }

    public void giveMedicineSick(){
        giveItem(medicineInv, medicineChoice,"medicin", "sygMand");
        text.setText("Tusind tak! Nu kan det være jeg endelig får det bedre!");
    }

    public void giveDrawingSick(){
        giveItem(drawingInv, drawingChoice,"tegning", "sygMand");
        text.setText("Tak... *host* det er en fin tegning! *host* puha jeg har det skidt...");
    }

    public void giveMoneySick(){
        giveItem(moneyInv, moneyChoice,"penge", "sygMand");
        text.setText("Tak, nu kan det måske være jeg har råd til at købe noget medicin.");
    }

    public void giveScarfSick(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "sygMand");
        text.setText("Tak... *host* det gør mig nok ikke rask, men det kan holde mig varm *host* ");
    }

    public void giveBookSick(){
        giveItem(bookInv, bookChoice,"bog", "sygMand");
        text.setText("Tak... *host* kan være jeg kan læse den når jeg får det bedre *host* ");
    }

    public void giveAppleSick(){
        giveItem(appleInv, appleChoice,"æble", "sygMand");
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
