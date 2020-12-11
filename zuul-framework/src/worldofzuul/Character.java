package worldofzuul;

import java.util.ArrayList;

public class Character extends InteractiveObjects {
    private ArrayList<String> wantedItems;
    private ArrayList<String> lessWantedItems;

    //Constructor
    public Character(String name, String info, ArrayList<String> wantedItems, ArrayList<String> lessWantedItems) {
        super (name, info);
        this.wantedItems = wantedItems;
        this.lessWantedItems = lessWantedItems;
    }

    @Override
    public String toString() {
        return getName() + ": " + getInfo();
    }

    public ArrayList<String> getWantedItems() {
        return wantedItems;
    }
    public ArrayList<String> getLessWantedItems () {
        return lessWantedItems;
    }
}



