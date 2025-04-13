package org.generation.italy.mud.codebreaker.entities;

import org.generation.italy.mud.codebreaker.inventory.Inventory;

public class Bitborne extends InteractiveEntity{
    private String className;
    private Inventory inventory = new Inventory();
    private int totalxp;
    private int currentxp;
    private int xpToLevelUp;
    private int level;

    public Bitborne(String className, int stamina, int strenght, int agility, int intelligence, boolean isAlive) {
        super(stamina, strenght, agility, intelligence, isAlive);
        this.className = className;
        this.level = 1;
        setAttack(strenght * 3);
        setDefend(stamina * 2);
        setMaxHp(stamina * 10);
        setCurrentHealth(getMaxHp());
    }

    public void setClassName(String className){
        this.className = className;
    }

    public int getXpMissingToLevelUp(){
        return xpToLevelUp - currentxp;
    }

    public void xpToLevelUpRequired(){
        this.xpToLevelUp = 20 + (level - 1) * 50;
    }

    public void checkLevelUp(Mob mob){
        currentXpSystem(mob);
        if(currentxp > xpToLevelUp){
            level++;
            System.out.println("Hai raggiunto il livello: " + level );
            xpToLevelUpRequired();
            if(currentxp - xpToLevelUp > 0){
                currentxp -= xpToLevelUp;
            } else {
                currentxp = 0;
            }
        }
    }
    public void currentXpSystem(Mob defeatedEnemyXp){
        currentxp += defeatedEnemyXp.getXp();
    }
    public void losingXp(){
        currentxp -= (int) (xpToLevelUp * 0.15);
    }

    }

