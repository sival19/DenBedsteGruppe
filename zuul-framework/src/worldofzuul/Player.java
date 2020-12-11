package worldofzuul;

import java.util.ArrayList;

/*
 * In this class we create a player with an inventory
 * and totalPoints to keep score.
 * This class also contains methods to access the inventory
 */

public class Player {
    private static int points;
    private Inventory inventory;
    private String name;
    public int totalPoints;

    public Player(int points, String name) {
        this.points = points;
        this.name = name;
        inventory = new Inventory(new ArrayList<>());
    }

    // Access inventory
    public Inventory getInventory() {
        return inventory;
    }

    public void addItem(Item i){
        inventory.addToInventory(i);
    }

    public void removeItems(Item i){
        inventory.removeFromInventory(i);
    }

    public void seeInventory(){
        inventory.printInventory();
    }

}
