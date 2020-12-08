package worldofzuul;

import java.util.ArrayList;

public class Player {

    //attributes
    public static int points;
    private static int health;
    private Inventory inventory;
    private String name;
    int totalPoints;

    //constructors
    public Player(int points, int health, String name) {
        this.points = points;
        this.health = health;
        this.name = name;
        inventory = new Inventory(new ArrayList<>());
    }

    //methods
    public static int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public static int getHealth() {
        return health;
    }

   /* public void setHealth(int health) {
        this.health = health;
   }
   */

    public int totalPoints(int points) {
        return getPoints();
    }


    public int getTotalPoints()
    {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    //medtode tilføje/fjerne health
    public static int addHealth(int health) {
        health = 100;
        health += 1; //missing from where to add health and howmuch
        return health;

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
