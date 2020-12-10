package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import worldofzuul.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
    public ImageView money, medicine, apple, book, scarf, drawing, medicineInv, bookInv, appleInv, moneyInv, scarfInv, drawingInv;

    @FXML
    public Button appleToBoy, appleToLady;

    @FXML
    HBox appleChoice, drawingChoice, medicineChoice, scarfChoice, bookChoice, moneyChoice;

    @FXML
    Label text;

    private static ArrayList<String> usedItems = new ArrayList<String>();

    public static ArrayList<String> getUsedItems(){
        return usedItems;
    }

    public static void addUsedItem(String itemName){
        usedItems.add(itemName);
    }
    /*
     *Create .txt file to add name and highscore
     *
     *
     */


    public void Writer() {
            String text = "Some Text, hope it works...";
            BufferedWriter output = null;
            try {
                File file = new File("name and high score.txt");
                output = new BufferedWriter(new FileWriter(file));
                output.write(text);
            } catch ( IOException e ) {
                e.printStackTrace();
            } finally {
                if ( output != null ) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

    }
    /*
    * Initialize items in inventory
    * make items visible in GUI inventory if they exist in Game inventory
     */
    public void init(){
        if (checkInventory("medicin")) {
            medicineInv.setOpacity(1.0);
            medicineInv.setDisable(false);
        }
        if (checkInventory("bog")) {
            bookInv.setOpacity(1.0);
            bookInv.setDisable(false);
        }
        if (checkInventory("æble")) {
            appleInv.setOpacity(1.0);
            appleInv.setDisable(false);
        }
        if (checkInventory("penge")) {
            moneyInv.setOpacity(1.0);
            moneyInv.setDisable(false);
        }
        if (checkInventory("halstørklæde")) {
            scarfInv.setOpacity(1.0);
            scarfInv.setDisable(false);
        }
        if (checkInventory("tegning")) {
            drawingInv.setOpacity(1.0);
            drawingInv.setDisable(false);
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

    public void pickItem(ImageView item, ImageView itemInv, String itemName) {
        getTest().pickUp(new Command(CommandWord.PICKUP, itemName, ""));
        addUsedItem(itemName);
        item.setVisible(false);
        itemInv.setOpacity(1.0);
        itemInv.setDisable(false);
        getTest().seeInventory();
    }

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

    // INTERACT WITH ITEM TO PEOPLE
    public void giveItem(ImageView item, HBox menu, String itemName, String character){
        getTest().processCommand(CommandWord.GIVEITEM, itemName, character);
        item.setOpacity(0.1);
        item.setDisable(true);
        menu.setDisable(true);
        menu.setOpacity(0.0);
        getTest().processCommand(CommandWord.REMOVEITEMS, itemName,"");
    }

    //INTERACT FROM INVENTORY
    public void interactApple(){
        clearMenu();
        text.setText("");
        appleChoice.setDisable(false);
        appleChoice.setVisible(true);
    }

    public void interactDrawing(){
        clearMenu();
        text.setText("");
        drawingChoice.setDisable(false);
        drawingChoice.setVisible(true);
    }

    public void interactMedicine(){
        clearMenu();
        text.setText("");
        medicineChoice.setDisable(false);
        medicineChoice.setVisible(true);
    }

    public void interactScarf(){
        clearMenu();
        text.setText("");
        scarfChoice.setDisable(false);
        scarfChoice.setVisible(true);
    }

    public void interactBook(){
        clearMenu();
        text.setText("");
        bookChoice.setDisable(false);
        bookChoice.setVisible(true);
    }

    public void interactMoney(){
        clearMenu();
        text.setText("");
        moneyChoice.setDisable(false);
        moneyChoice.setVisible(true);
    }

    public void clearMenu(){
        moneyChoice.setDisable(true);
        moneyChoice.setVisible(false);
        bookChoice.setDisable(true);
        bookChoice.setVisible(false);
        scarfChoice.setDisable(true);
        scarfChoice.setVisible(false);
        medicineChoice.setDisable(true);
        medicineChoice.setVisible(false);
        drawingChoice.setDisable(true);
        drawingChoice.setVisible(false);
        appleChoice.setDisable(true);
        appleChoice.setVisible(false);
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
