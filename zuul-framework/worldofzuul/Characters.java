package worldofzuul;

import java.util.ArrayList;
import java.util.List;

public class Characters extends InteractiveObjects {


    //characters constructor
    public Characters(String name, String info) {
        super(name, info);

    }

    @Override
    public String toString() {
        return getName() + ", " + getInfo();
    }

}