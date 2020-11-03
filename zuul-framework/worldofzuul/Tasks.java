package worldofzuul;
import java.util.ArrayList;

public class Tasks {

    String info;
    boolean completed;

    //evt tilføje else
    public Tasks(String info){
        this.info = info;
        if (completed == true){
            Player.addPoints(+1);
            Player.addHealth(-1);
            System.out.println("thank you");
        }

    }

    public void getInfo() {
        
    }
}
