package capstoneproject.rooms;

public class Item {
    private String name;
    private String description;
    private double weight;
    private int cost;

    public Item(String name, String description, double weight, int cost){
        this.name = name;
        this.description=description;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName(){
        return name;
    }
}
