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
}
