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

//    //Constructor
//    public InteractiveObjects1 (String name1, String info1, int itemNeed) {
//        this.name = name1;
//        this.info = info1;
//        this.itemNeed = itemNeed;
//    }

    //Get methods
    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    }


