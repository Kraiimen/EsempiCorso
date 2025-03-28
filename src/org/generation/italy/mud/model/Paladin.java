package org.generation.italy.mud.model;

public class Paladin extends Player {
    protected boolean isVirgin;

    public Paladin(String name, String description, int hp, int maxHp, int xp, String playerName, boolean isVirgin) {
        super(name, description, hp, maxHp, xp, playerName);
        this.isVirgin = isVirgin;
    }

    public void chargeWithSpear() {
        System.out.printf("%s charges with his spear!%n", name);
    }

}
