package worldofzuul;
import java.util.ArrayList;

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

    //remove items from inventory
    public void removeFromInventory(Item item) {
        items.remove(item);
    }

    //see the inventory
    public void printInventory() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println(" - " + item);
        }
    }
}
