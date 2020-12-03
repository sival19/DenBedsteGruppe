package worldofzuul;

import java.util.ArrayList;

public class Characters extends InteractiveObjects {

    //Array of the different types
    String [] itemNeed = {"edible", "currency", "medical", "material"};

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



