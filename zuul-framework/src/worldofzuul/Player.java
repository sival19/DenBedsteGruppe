package worldofzuul;

import java.util.ArrayList;

public class Player {

    //attributes
    private static int points;
    private Inventory inventory;
    private String name;
    int totalPoints;

    //constructors
    public Player(int points, String name) {
        this.points = points;
        this.name = name;
        inventory = new Inventory(new ArrayList<>());
    }

    //methods
    public static int getPoints() {
        return points;
    }

    public static int addPoints(int points) {
        points = getPoints();
        points += 1; //missing from where to add points and howmany
        return points;

    }


    //tilgå inventory
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
