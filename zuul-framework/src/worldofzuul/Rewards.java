package worldofzuul;

import java.lang.reflect.Array;

public class Rewards extends InteractiveObjects {

    Item item = new Item(name, info, 1);
    Characters characters = new Characters(name, info, 1);

    //Points you begin with
    final int initialPoints = 10;
    double gainPoints;



    //Item constructor
    public Rewards (String name, String info, int itemType) {
        super(name, info, itemType);
    }

//    //itemNeed constructor
//    public itemNeed (String name, String info, int itemNeed) {
//        super(name, info, itemNeed);
//    }



    //Method for gaining points
    public int gainPoints() {

        int pointsModifier;

        if (item.itemType == characters.itemType)
        {
            pointsModifier = 2;
        } else
        {
            pointsModifier = 1;
        }

        gainPoints = initialPoints * pointsModifier;

    return (int) gainPoints;
    }
}
