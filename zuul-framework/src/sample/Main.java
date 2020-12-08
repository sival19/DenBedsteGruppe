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
    public Button appleToBoy;


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
    public void pickMoney(){
        getTest().pickUp(new Command(CommandWord.PICKUP, "penge", ""));
        money.setVisible(false);
        moneyInv.setOpacity(1.0);
        getTest().seeInventory();
    }
    public void pickMedicine() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "medicin", ""));
        medicine.setVisible(false);
        medicineInv.setOpacity(1.0);
        getTest().seeInventory();
    }
    public void pickApple() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "æble", ""));
        apple.setVisible(false);
        appleInv.setOpacity(1.0);
        getTest().seeInventory();
    }
    public void pickBook() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "bog", ""));
        book.setVisible(false);
        bookInv.setOpacity(1.0);
        getTest().seeInventory();
    }
    public void pickScarf() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "halstørklæde", ""));
        scarf.setVisible(false);
        scarfInv.setOpacity(1.0);
        getTest().seeInventory();
    }
    public void pickDrawing() {
        getTest().pickUp(new Command(CommandWord.PICKUP, "tegning", ""));
        drawing.setVisible(false);
        drawingInv.setOpacity(1.0);
        getTest().seeInventory();
    }

    /* Give items
    *
    *
    *
     */

    public void giveAppleBoy(){
        getTest().processCommand(CommandWord.GIEFITEM, "æble", "dreng");
        appleInv.setOpacity(0.1);
        appleChoice.setDisable(false);
        appleChoice.setOpacity(0.0);
        getTest().processCommand(CommandWord.REMOVEITEMS, "æble", "");

    }

    /*Remove items
    *
    *
    *
     */
    public void removeApple() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "æble", "");
        appleInv.setOpacity(0.1);
        apple.setVisible(true);
        appleChoice.setDisable(false);
        appleChoice.setOpacity(0.0);
    }

    public void removeDrawing() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "tegning", "");
        drawingInv.setOpacity(0.1);
        drawing.setVisible(true);
        drawingChoice.setDisable(false);
        drawingChoice.setOpacity(0.0);
    }

    public void removeMedicine() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "medicin", "");
        medicineInv.setOpacity(0.1);
        medicine.setVisible(true);
        medicineChoice.setDisable(false);
        medicineChoice.setOpacity(0.0);
    }

    public void removeScarf(){
        getTest().processCommand(CommandWord.REMOVEITEMS, "halstørklæde", "");
        scarfInv.setOpacity(0.1);
        scarf.setVisible(true);
        scarfChoice.setDisable(false);
        scarfChoice.setOpacity(0.0);
    }

    public void removeBook(){
        getTest().processCommand(CommandWord.REMOVEITEMS,"bog", "");
        bookInv.setOpacity(0.1);
        book.setVisible(true);
        bookChoice.setDisable(false);
        bookChoice.setOpacity(0.0);
    }

    public void removeMoney() {
        getTest().processCommand(CommandWord.REMOVEITEMS, "penge", "");
        moneyInv.setOpacity(0.1);
        money.setVisible(true);
        moneyChoice.setDisable(false);
        moneyChoice.setOpacity(0.0);
    }


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
