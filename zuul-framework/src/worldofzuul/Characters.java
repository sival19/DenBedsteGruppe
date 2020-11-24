package worldofzuul;

import java.util.ArrayList;

public class Characters extends InteractiveObjects {

    //Constructor
    public Characters(String name, String info) {
        super (name, info);
    }

    @Override
    public String toString() {
        return getName() + ", " + getInfo();
    }






    int Tasks[];
    String InteractWith;
}