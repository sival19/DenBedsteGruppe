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



    //forsøg på at lave en genbrugelig skifte rum metode!
    //tager String som room name, String til fxmlfil og Button til knap
    public void changeRooms(String roomName, String fxmlFile, Button button) throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, roomName));
        Parent loader = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) button.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }





    @FXML
    Button skole_tr, pharmacy_station, pooroom_station;


//forsøg på at skifte rum med den tidligere metode...meeeen virker ikke!!!
    @FXML
    public void goSkolen() throws IOException {

        //use command go and go to skolen
        //skolen school.fxml skole_tr
        changeRooms("skolen", "school.fxm", skole_tr);

    }

    //den her metode virker til at skifte rum med!
    @FXML
    public void goPharmacy() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "apoteket"));
        Parent loader = FXMLLoader.load(getClass().getResource("pharmacy.fxml"));
        Stage stage = (Stage) pharmacy_station.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goPoorRoom() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "fattiggården"));
        Parent loader = FXMLLoader.load(getClass().getResource("poorroom.fxml"));
        Stage stage = (Stage) pooroom_station.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));



    }


    @FXML
    public void backpack(){
        getTest().seeInventory();
    }
}
