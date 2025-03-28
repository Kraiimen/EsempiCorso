package org.generation.italy.ravenClaw.mud.objects;

public class Item {
    private String name;
    private int value;
    private int weight;
    private ItemType type;

    public Item (String name, int value, int weight){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
