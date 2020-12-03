package worldofzuul;

import java.lang.reflect.Array;

public class Rewards extends InteractiveObjects {

    Item item = new Item(name, info, itemType);
    Character character = new Character(name, info, 1);

    //Points you begin with
    final int initialPoints = 100;
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
        int i = itemType;
        int j = itemNeed;

        int itemType = Array.getInt(item.type, i);
        int personNeeds = Array.getInt(item.type, j);
//        int junk = Character.junk;

        double pointsModifier;


        if(itemType == personNeeds){

            pointsModifier = 2.0;

//        }else if (itemType == junk)
//        {
            pointsModifier = 0.5;
        }else // Hvis det ikke er JUNK (aka semi needed)
        {
            pointsModifier = 1.0;
        }

        gainPoints = initialPoints * pointsModifier;


     return gainPoints();
    }
}
