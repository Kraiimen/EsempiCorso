package sud.entity;

import sud.items.*;
import sud.rooms.*;


import java.util.ArrayList;

public class Mob extends Entity{
    private int damagereduction;
    private ArrayList<Item> carriedItems;

    public Mob(String name, int maxHp, int attackDamage, Room currentroom, int xpOnDeath, int damagereduction, ArrayList<Item> carriedItems) {
        super(name, maxHp, attackDamage, currentroom, xpOnDeath, colorR);
        this.damagereduction = damagereduction;
        this.carriedItems = carriedItems;
    }

    public int getDamagereduction() {
        return damagereduction;
    }

    public void setDamagereduction(int damagereduction) {
        this.damagereduction = damagereduction;
    }

    public ArrayList<Item> getCarriedItems() {
        return carriedItems;
    }

    public void setCarriedItems(ArrayList<Item> carriedItems) {
        this.carriedItems = carriedItems;
    }
}
