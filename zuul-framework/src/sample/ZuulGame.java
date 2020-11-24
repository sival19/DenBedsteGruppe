package sample;
import worldofzuul.*;

public interface ZuulGame {

    void seeInventory();

    //process a command from game with CommandWord.SOMETHING , "what"
    //Husk hvis man laver om i sting skal man også lave om i kommandolag
    boolean processCommand(CommandWord commandWord, String secondWord);


    //Giver adgang til Game klassen og eksisterende kommandoer
    //Interfacet fungerer som et mellemled, en "bro" mellem lagene (altså mellem GUI og selve koden)
}
