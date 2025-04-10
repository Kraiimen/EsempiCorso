package mud.items;

public abstract class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    //GETTER E SETTER
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
