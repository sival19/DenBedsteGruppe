package worldofzuul;
import java.util.ArrayList;

//HEJ DETTE ER EN TEST!!!!!

public class Inventory {
    private ArrayList<Item> items;

    Inventory(ArrayList<Item> items) {
        this.items = items;
    }



    //add items to inventory


    public ArrayList<Item> getInventoryList() {
        return items;
    }

    public void addToInventory(Item item){
        items.add(item);
    }

    //remove items from inventory
    public void removeItem(Item item) {
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
