package worldofzuul;

import java.util.*;

/*
 * In this class we create a room and the methods
 * to add, remove, and see which items and characters
 * are in the room.
 * The class also contains methods to get descriptions
 * of the room and which exits the room has.
 */

public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private List<Item> itemsRoom = new ArrayList<>();
    private ArrayList<Character> characters = new ArrayList<>();

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public ArrayList<Character> getCharacters(){
        return characters;
    }

    public List<Item> getItems(){
        return itemsRoom;
    }

    public void addItem(Item item){
        itemsRoom.add(item);
    }

    public void removeItem(Item item){
        itemsRoom.remove(item);
    }

    public void addCharacter(Character character){
        this.characters.add(character);
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "Du er " + description + ".\n" + getExitString();
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}

