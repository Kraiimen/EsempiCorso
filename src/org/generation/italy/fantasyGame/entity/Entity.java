package org.generation.italy.fantasyGame.entity;

public class Entity{
    //ATTRIBUTI DELL'ISTANZA
    private String name;
    private int healthPoints;
    private int maxHp;
    protected int damage;

    public Entity(String name, int maxHp, int damage){
        this.name = name;
        this.maxHp = maxHp;
        healthPoints= this.maxHp;
        this.damage = damage;
    }
    public int healMissingHpPercent(double healPercent){
        int missingHp = maxHp - healthPoints;
        double heal = missingHp * healPercent;
        healthPoints += (int)heal;
        return healthPoints;
    }

    public void sleep(){
        healMissingHpPercent(0.2);
        System.out.println("Hai dormito e hai " + healthPoints);
    }
    public void eat(){
        healMissingHpPercent(0.3);
        System.out.println("Hai mangiato e hai " + healthPoints);
    }
    public void attack(Entity target){
        target.subtractHealthPoints(damage);
        System.out.println(name + " attacca " + target.getName() + " facendo " + damage + " danni ");
        System.out.println(target.getName() + " Ha ancora " + target.getHealthPoints() + " / " + target.maxHp);
    }
    public void addHealthPoints(int hp){
        healthPoints += hp;
    }
    public void subtractHealthPoints(int hp){
        healthPoints -= hp;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
}
