package worldofzuul;

public class Item extends InteractiveObjects {
    int id; //items2

    //Constructor
    public Item(String name, String info, int id){
        super (name,info);
    }

    @Override
    public String toString() {
        return "noget " + getName() + " " + getInfo() + " noget";
    }

}
