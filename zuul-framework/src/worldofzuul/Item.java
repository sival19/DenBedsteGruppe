package worldofzuul;
/*
 * In this class we create Item-objects.
 * Item extends InteractiveObjects and we use
 * some attributes from InteractiveObjects
 *
 */
public class Item extends InteractiveObjects {

    public Item(String name, String info){
        super (name,info);
    }

    @Override
    public String toString() {
        return getName() + ": " + getInfo();
    }
}