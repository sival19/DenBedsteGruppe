package worldofzuul;

public class Item extends InteractiveObjects {
    int id; //items2

    //Constructor
    public Item(String name, String info, int id){
        super (name,info);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return getName() + ", " + getInfo();
    }

}
