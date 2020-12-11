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
        text.setText("Godt du klikkede, " + getName() + "! Husk at tænk dig om når du spiller, hvem har brug for hvad? Klik på manden til venstre. Mon han har brug for hjælp?");
    }

    // CHARACTER INTERACTION
    public void talkSickboy() {
        text.setText("Jeg er syg, men jeg har ikke råd til medicin. ");
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
        changeRooms("gaden", "poorroom.fxml");
    }


    // OBJECT INTERACTION

    public void giveMedicineSick(){
        giveItem(medicineInv, medicineChoice,"medicin", "sygMand");
        text.setText("Tusind tak " +getName()+"! Nu kan det være jeg endelig får det bedre!");
    }

    public void giveDrawingSick(){
        giveItem(drawingInv, drawingChoice,"tegning", "sygMand");
        text.setText("Tak " +getName()+"... *host* det er en fin tegning! *host* puha jeg har det skidt...");
    }

    public void giveMoneySick(){
        giveItem(moneyInv, moneyChoice,"penge", "sygMand");
        text.setText("Tak " +getName()+", nu kan det måske være jeg har råd til at købe noget medicin.");
    }

    public void giveScarfSick(){
        giveItem(scarfInv, scarfChoice,"halstørklæde", "sygMand");
        text.setText("Tak " +getName()+"... *host* det gør mig nok ikke rask, men det kan holde mig varm *host* ");
    }

    public void giveBookSick(){
        giveItem(bookInv, bookChoice,"bog", "sygMand");
        text.setText("Tak " +getName()+"... *host* kan være jeg kan læse den når jeg får det bedre *host* ");
    }

    public void giveAppleSick(){
        giveItem(appleInv, appleChoice,"æble", "sygMand");
        text.setText("Tak " +getName()+ "... *host* jeg har det dog lidt for dårligt til at spise, men jeg gemmer det til senere *host* ");
    }






































}
