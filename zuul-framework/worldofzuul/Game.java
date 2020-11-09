package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    Inventory inventory = new Inventory();


    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    
    private void seeItems()
    {
        System.out.println(currentRoom.getItems());
    }

    // THIS method does nothing YET
    private void pickUp()
    {

    }

    private void createRooms()
    {
        // Create rooms
        Room station, skole, bibliotek, restaurant, fattiggård, rigmandsgård;
      
        station = new Room("på stationen");
        skole = new Room("på skolen");
        bibliotek = new Room("på biblioteket");
        restaurant = new Room("på restauranten");
        fattiggård = new Room("på fattiggården");
        rigmandsgård = new Room("på rigmandsgården");

        // Create room relationships
        station.setExit("skolen", skole);
        station.setExit("restauranten", restaurant);
        station.setExit("biblioteket", bibliotek);
        station.setExit("fattiggården", fattiggård);

        skole.setExit("stationen", station);
        bibliotek.setExit("stationen", station);
        restaurant.setExit("stationen", station);

        fattiggård.setExit("rigmandsgården", rigmandsgård);
        fattiggård.setExit("stationen" , station);

        rigmandsgård.setExit("fattiggården", fattiggård);

        currentRoom = station;

        // Create items
        Item æble, penge, medicin, bog;

        æble = new Item("æble", "det er rødt", 1);
        penge = new Item("penge", "der er mange", 2);
        medicin = new Item("medicin", "det er piller", 3);
        bog = new Item("bog", "den er tung", 4);

        // Add items to rooms
        station.addItem(æble);
        bibliotek.addItem(penge);
        skole.addItem(medicin);
        restaurant.addItem(bog);
        fattiggård.addItem(bog);
        rigmandsgård.addItem(bog);
    }


    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }



    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.SEEITEMS){
            seeItems();
        }
        else if (commandWord == CommandWord.PICKUP){
            pickUp();
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }


    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
