package worldofzuul;
import java.util.ArrayList;

/*
 * In this class we create an inventory to keep track of
 * which items the player has picked up.
 * This class has methods to access inventory which are
 * also used in the Player class.
 */

public class Inventory {
    private static ArrayList<Item> items;

    Inventory(ArrayList<Item> items) {
        Inventory.items = items;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public void addToInventory(Item item){
        items.add(item);
    }

    public void removeFromInventory(Item item) {
        items.remove(item);
    }

    public void printInventory() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println(" - " + item);
        }
    }
}
