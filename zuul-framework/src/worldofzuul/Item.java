package worldofzuul;

public class Item extends InteractiveObjects {


    //Constructor
    public Item(String name, String info, int itemType){
        super (name,info, itemType);
    }


    @Override
    public String toString() {
        return getName() + ": " + getInfo();
    }

    public int getItemType()
    {
        return itemType;
    }

}