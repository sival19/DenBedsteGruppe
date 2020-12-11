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


    public void talkMan() {
        text.setText("Jeg har mistet alt og nu bor jeg her på gaden... Har du måske lidt penge du kan undvære?");
    }

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    // OBJECT INTERACTION
    public void giveAppleStationMan() {
        giveItem(appleInv, appleChoice, "æble", "hjemløsMand");
        text.setText("Tak "+getName()+"!");
    }

    public void giveBookStationMan() {
        giveItem(bookInv, bookChoice, "bog", "hjemløsMand");
        text.setText("Tak "+getName()+"!");
    }

    public void giveScarfStationMan() {
        giveItem(scarfInv, scarfChoice, "halstørklæde", "hjemløsMand");
        text.setText("Tak "+getName()+"!");
    }

    public void giveDrawingStationMan() {
        giveItem(drawingInv, drawingChoice, "tegning", "hjemløsMand");
        text.setText("Tak "+getName()+"!");
    }

    public void giveMedicineStationMan() {
        giveItem(medicineInv, medicineChoice, "medicin", "hjemløsMand");
        text.setText("Tak "+getName()+"!");
    }

    public void giveMoneyStationMan() {
        giveItem(moneyInv, moneyChoice, "penge", "hjemløsMand");
        text.setText("Tak "+getName()+"! Nu kan jeg overleve en uge mere.");
    }

    public void pickMedicine() {
        pickItem(medicine, medicineInv, "medicin");
    }



    // NAVIGATION
    public void goPoorroom() throws IOException {
        changeRooms("gaden", "poorroom.fxml");
    }

}
