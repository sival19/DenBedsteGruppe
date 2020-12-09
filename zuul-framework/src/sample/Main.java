package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import worldofzuul.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    private static ZuulGame test;
    private static Stage stage;

    /*
    * Each instance of main (when a controller extends main)
    * get their own fields/attributes. So the game knows which fxml-file's
    * ImageView id's the methods refer to.
    * This is why we only need the fields in main.
     */
    @FXML
    public ImageView money, medicine, apple, book, scarf, drawing,  medicineInv, bookInv, appleInv, moneyInv, scarfInv, drawingInv;

    @FXML
    public Button appleToBoy, appleToLady;


    @FXML
    HBox appleChoice, drawingChoice, medicineChoice, scarfChoice, bookChoice, moneyChoice;

    /*
    * Initialize items in inventory
    * make items visible in GUI inventory if they exist in Game inventory
     */
    public void init(){
        if (checkInventory("medicin")) {
            medicineInv.setOpacity(1.0);
        }
        if (checkInventory("bog")) {
            bookInv.setOpacity(1.0);
        }
        if (checkInventory("æble")) {
            appleInv.setOpacity(1.0);
            appleInv.setDisable(false);
        }
        
        if (checkInventory("penge")) {
            moneyInv.setOpacity(1.0);
        }
        if (checkInventory("halstørklæde")) {
            scarfInv.setOpacity(1.0);
        }
        if (checkInventory("tegning")) {
            drawingInv.setOpacity(1.0);
        }
    }

    public ZuulGame getTest() {
        return test;
    }

    public static Stage getStage() {
        return stage;
    }

    /*
    * First line is for ICL. It makes sure we know which room
    * we are in so we can update inventory correctly.
    *
    * We load the scene from file and create a new scene,
    * to make sure the initialize method is run, which is needed
    * to keep track of game state (room items and inventory).
     */
    public void changeRooms(String roomName, String filepath) throws IOException {
        getTest().goRoom(new Command(CommandWord.GO, roomName, ""));
        Parent loader = FXMLLoader.load(getClass().getResource(filepath));
        stage.setScene(new Scene(loader));
    }
    /*
    * Checks if item is in Game inventory
     */
    public boolean checkInventory(String itemName) {
        ArrayList<Item> items = Inventory.getItems();
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    // OBJECT INTERACTION
    /*
    * We can use the same method to pick up items in all controllers.
    * They are inherited from main.
     */

    //PICKUP



    /* Give items
    *
    *
    *
     */



    /*Remove items
    *
    *
    *
     */



    //INTERACT

    public void interractApple(){
        appleChoice.setDisable(false);
        appleChoice.setOpacity(1.0);
    }

    public void interactDrawing(){
        drawingChoice.setDisable(false);
        drawingChoice.setOpacity(1.0);

    }

    public void interractMedicine(){
        medicineChoice.setDisable(false);
        medicineChoice.setOpacity(1.0);
    }

    public void interractScarf(){
        scarfChoice.setDisable(false);
        scarfChoice.setOpacity(1.0);
    }

    public void interractBook(){
        bookChoice.setDisable(false);
        bookChoice.setOpacity(1.0);
    }

    public void interractMoney(){
        moneyChoice.setDisable(false);
        moneyChoice.setOpacity(1.0);
    }

    // START GAME
    @Override
    public void start(Stage stage_dummy) throws Exception {
        stage = FXMLLoader.load(getClass().getResource("startPage.fxml"));
        stage.show();
    }

    public static void main(String[] args) {
        test = new Game();
        launch(args);
    }
}
