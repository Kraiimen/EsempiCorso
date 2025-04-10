package org.generation.italy.fantasyGame.entity.player;

public abstract class MagicalPlayer extends Player {
    protected int mana;

    public MagicalPlayer(String name, int maxHp, int damage, String playerName, long exp, int mana) {
        super(name, maxHp, damage, playerName, exp);
        this.mana = mana;
    }
}
