package worldofzuul;

public class Player {

    //attributes
    private int points , health;
    private Inventory inventory;
    private Tasks tasks;

    //constructors
    private Player(int points, int health) {
        this.points = points;
        this.health = health;

    }


    //methods


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int totalPoints(int points){
        return getPoints();
    }

    public int totalHealth(int health){
        return getHealth();
    }

    public int addPoints(int points) {
        points = getPoints();
        points += 1; //missing from where to add points and howmany
        return points;

    }
    public int addHealth(int health) {
        health = getPoints();
        health += 1; //missing from where to add health and howmuch
        return health;

    }

}
