package worldofzuul;

public class Item extends InteractiveObjects {

    //Constructor
    public Item(String name, String info){
        super (name,info);
    }

    @Override
    public String toString() {
        return getName() + ": " + getInfo();
    }
}