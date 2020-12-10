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
        text.setText("God du klikkede! Husk nu at tænke dig om når du spiller spillet,"
        + " hvem har brug for hvad? Prøv at klikke på manden ude til højre, han ligner en der har brug for hjælp.");
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

    public void goPharmacy() throws IOException {
        changeRooms("apoteket", "pharmacy.fxml");
    }

    public void goSchool() throws IOException {
        changeRooms("skolen", "school.fxml");
    }

    public void goPoorRoom() throws IOException {
        changeRooms("fattiggården", "poorroom.fxml");
    }


    // OBJECT INTERACTION

    public void giveAppleStationMan () {
        giveItem (appleInv, appleChoice, "æble", "hjemløs Mand");
        text.setText("Tak!");
    }
    public void giveBookStationMan () {
        giveItem (bookInv, bookChoice, "bog", "hjemløs Mand");
        text.setText("Tak!");
    }
    public void giveScarfStationMan () {
        giveItem (scarfInv, scarfChoice, "halsterklæde", "hjemløs Mand");
        text.setText("Tak!");
    }
    public void giveDrawingStationMan () {
        giveItem (drawingInv, drawingChoice, "tegning", "hjemløs Mand");
        text.setText("Tak!");
    }
    public void giveMedicineStationMan () {
        giveItem (medicineInv, medicineChoice, "medicin", "hjemløs Mand");
        text.setText("Tak!");
    }
    public void giveMoneyStationMan () {
        giveItem (moneyInv, moneyChoice, "penge", "hjemløs Mand");
        text.setText("Tak!");
    }
}
