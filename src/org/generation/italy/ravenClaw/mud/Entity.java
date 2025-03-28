package org.generation.italy.ravenClaw.mud;


public class Entity {
    private String name;
    private int healthPoints;
    private int maxHp;
    private int attackDamage; //danno base della creatura
    private boolean isDead;


    public Entity(String name, int maxHp, int attackDamage){
        this.name = name;
        this.maxHp = maxHp;
        this.attackDamage = attackDamage;
        healthPoints = maxHp;
        isDead = false;
    }
    //METODI COMBATTIMENTO
    public void hurt(int receivedDamage){ //received damage è il danno che infligge la creatura attaccante
        healthPoints -= receivedDamage; //scalare il danno dai punti vita
        if(healthPoints<=0){
            isDead = true;
            System.out.println(name + " has died ");
        }
    }
    public void attack(Entity attacked){
        int damageMade = attackDamage;  //variabile modificabile che prende come minimo il danno dell'attaccante
        attacked.hurt(damageMade);
        System.out.printf(" %s is attacking %s for %d damage ", name, attacked.getName(),damageMade);
    }
    //METODI DI RISTORO
    private void heal(int receivedHeal){
        int hpLost = maxHp - healthPoints;
        if (receivedHeal <= hpLost) {
            healthPoints += receivedHeal;
        }else{
            healthPoints = maxHp;
        }
        System.out.printf(" %s heals %d HP ", name,receivedHeal);

    }
    public void eat(){
        int hpLost = maxHp - healthPoints;
        int lifeRestored = (int)(hpLost * 0.3); //essendo il 30% esce un double e quindi è necessario castare ad int
        heal(lifeRestored);
    }
    public void sleep(){
        int hpLost = maxHp - healthPoints;
        int lifeRestored = (int)(hpLost * 0.2);
        heal(lifeRestored);
    }

    public void printSheet(){
        System.out.printf("your name is %s you've got &d HP and your base damage is %d", name,healthPoints,attackDamage);
    }
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public int getHealthPoints(){return healthPoints;}
    public void setHealthPoints(int healthPoints){this.healthPoints = healthPoints;}

    public int getMaxHp(){return maxHp;}
    public void setMaxHp(int maxHp){this.maxHp = maxHp;}

    public int getAttackDamage(){return attackDamage;}
    public void setAttackDamage(int attackDamage){this.attackDamage = attackDamage;}

    public boolean isDead() {return isDead;}
    public void setDead(boolean dead) {isDead = dead;}
}