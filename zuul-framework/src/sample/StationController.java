package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import worldofzuul.CommandWord;
import worldofzuul.Game;

import java.io.IOException;

public class StationController {



    private ZuulGame test;

    public ZuulGame getTest() {
        return test;
    }
    @FXML
    public void initialize () {
        test = new Game();

    }

    @FXML
    Button skole_tr, pharmacy_station, pooroom_station;






    @FXML
    public void goSkolen() throws IOException {

        //use command go and go to skolen
        test.processCommand(CommandWord.GO, "skolen");
        Parent loader = FXMLLoader.load(getClass().getResource("school.fxml"));
        Stage stage = (Stage) skole_tr.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goPharmacy() throws IOException{
        test.processCommand(CommandWord.GO, "apoteket");
        Parent loader = FXMLLoader.load(getClass().getResource("pharmacy.fxml"));
        Stage stage = (Stage) pharmacy_station.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goPoorRoom() throws IOException{
        test.processCommand(CommandWord.GO, "fattiggården");
        Parent loader = FXMLLoader.load(getClass().getResource("poorroom.fxml"));
        Stage stage = (Stage) pooroom_station.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));



    }


    @FXML
    public void backpack(){
        test.seeInventory();
    }
}
