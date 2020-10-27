package worldofzuul;

import java.util.ArrayList;

public class Characters extends InteractiveObjects {

    //Constructor
    public Characters(String name, String info) {
        super (name, info);
    }



    //Created a Wizard
    public void Wizard() {
        new InteractiveObjects("Wizard", "Welcome"); //info: add playername
    }

    //Created a poor man
    public void PoorMan() {
            new InteractiveObjects("S.U. modtager", "I'm poor."); //edit info
        }

    //Created a rich man
    public void RichMan() {
        new InteractiveObjects("Joakim von And", "I'm rich.");
    }


    int Tasks[];
    String InteractWith;
}

