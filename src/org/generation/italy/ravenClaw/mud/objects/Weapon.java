package org.generation.italy.ravenClaw.mud.objects;

public class Weapon extends Item{

    private int damageMod;

    public Weapon (String name, int value,int weight, int damageMod){
        super(name, value, weight);
        this.setType(ItemType.WEAPON);
        this.damageMod = damageMod;
    }

    public int getDamageMod() {
        return damageMod;
    }

    public void setDamageMod(int damageMod) {
        this.damageMod = damageMod;
    }
}
