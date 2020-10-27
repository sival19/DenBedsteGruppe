package worldofzuul;
import javax.naming.Name;
import java.util.ArrayList;

public class Characters extends InteractiveObjects {

    //Note: Overide metoder fra InteractiveObjects - (metoder: 'getName' og 'getInfo')

    int Tasks[];
    String InteractWith;

    //Constructor - creates characters
    Characters() {
    }

//    //Provides a name
//     void Name(String newName) {
//
//        //Refers to an overrided method (not yet done)
//        name = newName;
//    }
//
//    //Provides info - 'chat box'
//     void Info(String[] newInfo) {
//
//        //Refers to an overrided method (not yet done)
//        name = newInfo;
//    }

    private void createCharacter();
    //Creates a new character - Wizard

    //ALl the characters
    Characters Wizard, PoorMan, RichMan;

    //Creating the new characters
    Wizard = new Characters("Welcome " + playerName + "!");
    PoorMan = new PoorMan("I'm poor.");
    RichMan = new Richman("I'm rich.");


    //Afventer gruppe's getName metode
    Wizard.setName("Wizard")

    Wizard.setInfo("Filler - chat box")
    //Next interaction.
    //Benytter gruppes 1's metode (getInfo) til at tilføje flere interaction for hver character

    }

    public static void main(String[] args) {

    static void firstInfo();

        }
}
}
