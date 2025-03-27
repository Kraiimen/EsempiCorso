package org.generation.italy.videogame.models;

import java.util.Random;

public class Entity {
    private final int MAX_DAMAGE_POSSIBLE;
    private int maxHP;
    private EntityType type;
    private int hpValue;

    // COSTRUTTORE
    public Entity(EntityType entityType, int hpValue){
        this.type = entityType;
        this.hpValue = hpValue;
        this.MAX_DAMAGE_POSSIBLE=9999;
        setMaxHP(entityType);
    }

    public int getMissingHP(){
        return maxHP - hpValue;
    }

    public void healHP(int hpToRestore){
        if(hpToRestore > getMissingHP()){
            hpValue = maxHP;
            System.out.println("Max HP restored! c: ");
        }
        else {
            hpValue += hpToRestore;
            System.out.printf("HP restored: +%-4d%nCurrent HP: %4d%n", hpToRestore, hpValue);
        }
    }

    public void damageTaken(int damageInflicted){
        System.out.printf("Damage taken: %4d%n", damageInflicted);
        if (hpValue - damageInflicted <= 0){
            System.out.println(this.type.toString() + " is dead!!!");
        }
        else {
            hpValue -= damageInflicted;
            System.out.printf("Current HP: %4d%n", hpValue);
        }
    }

    public void sleep(){
        hpValue += (int)Math.ceil(getMissingHP()*0.2);
    }

    public void eat(){
        hpValue += (int)Math.ceil(getMissingHP()*0.3);
    }

    public void attackEntity(Entity entityToAttack){
        int damage = getRandomDamage();
        System.out.println(this.type.toString() + " is attacking " + entityToAttack.type.toString() + "!");
        System.out.println(this.type.toString() + " inflicted " + damage + " to " + entityToAttack.type.toString() + "!");
        entityToAttack.damageTaken(damage);
    }

    private void setMaxHP(EntityType entityType){
        if(entityType == EntityType.PLAYER){
            maxHP = 1000;
        } else{
            maxHP = 1500;
        }
    }

    public int getRandomDamage(){
        Random random = new Random();
        return random.nextInt(101);
    }

}
