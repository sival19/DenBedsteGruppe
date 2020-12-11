package worldofzuul;

public abstract class InteractiveObjects {
    String name;
    String info;

    //Constructor
    public InteractiveObjects(String name, String info) {
        this.name = name;
        this.info = info;
    }

    //Get methods
    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }
}
