package org.generation.italy.mud.codebreaker.entities;

public class Mob extends InteractiveEntity {
    private int xp;
    private boolean boss;

    public Mob(String characterName, int agility, int stamina, int strength, int intelligence, int xp, boolean boss) {
        super(characterName, agility, stamina, strength, intelligence);
        this.xp = xp;
        this.boss = boss;
        setAttack(strength * 2);
        setDefend(stamina);
        setMaxHp(stamina * 10);
        setCurrentHealth(getMaxHp());
    }

    public int getXp(){
        return this.xp;
    }

    @Override
    public String printHpBar() {
        int barLenght = 20;
        if (getCurrentHealth() > 100) {
            barLenght = 50;
        }
        int filledLenght = (int) ((double) getCurrentHealth() / getMaxHp() * barLenght);

        String bar = "HP [";

        for (int i = 0; i < barLenght; i++) {
            if (i < filledLenght) {
                bar += "█";
            } else {
                bar += "░";
            }
        }
        bar += "] ";
        return String.format("%-18s: \u001B[31m%s\u001B[0m %d/%d", getCharacterName(), bar, getCurrentHealth(), getMaxHp());
    }


    @Override
    public String toString(){
        return "\u001B[93mUn \u001B[31m" + getCharacterName() + "\u001B[93m è diventato ostile\u001B[0m";
    }
}
