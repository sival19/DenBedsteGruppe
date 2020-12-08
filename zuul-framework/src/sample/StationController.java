package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import worldofzuul.Command;
import worldofzuul.CommandWord;
import worldofzuul.CommandWords;
import worldofzuul.Game;

import java.io.IOException;

public class StationController extends Main {





    @FXML
    Button skole_tr, pharmacy_station, pooroom_station;






    @FXML
    public void goSkolen() throws IOException {

        //use command go and go to skolen
        getTest().goRoom(new Command(CommandWord.GO, "skolen",""));
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) skole_tr.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goPharmacy() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "apoteket",""));
        Parent loader = FXMLLoader.load(getClass().getResource("pharmacy.fxml"));
        Stage stage = (Stage) pharmacy_station.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goPoorRoom() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "fattiggården",""));
        Parent loader = FXMLLoader.load(getClass().getResource("poorroom.fxml"));
        Stage stage = (Stage) pooroom_station.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));



    }


    @FXML
    public void backpack(){
        getTest().seeInventory();
    }
}
