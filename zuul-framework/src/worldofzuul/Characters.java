package worldofzuul;

import java.util.ArrayList;

public class Characters extends InteractiveObjects {

    //Constructor
    public Characters(String name, String info, int itemNeed) {
        super (name, info, itemNeed);
    }

    @Override
    public String toString() {
        return getName() + ", " + getInfo();
    }


    int Tasks[];
    String InteractWith;
}



