package worldofzuul;

import java.util.ArrayList;

public class Character extends InteractiveObjects {
    private ArrayList<String> wantedItems;

    //Constructor
    public Character(String name, String info, ArrayList<String> wantedItems) {
        super (name, info);
        this.wantedItems = wantedItems;
    }

    @Override
    public String toString() {
        return getName() + ": " + getInfo();
    }

    public ArrayList<String> getWantedItems() {
        return wantedItems;
    }
}



