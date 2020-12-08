package worldofzuul;

import sample.ZuulGame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game implements ZuulGame {
    private Parser parser;
    private Room currentRoom;
    private Player player;

    public Game() {
        createRooms();
        parser = new Parser();
        player = new Player(0, 0, "Palle");
    }

    // Get message from character info. Search by name
    public String getCharMessage(String charName) {
        ArrayList<Character> characters = currentRoom.getCharacters();
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).name.equals(charName)) {
                return characters.get(i).info;
            }
        }
        return "";
    }


    //see characters
    private void seeCharacters() {
        System.out.println(currentRoom.getCharacters());
    }


    private void seeItems() {
        System.out.println(currentRoom.getItems());
    }

    public void seeInventory() {

        player.seeInventory();

    }

    public void giveItem(Command c) {

        if (!c.hasSecondWord()) {
            System.out.println("Hvad vil du give væk?");
            return;
        }
        String secondWord = c.getSecondWord();

        Item item = new Item("", "", 0);
        Rewards rewards = new Rewards("", "", 0);

        int itemType;
        int itemNeed;

        //    int itemNeed = rewards.itemNeed;

        for (Item i: this.player.getInventory().getItems()) {
            itemType = i.itemType;
            break;
        }

        for (Character i: this.currentRoom.getCharacters())
        {
            itemNeed = i.itemNeed;
            break;
        }


        rewards.gainPoints();

        int points = (int) rewards.gainPoints;

        System.out.println(points);

        Item itemGiven = null;
        for (Item j : this.player.getInventory().getItems()) {
            String itemName = j.getName();

            if (secondWord.equals(itemName)) {
                itemGiven = j;
                break;
            }
        }
    }

    //remove items from inventory
    private void remove(Command c) {
        if (!c.hasSecondWord()) {
            System.out.println("hvad vil du fjerne?");
            return;
        }

        //Her fra ved vi at der er et Second Word
        String secondWord = c.getSecondWord();
        Item itemToRemove = null;
        for (Item i : this.player.getInventory().getItems()) {
            String itemName = i.getName();

            if (secondWord.equals(itemName)) {
                itemToRemove = i;
                break;
            }
        }

        if (itemToRemove != null) {
            currentRoom.addItem(itemToRemove);
            player.removeItems(itemToRemove);
            System.out.println(itemToRemove.getName() + " fjernet fra tasken ");
        } else {
            System.out.println("Det indtastede item blev ikke fundet.");
        }
    }

    //make a method to pickup
    public void pickUp(Command c) {
        if (!c.hasSecondWord()) {
            System.out.println("hvad vil du samle op??");
            return;
        }

        //Her fra ved vi at der er et Second Word
        String secondWord = c.getSecondWord();
        Item itemToAdd = null;
        for (Item i : this.currentRoom.getItems()) {
            String itemName = i.getName();

            if (secondWord.equals(itemName)) {
                itemToAdd = i;
                break;
            }
        }

        if (itemToAdd != null) {
            player.addItem(itemToAdd);
            currentRoom.removeItem(itemToAdd);
            System.out.println(itemToAdd.getName() + " tilføjet til inventory ");
        } else {
            System.out.println("Det indtastede item blev ikke fundet.");
        }
    }


    public void createRooms() {
        // Create rooms
        Room station, skole, bibliotek, restaurant, fattiggård, rigmandsgården, apotek;

        station = new Room("på stationen");
        skole = new Room("på skolen");
        bibliotek = new Room("på biblioteket");
        restaurant = new Room("på restauranten");
        fattiggård = new Room("på fattiggården");
        rigmandsgården = new Room("på rigmandsgården");
        apotek = new Room("på apoteket");

        // Create room relationships
        //added all exits to station, to make it work in GUI
        station.setExit("apoteket", apotek);
        station.setExit("skolen", skole);
        station.setExit("fattiggården", fattiggård);


        skole.setExit("stationen", station);
        skole.setExit("rigmandsgården" , rigmandsgården);
        skole.setExit("biblioteket", bibliotek);
        skole.setExit("apoteket", apotek);
        skole.setExit("fattiggården", fattiggård);

        bibliotek.setExit("rigmandsgården", rigmandsgården);
        bibliotek.setExit("skolen", skole);

        restaurant.setExit("stationen", station);

        fattiggård.setExit("skolen", skole);
        fattiggård.setExit("stationen", station);

        rigmandsgården.setExit("skolen", skole);
        rigmandsgården.setExit("biblioteket", bibliotek);
        rigmandsgården.setExit("apoteket" , apotek);


        apotek.setExit("rigmandsgården" , rigmandsgården);
        apotek.setExit("stationen", station);
        apotek.setExit("skolen", skole);

        currentRoom = station;

        // Create items
        Item æble, penge, medicin, bog;

        æble = new Item("æble", "det er rødt", 0);
        penge = new Item("penge", "der er mange", 1);
        medicin = new Item("medicin", "det er piller",2 );
        bog = new Item("bog", "den er tung",3 );

        // Add items to rooms
        station.addItem(æble);
        bibliotek.addItem(penge);
        skole.addItem(medicin);
        restaurant.addItem(bog);
        fattiggård.addItem(æble);
        rigmandsgården.addItem(bog);

        //create characters
        Character waiter, boy, richSnob, poorFuck;

        waiter = new Character("tjener", "bestikslav", 0);
        boy = new Character("dreng", "lille stakkel", 1);
        richSnob = new Character("onkel Joachim", "lidt for rig", 2);
        poorFuck = new Character("Total hjemløs", "så syg...", 3);

        //add characters to rooms

        skole.addCharacter(boy);
        restaurant.addCharacter(waiter);
        rigmandsgården.addCharacter(richSnob);
        fattiggård.addCharacter(poorFuck);
    }


    public void play() {
        printWelcome();


        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }


    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    //makes it possible to simply write what command and what to do in it in GUI
    public boolean processCommand(CommandWord commandWord, String secondWord, String thirdWord) {
        return processCommand(new Command(commandWord, secondWord, thirdWord));
    }


    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.SEEITEMS) {
            seeItems();
        } else if (commandWord == CommandWord.PICKUP) {
            pickUp(command);
        } else if (commandWord == CommandWord.SEEINVENTORY) {
            seeInventory();
        } else if (commandWord == CommandWord.REMOVEITEMS)
            remove(command);
        else if (commandWord == CommandWord.SEECHARACTERS) {
            seeCharacters();
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.GIEFITEM) {
            giveItem(command);
        }

        return wantToQuit;
    }




    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    public void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
