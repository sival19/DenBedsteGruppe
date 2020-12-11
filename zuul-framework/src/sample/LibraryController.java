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
            text.setText("Hej! Jeg har strukket alt for mange halstørklæder, kender du nogen som kunne bruge et?");
            pickScarf();
        } else if (getUsedItems().contains("halstørklæde")) {
            text.setText("Jeg håber at nogen fik glæde af mit hasltørklæde!");
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
        changeRooms("slottet", "richroom.fxml");
    }

    // OBJECT INTERACTION

    public void giveAppleNiceLady(){
        giveItem(appleInv, appleChoice, "æble", "strikkeDame");
        text.setText("Tak "+getName()+"! Men jeg er ikke sulten.");
    }

    public void giveBookNiceLady(){
        giveItem(bookInv, bookChoice, "bog", "strikkeDame");
        text.setText("Tak "+getName()+"! Men jeg sidder på et bibliotek.");
    }

    public void giveMoneyNiceLady(){
        giveItem(moneyInv, moneyChoice, "penge", "strikkeDame");
        text.setText("Tak "+getName()+"! Men jeg har ikke brug for flere penge.");
    }

    public void giveMedicineNiceLady(){
        giveItem(medicineInv, medicineChoice, "medicin", "strikkeDame");
        text.setText("Tak "+getName()+"! Medicin kan man altid bruge når man er oppe i alderen.");
    }

    public void giveDrawingNiceLady(){
        giveItem(drawingInv,drawingChoice, "tegning", "strikkeDame");
        text.setText("Tak "+getName()+"!");
    }

    public void pickBook() {
        pickItem(book, bookInv, "bog");
    }

    public void pickScarf() {
        pickItem(scarf, scarfInv, "halstørklæde");
    }

}