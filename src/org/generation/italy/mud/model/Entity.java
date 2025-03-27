package org.generation.italy.mud.model;

import java.util.Random;

public class Entity {
    protected String name;
    protected String description;
    protected int hp;
    protected int maxHp;
    protected Random random ;

    public Entity(String name, String description, int hp, int maxHp) {
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.maxHp = maxHp;
        this.random = new Random();
    }

    public int sleep() {
        if(isWounded()) {
            this.hp += (int) (maxHp - hp ) * .2;
        }
        return this.hp;
    }

    public void attack(Entity target) {
        target.hp -= 10;
    }

    public int eat() {
        if(isWounded()) {
            this.hp += (int) (maxHp - hp ) * .5;
        }
        return this.hp;
    }

    public boolean isWounded() {
        return hp < maxHp;
    }

    public int suffer(int damage) {
        hp -= damage;
        return hp;
    }

    public int getHp() {
        return hp;
    }
}
