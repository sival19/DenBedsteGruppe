package worldofzuul;

import java.util.*;


public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    private List<Item> itemsRoom = new ArrayList<Item>();
    private ArrayList<Character> characters = new ArrayList<Character>();

    public void addCharacter(Character character){
        this.characters.add(character);
    }

    //see characters

    public ArrayList<Character> getCharacters(){
        return characters;
    }

    //add and remove items to room

    public void addItem(Item item){
        itemsRoom.add(item);
    }

    public void removeItem(Item item){
        itemsRoom.remove(item);
    }

    public List<Item> getItems(){
        return itemsRoom;
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

