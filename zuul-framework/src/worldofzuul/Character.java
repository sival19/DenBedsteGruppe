package worldofzuul;

import java.util.ArrayList;

/*
 * In this class we create a character with wanted items
 * and less wanted items. This is to deal out points based
 * on the players actions.
 * 
 */

public class Character extends InteractiveObjects {
    private ArrayList<String> wantedItems;
    private ArrayList<String> lessWantedItems;

    public Character(String name, String info, ArrayList<String> wantedItems, ArrayList<String> lessWantedItems) {
        super (name, info);
        this.wantedItems = wantedItems;
        this.lessWantedItems = lessWantedItems;
    }

    public ArrayList<String> getWantedItems() {
        return wantedItems;
    }

    public ArrayList<String> getLessWantedItems () {
        return lessWantedItems;
    }

    @Override
    public String toString() {
        return getName() + ": " + getInfo();
    }
}



