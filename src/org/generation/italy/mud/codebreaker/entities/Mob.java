package org.generation.italy.mud.codebreaker.entities;

public class Mob extends InteractiveEntity {
    private int xp;

    public Mob(String characterName, int agility, int stamina, int strength, int intelligence, int xp) {
        super(characterName, agility, stamina, strength, intelligence);
        this.xp = xp;
        setAttack(strength * 2);
        setDefend(stamina);
        setMaxHp(stamina * 10);
        setCurrentHealth(getMaxHp());
        setAlive(true);
    }

    public int getXp(){
        return this.xp;
    }

    @Override
    public String toString(){
        return "\u001B[93mUn \u001B[31m" + getCharacterName() + "\u001B[93m si aggira per la zona\u001B[0m";
    }
}
