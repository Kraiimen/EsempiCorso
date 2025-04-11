package org.generation.italy.mud.codebreaker.inventory.items;

public abstract class Item {
    String name;
    String description;
    boolean consumable;
    boolean usableIncombat;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Item(String name, String description, boolean consumable, boolean usableIncombat){
        this(name,description);
        this.consumable = consumable;
        this.usableIncombat = usableIncombat;
    }

    public String getName(){
        return this.name;
    }
}
