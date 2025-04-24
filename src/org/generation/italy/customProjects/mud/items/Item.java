package org.generation.italy.customProjects.mud.items;

public abstract class Item {
   //   /-----/-STATE-/-----/
    private String itemName;
    private int cost;
    private boolean freeItem;

    //   /-----/-CONSTRUCTORS-/-----/
    public Item(String itemName, int cost, boolean freeItem) {
        this.itemName = itemName;
        this.freeItem = freeItem;
        this.cost = (freeItem ? 0 : cost);
    }


    //   /-----/-METHODS-GET-&-SET-/-----/
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public boolean isFreeItem() {
        return freeItem;
    }
    public void setFreeItem(boolean freeItem) {
        this.freeItem = freeItem;
    }
}
