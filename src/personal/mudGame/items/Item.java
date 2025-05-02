package personal.mudGame.items;

public abstract class Item {
    private ItemType type;

    public Item(ItemType type){
        this.type = type;
    }

    public ItemType getItemType(){ return type; }
}
