package worldofzuul;

import sample.ZuulGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Game implements ZuulGame {
    private Parser parser;
    private Room currentRoom;
    private Player player;


    public Game() {
        createRooms();
        parser = new Parser();
        player = new Player(0, "Palle");
    }

    //see characters
    private void seeCharacters() {
        System.out.println(currentRoom.getCharacters());
    }

    // See items
    private void seeItems() {
        System.out.println(currentRoom.getItems());
    }

    // See player
    public Player getPlayer() {
        return this.player;
    }

    public void seeInventory() {
        player.seeInventory();
    }

    // Method to give item and receive points
    public void giveItem(Command c) {
        if (c.hasSecondWord()) {
            if (c.hasThirdWord()) {

                String secondWord = c.getSecondWord();

                //what is third word for?
                String thirdWord = c.getThirdWord();

                // Checks for the specific item (typed by the player) in the players inventory
                for (Item i : Inventory.getItems()) {
                    String itemName = i.getName();

                    for (Character j : this.currentRoom.getCharacters()) {
                        String CharName = j.getName();

                        // Checks if the specific item typed is in the player inventory
                        if (secondWord.equals(itemName) && thirdWord.equals(CharName)) {

                            int pointsModifier;
                            int points;
                            int initialPoints = 10;

                            if (j.getWantedItems().contains(i.name)) {
                                pointsModifier = 2;
                            } else if (j.getLessWantedItems().contains(i.name)) {
                                pointsModifier = 0;
                            }
                            else {
                                pointsModifier = 1;
                            }

                            // If types is equivalent, get 2x points
                            // If types is not equivalent, get 1x points
                            points = initialPoints * pointsModifier;

                            // adder points til players total points
                            player.totalPoints += points;

                            System.out.println("Du fik: " + points + " point");
                            System.out.println("Du har nu: " + player.totalPoints + " points i alt");
                        }
                    }
                }
            } else {
                System.out.println("Prøv igen");
            }
        }
    }

    //remove items from inventory
    private void remove(Command c) {
        if (!c.hasSecondWord()) {
            System.out.println("Hvad vil du fjerne?");
            return;
        }

        //Acts on a second word
        String secondWord = c.getSecondWord();
        Item itemToRemove = null;
        for (Item i : Inventory.getItems()) {
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

    //A method to pickup
    public void pickUp(Command c) {
        if (!c.hasSecondWord()) {
            System.out.println("Hvad vil du samle op??");
            return;
        }

        //Acts on a second word
        String secondWord = c.getSecondWord();
        Item itemToadd = null;
        for (Item i : this.currentRoom.getItems()) {
            String itemName = i.getName();

            if (secondWord.equals(itemName)) {
                itemToadd = i;
                break;
            }
        }

        if (itemToadd != null) {
            player.addItem(itemToadd);
            currentRoom.removeItem(itemToadd);
            System.out.println(itemToadd.getName() + " tilføjet til inventory ");
        } else {
            System.out.println("Det indtastede item blev ikke fundet.");
        }
    }

    public void createRooms() {
        // Create rooms
        Room station, school, library, poorroom, richroom, pharmacy;

        station = new Room("på stationen");
        school = new Room("på skolen");
        library = new Room("på biblioteket");
        poorroom = new Room("på fattiggården");
        richroom = new Room("på rigmandsrum");
        pharmacy = new Room("på apoteket");

        // Create room relationships
        //added all exits to station, to make it work in GUI
        station.setExit("skolen", school);
        station.setExit("fattiggården", poorroom);

        school.setExit("stationen", station);
        school.setExit("biblioteket", library);
        school.setExit("fattiggården", poorroom);

        library.setExit("rigmandsrum", richroom);
        library.setExit("skolen", school);


        poorroom.setExit("skolen", school);
        poorroom.setExit("stationen", station);
        poorroom.setExit("apoteket", pharmacy);
        poorroom.setExit("rigmandsrum", richroom);

        richroom.setExit("fattiggården", poorroom);
        richroom.setExit("biblioteket", library);

        pharmacy.setExit("fattiggården", poorroom);


        currentRoom = station;

        // Create items
        Item apple, money, medicine, book, drawing, scarf;

        apple = new Item("æble", "det er rødt");
        scarf = new Item("halstørklæde", "den er varm");
        drawing = new Item("tegning", "den er tegnet af pigen");
        money = new Item("penge", "der er mange");
        medicine = new Item("medicin", "det er piller");
        book = new Item("bog", "den er tung");

        // Add items to rooms
        pharmacy.addItem(medicine);
        library.addItem(scarf);
        richroom.addItem(apple);
        richroom.addItem(money);
        library.addItem(book);
        school.addItem(drawing);

        // Create characters
        Character poorBoy, poorLady, schoolGirl, schoolBoy, richMan, wizard, knittingLady, homelessMan, sickMan;

        poorBoy = new Character("fattigDreng", "lille stakkel", new ArrayList<>(Arrays.asList("æble", "penge")), new ArrayList<>(Arrays.asList("tegning")));
        poorLady = new Character("fattigDame", "Hun fryser", new ArrayList<>(Arrays.asList("halstørklæde", "penge")), new ArrayList<>(Arrays.asList("tegning")));
        schoolBoy = new Character("skoleDreng", "han er ked af det", new ArrayList<>(Arrays.asList("bog", "penge")), new ArrayList<>(Arrays.asList("tegning")));
        schoolGirl = new Character("skolePige", "hun ser glad ud", new ArrayList<>(), new ArrayList<>(Arrays.asList("tegning")));
        wizard = new Character("troldmand", "Han er mystisk", new ArrayList<>(), new ArrayList<>());
        homelessMan = new Character("hjemløsMand", "han ser hjemløs ud", new ArrayList<>(Arrays.asList("penge")), new ArrayList<>(Arrays.asList("tegning", "bog")));
        richMan = new Character("rigmand", "lidt for rig", new ArrayList<>(Arrays.asList("tegning")), new ArrayList<>(Arrays.asList("halsterklæde")));
        knittingLady = new Character("strikkeDame", "Hun strikker halstørklæder", new ArrayList<>(), new ArrayList<>());
        sickMan = new Character("sygMand", "Han ser syg ud", new ArrayList<>(Arrays.asList("medicin", "penge")), new ArrayList<>(Arrays.asList("bog", "tegning")));

        //add characters to rooms
        school.addCharacter(schoolBoy);
        school.addCharacter(schoolGirl);

        poorroom.addCharacter(poorLady);
        poorroom.addCharacter(poorBoy);

        richroom.addCharacter(richMan);

        library.addCharacter(knittingLady);

        station.addCharacter(wizard);
        station.addCharacter(homelessMan);

        pharmacy.addCharacter(sickMan);
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
    public void processCommand(CommandWord commandWord, String secondWord, String thirdWord) {
        processCommand(new Command(commandWord, secondWord, thirdWord));
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
        } else if (commandWord == CommandWord.REMOVEITEMS) {
            remove(command);
        } else if (commandWord == CommandWord.SEECHARACTERS) {
            seeCharacters();
        } else if (commandWord == CommandWord.GIVEITEM) {
            giveItem(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
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
