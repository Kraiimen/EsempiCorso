package org.generation.italy.videogame.models;

public class Entity {
    private final int MAX_DAMAGE_POSSIBLE;
    private final int MAX_HP;
    private EntityTypes entityType;
    private int currentHP;

    // COSTRUTTORE
    public Entity(EntityTypes entityType, int currentHP, int MAX_HP){
        this.entityType = entityType;
        this.currentHP = currentHP;
        this.MAX_HP = MAX_HP;
        this.MAX_DAMAGE_POSSIBLE=9999;
    }

    public void healHP(int hpToRestore){
        if(hpToRestore > MAX_HP - currentHP){
            currentHP = MAX_HP;
            System.out.println("Max HP restored! c: ");
        }
        else {
            currentHP += hpToRestore;
            System.out.printf("HP restored: +%-4d%nCurrent HP: %4d%n", hpToRestore, currentHP);
        }
    }

    public void damageTaken(int damageInflicted){
        System.out.printf("Damage taken: %4d%n", damageInflicted);
        if (currentHP - damageInflicted <= 0){
            System.out.println("Game over bitch!!!");
        }
        else {
            currentHP -= damageInflicted;
            System.out.printf("Current HP: %4d%n", currentHP);
        }
    }

    public void sleep(){
        currentHP += (int)Math.ceil((MAX_HP-currentHP)*0.2);
    }

    public void eat(){
        currentHP += (int)Math.ceil((MAX_HP-currentHP)*0.3);
    }

    public void attackEntity(Entity entityToAttack){
        System.out.println(this.entityName+" is attacking "+entityToAttack.entityName);
    }


}
