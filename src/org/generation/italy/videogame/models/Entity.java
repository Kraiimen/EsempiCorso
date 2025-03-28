package org.generation.italy.videogame.models;

import java.util.Random;

public class Entity {
    Random random = new Random();
    private final int MAX_BASE_DAMAGE_POSSIBLE;
    private final int MIN_CRITICAL_DAMAGE_POSSIBLE;
    private final int MAX_CRITICAL_DAMAGE_POSSIBLE;
    private String name;
    private int maxHP; // Punti vita massimi (diverso per ogni entità)
    private int hpValue; // Punti vita attuali dell'entità
    private int damage;

    // COSTRUTTORE
    public Entity(String name, int maxHP, int hpValue){
        this.name = name;
        this.maxHP = maxHP;
        this.hpValue = hpValue;
        this.MAX_BASE_DAMAGE_POSSIBLE = 999; // Il danno massimo possibile da un attacco base è 100
        this.MIN_CRITICAL_DAMAGE_POSSIBLE = 1000; // Il danno minimo di un attacco critico
        this.MAX_CRITICAL_DAMAGE_POSSIBLE = 9999; // Il danno massimo possibile da una attacco critico è 9999
    }

    // Cura l'entità
    public void healHP(int hpToRestore){
        // Se il numero di HP da assegnare è oltre maxHP
        if(hpToRestore > getMissingHP()){
            hpValue = maxHP; // Riempiamo la barra della vita
            System.out.println(name+": max HP restored! c: ");
        }
        else {
            hpValue += hpToRestore; // Altrimenti aggiungi gli HP
            System.out.printf(name+": HP restored: +%-4d%n%s: current HP: %4d%n", hpToRestore, name, hpValue);
        }
    }

    // Danno che l'entità riceve (Diminuisce HP)
    public void takeDamage(int damageInflicted){
        System.out.printf("%s: damage taken: %4d%n", name, damageInflicted);
        // Se il danno ricevuto è maggiore della vita (quindi arriviamo a 0)
        if (hpValue - damageInflicted <= 0){
            System.out.println(name + " is dead!!!"); // L'entità muore
        }
        else {
            hpValue -= damageInflicted; // Altrimenti diminuisci gli HP
            System.out.printf(name+": current HP: %4d%n", hpValue);
        }
    }

    // L'entità recupera il 20% della vita persa quando dorme
    public void sleep(){
        healHP((int)Math.ceil(getMissingHP()*0.2));
    }

    // L'entità recupera il 30% della vita persa quando mangia
    public void eat(){
        healHP((int)Math.ceil(getMissingHP()*0.3));
    }

    // L'entità attacca un'altra entità
    public void attackEntity(Entity entityToAttack){
        setAttackDamage();
        System.out.println(name + " is attacking " + entityToAttack.name + "!");
        System.out.println(name + " inflicted " + getDamage() + " to " + entityToAttack.name + "!");
        entityToAttack.takeDamage(getDamage()); // Diminuiamo gli HP dell'entità attaccata
    }

    // Danno random da 0 a 999 (Attacco base)
    public int getRandomBaseDamage(){
        return random.nextInt(MAX_BASE_DAMAGE_POSSIBLE + 1);
    }

    // Danno random da 1000 a 9999 (Attacco critico)
    public int getRandomCriticalDamage(){
        return random.nextInt(MIN_CRITICAL_DAMAGE_POSSIBLE,MAX_CRITICAL_DAMAGE_POSSIBLE + 1);
    }

    // 10% di possibilità di fare attacco critico
    public void setAttackDamage(){
        if(random.nextDouble(1) <= 0.1){
            setDamage(getRandomCriticalDamage());
            return;
        }

        setDamage(getRandomBaseDamage());
    }

    // Calcola gli HP persi
    public int getMissingHP(){
        return maxHP - hpValue;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getMAX_BASE_DAMAGE_POSSIBLE() {
        return MAX_BASE_DAMAGE_POSSIBLE;
    }
}
