package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;

    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player(0,0,"Palle");

    }
    //see characters
    private void seeCharacters(){
        System.out.println(currentRoom.getCharacter());
    }

    
    private void seeItems(){
        System.out.println(currentRoom.getItems());
    }

    private void seeInventory(){
        
    }


    private void pickUp(Command c){
        if(!c.hasSecondWord()){
            System.out.println("hvad vil du samle op??");
            return;
        }

        //Herfr ved vi at der er et Second Word
        String secondWord = c.getSecondWord();
        Item itemToadd = null;
        for(Item i: this.currentRoom.getItems()){
            String itemId = Integer.toString(i.getId());

            if(secondWord.equals(itemId)){
                itemToadd = i;
                break;
            }
        }

        if(itemToadd != null){
            player.addItem(itemToadd);
            System.out.println("tilføjet til inventory ");
        }else{
            System.out.println("Det indtastede item blev ikke fundet.");
        }


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

        //create characters
        Characters waiter, boy, richSnob, poorFuck;

        waiter = new Characters("tjener", "bestikslav");
        boy = new Characters("dreng", "lille stakel");
        richSnob = new Characters("onkel Joachim", "lidt for rig");
        poorFuck = new Characters("Total hjemløs", "så syg...");

        //add characters to rooms

        skole.addCharacter(boy);
        restaurant.addCharacter(waiter);
        rigmandsgård.addCharacter(richSnob);
        fattiggård.addCharacter(poorFuck);
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
            pickUp(command);
        }
        else if (commandWord == CommandWord.SEEINVENTORY){
            seeInventory();
        }
        else if (commandWord == CommandWord.SEECHARACTERS){
            seeCharacters();
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
