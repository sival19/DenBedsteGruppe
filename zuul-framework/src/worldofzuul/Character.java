package worldofzuul;

public class Character extends InteractiveObjects {

    //Constructor
    public Character(String name, String info, int itemNeed) {
        super (name, info, itemNeed);
    }

    @Override
    public String toString() {
        return getName() + ", " + getInfo();
    }


    int Tasks[];
    String InteractWith;
}



