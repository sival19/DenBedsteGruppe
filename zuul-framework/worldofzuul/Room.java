package worldofzuul;

import java.util.*;


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private static List<Item> itemsRoom = new ArrayList<Item>();

    public static void addItemRoom(Item item){
        itemsRoom.add(item);
    }

    public static List<Item> getItemsRoom(){
        return Collections.unmodifiableList(itemsRoom); //hvorfor gør vi det?!?!?!?!?!
    }

    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();

    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "Du er " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

