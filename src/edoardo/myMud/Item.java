package edoardo.myMud;

public abstract class  Item {
    private String name;
    private int price;
    private int weight;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    public int getWeight(){
        return weight;
    }
    public String getName(){
        return name;
    }
    public abstract void printDetails();
}
