package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import worldofzuul.Command;
import worldofzuul.CommandWord;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController extends Main implements Initializable {

    @FXML
    private Label text;

    //CHARACTER INTERACTION
    public void talkOldLady() {
        text.setText("Jeg har strukket alt for mange halstørklæder, kender du nogen som kan bruge dem?");
    }

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        book.setVisible(!checkInventory("bog") && !getUsedItems().contains("bog"));
        scarf.setVisible(!checkInventory("halstørklæde") && !getUsedItems().contains("halstørklæde"));
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
        giveItem(moneyInv, moneyChoice, "medicin", "strikkeDame");
    }

    public void giveDrawingNiceLady(){
        giveItem(drawingInv,drawingChoice, "tegning", "strikkeDame");
    }

    public void pickBook() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "bog", ""));
        book.setVisible(false);
        bookInv.setOpacity(1.0);
        getTest().seeInventory();
    }

    public void pickScarf() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "halstørklæde", ""));
        scarf.setVisible(false);
        scarfInv.setOpacity(1.0);
        getTest().seeInventory();
    }

}