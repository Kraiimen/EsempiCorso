package org.generation.italy.customProjects.mud.entities;

public abstract class Player extends Entity {
    //   /-----/-VARIABLES-/-----/
    private String playerName;
    private int xp;
    private int strength;
    private int agility;
    private int stamina;

    //   /-----/-CONSTRUCTORS-/-----/
    public Player(String name, int health, String playerName, int xp, int strength, int agility, int stamina) {
        super(name, health);
        this.playerName = playerName;
        this.xp = xp;
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
    }

    //   /-----/-METHODS-/-----/



    //   /-----/-METHODS-/-GETTER-&-SETTER-/-----/
    public String getPlayerName() {
        return playerName;
    }
    public int getXp() {
        return xp;
    }
    public int getStrength() {
        return strength;
    }
    public int getAgility() {
        return agility;
    }
    public int getStamina() {
        return stamina;
    }




}
