package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
<<<<<<< HEAD
import javafx.scene.control.TextField;
=======
import javafx.scene.image.ImageView;
>>>>>>> SV
import javafx.stage.Stage;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;

public class RichroomController extends StationController {

    @FXML
<<<<<<< HEAD
    Button library_rich, school_rich, pharmacy_rich, richman;
=======
    Button library_rich, school_rich, pharmacy_rich;
    @FXML
    ImageView money, moneyInv;
>>>>>>> SV

    @FXML
    private TextField text;
    public void talkRichman(){
        richman.getId();
        // Somehow call getCharMessage from Game class with button id as argument. Make sure char name == buttonid
        text.setText("Det er fedt at være rig, men også et ensomt liv. Det ville være rart med en ven."); // set text to getCharMessage return value
    }


    @FXML
    public void seeInventory(){
        getTest().seeInventory();
    }

    @FXML
    public void goPharmacy() throws IOException {
        getTest().goRoom(new Command(CommandWord.GO, "apoteket"));
        Parent loader = FXMLLoader.load(getClass().getResource("pharmacy.fxml"));
        Stage stage = (Stage) pharmacy_rich.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));
    }

    @FXML
    public void goSchool() throws IOException {
        getTest().goRoom(new Command(CommandWord.GO, "skolen"));
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) school_rich.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));
    }

    @FXML
    public void goLibrary() throws IOException {
        getTest().goRoom(new Command(CommandWord.GO, "biblioteket"));
        Parent loader = FXMLLoader.load(getClass().getResource("library.fxml"));
        Stage stage = (Stage) library_rich.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));
    }

    public void pickMoney() {
        getTest().pickUp(new Command(CommandWord.PICKUP , "penge"));
        money.setVisible(false);
        moneyInv.setVisible(true);
        getTest().seeInventory();
    }

    public void removeMoney() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "penge");
        moneyInv.setVisible(false);
        money.setVisible(true);
    }


}
