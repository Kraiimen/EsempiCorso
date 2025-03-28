package org.generation.italy.videogame.models;

public class Entity {
    private final int MAX_HP;
    private final int MAX_DAMAGE_POSSIBLE;
    private EntityTypes EntityTypes;
    private int currentHp;

    //COSTRUTTORI
    public Entity(String entityName, int currentHp, int MAX_HP) {
        this.EntityTypes = entityName;
        this.currentHp = currentHp;
        this.MAX_HP = MAX_HP;
        this.MAX_DAMAGE_POSSIBLE = 9_999;
    }

    //METODI
    public void healHP(int hpToRestore) {
        if(hpToRestore > MAX_HP - currentHp) {
            currentHp = MAX_HP;
            System.out.println("Max HP restored! c: ");
        } else {
            currentHp += hpToRestore;
            System.out.printf("HP restored: +%-4d%nCurrent HP: %4d%n", hpToRestore);
        }
    }

    public void damageTaken(int damageInflicted) {
        System.out.printf("Damage taken: %4d%n", damageInflicted);
        if(currentHp - damageInflicted <= 0) {
            System.out.println("Game over bitch!!!");
        } else {
            currentHp -= damageInflicted;
            System.out.printf("Current hp: %4d%n", currentHp);
        }
    }

    public void sleep() {
        currentHp += (int)Math.ceil((MAX_HP - currentHp)) * (0.2);
    }

    public void eat() {
        currentHp += (int)Math.ceil((MAX_HP - currentHp)) * (0.3);
    }

    public void attackEntity(Entity entityToAttack) {
        System.out.println(this.EntityTypes + "is attacking" + entityToAttack.EntityTypes);
    }
}
