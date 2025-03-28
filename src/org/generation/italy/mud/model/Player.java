package org.generation.italy.mud.model;

public class Player extends Entity{
    protected int xp;
    protected String playerName;

    public Player(String name, String description, int hp, int maxHp, int xp, String playerName) {
        super(name, description, hp, maxHp);
        this.xp = xp;
        this.playerName = playerName;
    }

    public void login() {
        System.out.println("Welcome " + playerName);
    }

    public void logout() {
        System.out.println("Goodbye " + playerName);
    }
}
