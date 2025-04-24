package org.generation.italy.customProjects.mud.items;

public class Weapon extends Item {
    private int damage;

    //   /-----/-CONSTRUCTORS-/-----/

    public Weapon(String itemName, int cost, boolean freeItem, int damage) {
        super(itemName, cost, freeItem);
        this.damage = damage;
    }


    //   /-----/-METHODS-GET-&-SET-/-----/
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
