package worldofzuul;

import java.util.ArrayList;

public class Inventory {
    Item items[] = new Item[5];

    public Item[] getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            items[i] = item;
        }
    }

    public void printInventory() {
        System.out.println("Inventory: ");

        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.printInventory();

        Item i1 = new Item("apple", "er sød");
        Item i2 = new Item("pear", "er sød");
        Item i3 = new Item("noget", "er sød");
        Item i4 = new Item("Nadia", "er sød");

        inventory.addItem(i1);
        inventory.addItem(i2);
        inventory.addItem(i3);
        inventory.addItem(i4);

        inventory.printInventory();
    }
}
