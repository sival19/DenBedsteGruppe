package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"),
    PICKUP("tag"), SEEITEMS("hvad"), SEECHARACTERS("hvem"),
    SEEINVENTORY("taske");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
