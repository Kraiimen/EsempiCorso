package org.generation.italy.mud.model;

public class MagicalCreature  extends Player{
    protected int mana;
    protected final int maxMana;

    public MagicalCreature(String name, String description, int hp, int maxHp, int xp, String playerName, int mana, int maxMana) {
        super(name, description, hp, maxHp, xp, playerName);
        this.mana = mana;
        this.maxMana = maxMana;
    }

}
