package worldofzuul;

import java.util.ArrayList;

public class Character extends InteractiveObjects {

    //Constructor
    public Character(String name, String info) {
        super (name, info);
    }

    @Override
    public String toString() {
        return getName() + ", " + getInfo();
    }






    int Tasks[];
    String InteractWith;
}