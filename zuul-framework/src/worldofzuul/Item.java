package worldofzuul;

public class Item extends InteractiveObjects {

    //Array of the different types
    String [] type = {"edible", "currency", "medical", "material"};



    //Constructor
    public Item(String name, String info, int itemType){
        super (name,info, itemType);
    }


    @Override
    public String toString() {
        return getName() + ", " + getInfo();
    }

    public int getItemType()
    {
        itemType = itemType;
        return itemType;
    }

}