package org.generation.italy.ravenClaw.mud;


public class Entity {
    private String name;
    private int healthPoints;
    private int maxHp;
    private int attackDamage; //danno base della creatura


    public Entity(String name, int maxHp, int attackDamage){
        this.name = name;
        this.maxHp = maxHp;
        this.attackDamage = attackDamage;
        healthPoints = maxHp;
    }
    //METODI COMBATTIMENTO
    public void hurt(int receivedDamage){ //received damage è il danno che infligge la creatura attaccante
        healthPoints -= receivedDamage; //scalare il danno dai punti vita
    }
    public void attack(Entity attacked){
        int damageMade = attackDamage;  //variabile modificabile che prende come minimo il danno dell'attaccante
        attacked.hurt(damageMade);
        System.out.printf("%s is attacking %s for %d damage", this.name, attacked.getName(),damageMade);
    }
    //METODI DI RISTORO
    public void heal(int receivedHeal){
        healthPoints += receivedHeal;
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
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public int getHealthPoints(){return healthPoints;}
    public void setHealthPoints(int healthPoints){this.healthPoints = healthPoints;}

    public int getMaxHp(){return maxHp;}
    public void setMaxHp(int maxHp){this.maxHp = maxHp;}

    public int getAttackDamage(){return attackDamage;}
    public void setAttackDamage(int attackDamage){this.attackDamage = attackDamage;}


}