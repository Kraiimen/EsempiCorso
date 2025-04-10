package sud.items;

public class Item {
    private int price;
    private ItemType type;
    private String name;

    public Item(int price, ItemType type, String name) {
        this.price = price;
        this.type = type;
        this.name = name;
    }
    static{
        // Food pane= new Food(1, F)
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
