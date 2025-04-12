package org.generation.italy.sudProject.items;

public class Item {
    private String itemName;
    private int value;
    private boolean dropped;
    private String item_description;

    // /--CONSTRUCTORS--/
    public Item(String itemName, int value, boolean dropped, String item_description){
        this.itemName = itemName;
        this.value = value;
        this.dropped = dropped;
        this.item_description = item_description;
    }
    // /--GETTER-&-SETTER--/

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isDropped() {
        return dropped;
    }

    public void setDropped(boolean dropped) {
        this.dropped = dropped;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
}
