package org.generation.italy.customProjects.mud.items;

public class Food extends Item {
    private int healthPoint;

    //   /-----/-CONSTRUCTORS-/-----/
    public Food(String itemName, int cost, boolean abandonedItem, int healthPoint) {
        super(itemName, cost, abandonedItem);
        this.healthPoint = healthPoint;
    }


    //   /-----/-METHODS-GET-&-SET-/-----/
    public int getHealthPoint() {
        return healthPoint;
    }
    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }
}
