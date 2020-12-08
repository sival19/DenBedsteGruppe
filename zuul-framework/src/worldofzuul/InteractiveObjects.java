package worldofzuul;

public abstract class InteractiveObjects {
    String name;
    String info;
    int itemType;

    //Constructor
    public InteractiveObjects(String name, String info, int itemType) {
        this.name = name;
        this.info = info;
        this.itemType = itemType;
    }

    //Get methods
    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }
}
