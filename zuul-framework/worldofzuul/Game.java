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

    //see characters
    private void seeCharacters(){
        System.out.println(currentRoom.getCharacter());
    }

    private void seeItems(){
        System.out.println(currentRoom.getItems());
    }

    private void pickUp(){

    }
    private void createRooms()
    {
        // Create rooms
        Room station, skole, bibliotek, restaurant, fattiggård, rigmandsgård;
      
        station = new Room("på stationen" );
        skole = new Room("på skolen, du ser nogen gemme sig bag porten, og måske gemmer der sig en ting her");
        bibliotek = new Room("på biblioteket, der er nogen på biblioteket, og mon ikke der også er nogle ting");
        restaurant = new Room("på restauranten, og du ser en meget velklædt person, mon ikke der er noget brugebart her");
        fattiggård = new Room("på fattiggården, du ser en skikkelse i den bagerste og mørkeste hjørne ");
        rigmandsgård = new Room("på rigmandsgården, og du ser en AND!");

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
        bibliotek.addItem(bog);
        skole.addItem(penge);
        restaurant.addItem(æble);
        fattiggård.addItem(bog);
        rigmandsgård.addItem(medicin);

        //create characters
        Characters waiter, boy, richGuy, poorGuy, librarian;

        waiter = new Characters("tjener", "bestikslav");
        boy = new Characters("dreng", "lille stakel");
        richGuy = new Characters("Onkel Joachim", "lidt for rig");
        poorGuy = new Characters("Total hjemløs", "så syg...");
        librarian = new Characters("Bibliotekar ", "Har kæmpe store briller på");

        //add characters to rooms

        skole.addCharacter(boy);
        restaurant.addCharacter(waiter);
        rigmandsgård.addCharacter(richGuy);
        fattiggård.addCharacter(poorGuy);
        bibliotek.addCharacter(librarian);
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
        System.out.println("Velkommen til den bedste spil i verden!");
        System.out.println("Det er den sejeste spil du nogensinde kommer til at spille.");
        System.out.println("Efter du har spillet det her bliver du aldrig en der forskelsbehandler!");
        System.out.println("Skriv '" + CommandWord.HELP + "' for at finde ud af hvordan du kommer videre.");
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
        System.out.println("Du har det godt, du går lidt rundt og kigger");
        System.out.println();
        System.out.println("Dine mulige komandoer er:");
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
            System.out.println("Der er ingen dør!");
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
