package worldofzuul;

public class Character extends InteractiveObjects {

    //Constructor
    public Character(String name, String info, int i) {
        super (name, info, i);
    }

    @Override
    public String toString() {
        return getName() + ", " + getInfo();
    }


    int Tasks[];
    String InteractWith;
}