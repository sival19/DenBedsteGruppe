package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import worldofzuul.*;
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
        book.setVisible(!checkInventory("bog"));
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
    public void removeBook() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "bog");
        bookInv.setOpacity(0.1);
        book.setVisible(true);
    }
}