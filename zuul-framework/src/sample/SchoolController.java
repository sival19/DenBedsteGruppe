package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SchoolController extends Main implements Initializable {

    @FXML
    private Label text;

    // OBJECT INTERACTION
    public void pickDrawing(){
        pickItem(drawing, drawingInv, "tegning");
    }

    // CHARACTER TALK INTERACTION
    public void talkGirl() {
        clearMenu();
        text.setText("Hej! Mig og nogle andre har tegnet en tegning til den rige mand, vil du give den til ham?" +
                " Vi må ikke gå ind på slottet...");
    }

    public void talkBoy() {
        clearMenu();
        text.setText("Jeg vil så gerne klare mig godt i skolen så jeg kan få en god fremtid, men mine forældre har ikke råd til bøger...");
    }

    // CHARACTER ITEM INTERACTION
    public void giveAppleBoy(){
        giveItem(appleInv, appleChoice,"æble", "skoleDreng");
        text.setText("Tak,men jeg er ikke så sulten lige nu.");
    }

    public void giveAppleGirl(){
        giveItem(appleInv, appleChoice,"æble", "skolePige");
        text.setText("Tak, men jeg er ikke så sulten lige nu.");
    }

    public void giveBookBoy(){
        giveItem(bookInv, bookChoice,"bog", "skoleDreng");
        text.setText("Tak, nu kan jeg endelig følge med i skolen!");
    }

    public void giveBookGirl(){
        giveItem(bookInv, bookChoice,"bog", "skolePige");
        text.setText("Tak, men jeg har masser af bøger jeg kan læse i.");
    }

    public void giveScarfBoy(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "skoleDreng");
        text.setText("Tak, det er fint.");
    }

    public void giveScarfGirl(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "skolePige");
        text.setText("Tak, det er fint.");
    }

    public void giveMoneyBoy(){
        giveItem(moneyInv, moneyChoice,"penge", "skoleDreng");
        text.setText("Tak, dem vil jeg bruge på at købe bøger!");
    }

    public void giveMoneyGirl(){
        giveItem(moneyInv, moneyChoice,"penge", "skolePige");
        text.setText("Tak, men jeg mangler ikke noget lige nu.");
    }

    public void giveDrawingBoy(){
        giveItem(drawingInv, drawingChoice,"tegning", "skoleDreng");
        text.setText("Tak, den er fin!");
    }

    public void giveMedicineBoy(){
        giveItem(medicineInv, medicineChoice,"medicin", "skoleDreng");
        text.setText("Tak, men jeg føler mig ikke syg nu.");
    }

    public void giveMedicineGirl(){
        giveItem(medicineInv, medicineChoice,"medicin", "skolePige");
        text.setText("Tak, men jeg føler mig ikke syg nu.");
    }

    // INVENTORY MANAGEMENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        drawing.setVisible(!checkInventory("tegning") && !getUsedItems().contains("tegning"));
       init();
    }

    // NAVIGATION
    public void goLibrary() throws IOException {
        changeRooms("biblioteket", "library.fxml");
    }

    public void goPharmacy() throws IOException {
        changeRooms("apoteket", "pharmacy.fxml");
    }

    public void goRichRoom() throws IOException {
        changeRooms("rigmandsrum", "richroom.fxml");
    }

    public void goPoorroom() throws IOException {
        changeRooms("fattiggården", "poorroom.fxml");
    }

    public void goStation() throws IOException {
        changeRooms("stationen", "station.fxml");
    }
}
