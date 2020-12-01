package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import worldofzuul.CommandWord;

import java.io.IOException;

public class PharmacyController extends StationController {

    @FXML Button richroom_pharmacy, station_pharmacy, school_pharmacy;
    @FXML private ImageView medicine;

    public void goRichroom() throws IOException{
        getTest().processCommand(CommandWord.GO, "rigmandsgården");
        Parent loader = FXMLLoader.load(getClass().getResource("richroom.fxml"));
        Stage stage = (Stage) richroom_pharmacy.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));
    }

    public void goSchool() throws IOException{
        getTest().processCommand(CommandWord.GO, "skolen");
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) school_pharmacy.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    public void goStation() throws IOException {

        getTest().processCommand(CommandWord.GO, "stationen");
        Parent loader = FXMLLoader.load(getClass().getResource("stationSecond.fxml"));
        Stage stage = (Stage) station_pharmacy.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    public void handleMouseClicked() {
        getTest().processCommand(CommandWord.PICKUP, "medicin");
        medicine.setVisible(false);
        getTest().seeInventory();

    }
}
