package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import worldofzuul.Command;
import worldofzuul.CommandWord;

import java.io.IOException;

public class SchoolController extends StationController {

    public Button bib_skole, pharmacy_school, richroom_school, pooroom_school, station_school;

    @FXML
    public void goLibrary() throws IOException {

        // go library button
        getTest().goRoom(new Command(CommandWord.GO, "biblioteket"));
        Parent loader = FXMLLoader.load(getClass().getResource("library.fxml"));
        Stage stage = (Stage) bib_skole.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goPharmacySchool() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "apoteket"));
        Parent loader = FXMLLoader.load(getClass().getResource("pharmacy.fxml"));
        Stage stage = (Stage) pharmacy_school.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }

    @FXML
    public void goRichRoomSchool() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "rigmandsgården"));
        Parent loader = FXMLLoader.load(getClass().getResource("richroom.fxml"));
        Stage stage = (Stage) richroom_school.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }
    @FXML
    public void goPoorroomSchool() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "fattiggården"));
        Parent loader = FXMLLoader.load(getClass().getResource("poorroom.fxml"));
        Stage stage = (Stage) pooroom_school.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }
//made new station FXML, cant load new scene with stage :(
    @FXML
    public void goStationSchool() throws IOException{
        getTest().goRoom(new Command(CommandWord.GO, "stationen"));
        Parent loader = FXMLLoader.load(getClass().getResource("station.fxml"));
        Stage stage = (Stage) station_school.getScene().getWindow();

        stage.setScene(new Scene(loader, 731, 439));

    }
}
