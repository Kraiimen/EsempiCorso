package org.generation.italy.mud.model;

public class NPC extends Entity{
    protected int xpValue;
    protected boolean canBeAttacked;
    protected String genericInstructions;

    public NPC(String name, String description, int hp, int maxHp, int xpValue,
               boolean canBeAttacked, String genericInstructions) {
        super(name, description, hp, maxHp);
        this.xpValue = xpValue;
        this.canBeAttacked = canBeAttacked;
        this.genericInstructions = genericInstructions;
    }

    public void giveInstructions() {
        System.out.println("Hello, I am " + name + ". " + description);
    }
}
