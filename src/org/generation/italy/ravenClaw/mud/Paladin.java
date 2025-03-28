package org.generation.italy.ravenClaw.mud;

import java.util.Random;

public class Paladin extends Player {
    private boolean isVirgin = true;

    public Paladin(String name, int maxHp, int attackDamage, String playerName){
        super(name,  maxHp,  attackDamage, playerName);

    }
    //attacco con lancia che dipende dal fatto che sia corrotto o meno
    @Override
    public void attack(Entity attacked){
        int damageMade = getAttackDamage();  //variabile modificabile che prende come minimo il danno dell'attaccante
        if (hasAttackSucceeded()) {
            attacked.hurt(damageMade);
            System.out.printf("%s is attacking with spear %s for %d damage", getName(), attacked.getName(), getAttackDamage());
        }
        else {
            System.out.printf("%s failed to attack with spear %s because his heart is corrupted", getName(), attacked.getName());
        }
    }
    //chance di colpire al 50% se corrotto
    private boolean hasAttackSucceeded(){
        if (isVirgin){
            return true;
        }
        int diceFaces = 2;
        Random random = new Random();
        return random.nextInt(diceFaces) > 0;
    }

    private void getCorrupt(){
        isVirgin = false;
        System.out.printf("The heart of %s has been corrupted, there is no turning back ",getName());
    }
    // se ha meno del 20% di vita viene corrotto
    public void attemptedCorruption(Npc npc){
        System.out.printf("%s is attempting to corrupt %s", npc.getName(), getName());
        if (getHealthPoints() <= getMaxHp() * 0.2){
            getCorrupt();
        } else {
            System.out.printf("The heart of %s remains pure... today.", getName());
        }
    }

    public boolean isVirgin() {
        return isVirgin;
    }

    public void setVirgin(boolean virgin) {
        isVirgin = virgin;
    }
}
