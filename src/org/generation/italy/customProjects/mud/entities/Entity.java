package org.generation.italy.customProjects.mud.entities;

import org.generation.italy.customProjects.mud.world.Room;

public abstract class Entity {
    //   /-----/-VARIABLES-/-----/
    private String name;
    private int currentHealth;
    private int maxHealthPoint;
    private Room currentPosition;

    //   /-----/-CONSTRUCTORS-/-----/
    public Entity(String name, int health) {
        this.name = name;
        this.currentHealth = health;
    }

    //   /-----/-METHODS-/-GETTER-&-SETTER-/-----/
    public String getName() {
        return name;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public Room getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(Room currentPosition) {
        this.currentPosition = currentPosition;
    }

}
