package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController extends Main implements Initializable {

    @FXML
    private Label text;

    //CHARACTER INTERACTION
    public void talkOldLady() {
        if (!getUsedItems().contains("halstørklæde") && !checkInventory("halstørklæde")) {
            text.setText("Hej! Mig og nogle andre har tegnet en tegning til den rige mand, vil du give den til ham?" +
                    " Vi må ikke gå ind på slottet...");
            pickScarf();
        } else if (getUsedItems().contains("halstørklæde")) {
            text.setText("Jeg håber den rige mand blev glad!");
        }
    }

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        book.setVisible(!checkInventory("bog") && !getUsedItems().contains("bog"));


        init();
    }


    // NAVIGATION
    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }

    public void goRichroom() throws IOException {
        changeRooms("rigmandsrum", "richroom.fxml");
    }

    // OBJECT INTERACTION

    public void giveAppleNiceLady(){
        giveItem(appleInv, appleChoice, "æble", "strikkeDame");
    }

    public void giveBookNiceLady(){
        giveItem(bookInv, bookChoice, "bog", "strikkeDame");
    }

    public void giveMoneyNiceLady(){
        giveItem(moneyInv, moneyChoice, "penge", "strikkeDame");
    }

    public void giveMedicineNiceLady(){
        giveItem(medicineInv, medicineChoice, "medicin", "strikkeDame");
    }

    public void giveDrawingNiceLady(){
        giveItem(drawingInv,drawingChoice, "tegning", "strikkeDame");
    }

    public void pickBook() {
        pickItem(book, bookInv, "bog");
    }

    public void pickScarf() {
        pickItem(scarf, scarfInv, "halstørklæde");
    }

}