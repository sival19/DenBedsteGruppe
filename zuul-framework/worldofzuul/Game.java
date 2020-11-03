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

    public void createItems (){

        Item æble;

        æble = new Item("æble", "det er rødt", 1);
    }

    private void pickUp(){

    }




    private void createRooms()
    {
        Room station, skole, bibliotek, restaurant, fattiggården, rigmandsgård;
      
        station = new Room("på stationen");
        skole = new Room("på skolen");
        bibliotek = new Room("på biblioteket");
        restaurant = new Room("på restauranten");
        fattiggården = new Room("på fattiggården");
        rigmandsgård = new Room("på rigmandsgården");
        
        station.setExit("skole", skole);
        station.setExit("restaurant", restaurant);
        station.setExit("bibliotek", bibliotek);
        station.setExit("fattiggården", fattiggården);

        skole.setExit("station", station);

        bibliotek.setExit("station", station);

        restaurant.setExit("station", station);

        fattiggården.setExit("rigmandsgård", rigmandsgård);
        fattiggården.setExit("station" , station);

        rigmandsgård.setExit("fattiggård", fattiggården);

        currentRoom = station;
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
