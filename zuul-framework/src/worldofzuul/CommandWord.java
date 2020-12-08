package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"),
    PICKUP("tag"), SEEITEMS("hvad"), SEECHARACTERS("hvem"),
    SEEINVENTORY("taske"), REMOVEITEMS("smid"), GIEFITEM ("giv");
    
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
