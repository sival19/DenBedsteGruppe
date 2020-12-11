package worldofzuul;

/*
* This class is extended by Item and Character
* InteractiveObjects hold name and info as attributes
* which are used by Item and Character
*
 */

public abstract class InteractiveObjects {
    String name;
    String info;

    public InteractiveObjects(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }
}
