package worldofzuul;
import java.util.Arrays;
import java.util.ArrayList;

public class Inventory {
    //Item items[] = new Item[5];
    ArrayList<Item> items2 = new ArrayList<Item>();

    /*public Item[] getItems() {
        return this.items;
    }*/

    public ArrayList<Item> getItems() {
        return this.items2;
    }

    /*public void removeItem(int index){
        items[index] = null;
    }*/

    public void removeItem2(Item item) {
        items2.remove(item);
    }

    /*public void addItem(Item item, int index) { //Tilføjer index, så vi ved hvor items skal ligge i listen
            items[index] = item;
    }*/

    public void addItem2(Item item) {
        if (items2.size() < 5) {
            items2.add(item);
        } else {
            System.out.println("Inventory full");
        }
    }

    public void printInventory() {
        System.out.println("Inventory: ");

        for (Item item : items2) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        //To test
        inventory.printInventory();

        Item i1 = new Item("apple", "er sød", 0);
        Item i2 = new Item("pear", "er sød",1);
        Item i3 = new Item("noget", "er sød",2);
        Item i4 = new Item("Nadia", "er sød",3);
        Item i5 = new Item("jeg", "er sød",4);

        inventory.addItem2(i1);
        inventory.addItem2(i2);
        inventory.addItem2(i3);
        inventory.addItem2(i4);
        inventory.addItem2(i5);


        inventory.printInventory();

        inventory.addItem2(i5);
        inventory.removeItem2(i3);

        inventory.printInventory();
    }
}
