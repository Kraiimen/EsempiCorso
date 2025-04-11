package org.generation.italy.mud.codebreaker.inventory.items;

public class HealingItem extends Item{
    private int healingPower;


    public HealingItem(String name, String description, boolean consumable, boolean usableIncombat) {
        super(name, description, consumable, usableIncombat);
    }

    public int useHealingItem(HealingItem heal){
        return healingPower;
    }

}
