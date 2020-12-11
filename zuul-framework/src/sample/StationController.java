package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StationController extends Main implements Initializable {


    @FXML
    private Label text;

    // CHARACTER INTERACTION
    public void talkWizard() {
        text.setText("Godt du klikkede, " + getName() + "! Tænk dig om når du spiller, hvem har brug for hvad? Klik på manden til højre. Mon han har brug for hjælp?");
    }

    // CHARACTER INTERACTION
    public void talkMan() {
        text.setText("Jeg har mistet alt og nu bor jeg her på gaden... Har du måske lidt penge du kan undvære?");
    }


    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }


    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }

    public void goPoorRoom() throws IOException {
        changeRooms("fattiggården", "poorroom.fxml");
    }


    // OBJECT INTERACTION

    public void giveAppleStationMan() {
        giveItem(appleInv, appleChoice, "æble", "hjemløsMand");
        text.setText("Tak!");
    }

    public void giveBookStationMan() {
        giveItem(bookInv, bookChoice, "bog", "hjemløsMand");
        text.setText("Tak!");
    }

    public void giveScarfStationMan() {
        giveItem(scarfInv, scarfChoice, "halstørklæde", "hjemløsMand");
        text.setText("Tak!");
    }

    public void giveDrawingStationMan() {
        giveItem(drawingInv, drawingChoice, "tegning", "hjemløsMand");
        text.setText("Tak!");
    }

    public void giveMedicineStationMan() {
        giveItem(medicineInv, medicineChoice, "medicin", "hjemløsMand");
        text.setText("Tak!");
    }

    public void giveMoneyStationMan() {
        giveItem(moneyInv, moneyChoice, "penge", "hjemløsMand");
        text.setText("Tak!");
    }
}
