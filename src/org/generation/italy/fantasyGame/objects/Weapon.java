package org.generation.italy.fantasyGame.objects;

public class Weapon extends GameObject{
    private int damage;
    private boolean isOneShot;

    public Weapon(String name, int weight, int value, int damage, boolean isOneShot) {
        super( name, weight,value);
        this.damage = damage;
        this.isOneShot= isOneShot;
    }
}
