package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"),
    PICKUP("tag"), SEEITEMS("hvad"), SEECHARACTERS("hvem");
    
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
