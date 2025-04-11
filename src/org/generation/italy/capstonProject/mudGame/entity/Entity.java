package org.generation.italy.capstonProject.mudGame.entity;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.Objects;
import java.util.Random;

public abstract class Entity {

    private final int MAX_HP_POSSIBLE = 100;
    private String charName;
    private int maxHP;
    private int healthPoints;
    private int maxDamage;
    protected int damage;
    private boolean isUnderAttack;
    protected Random rand = new Random();
    private Room currentRoom;
    protected Inventory inventory;


    public Entity(String charName, int maxHP, int maxDamage, Room currentRoom){
        this.charName = charName;
        this.maxHP = maxHP;
        this.healthPoints = maxHP;
        this.maxDamage = maxDamage;
        this.currentRoom = currentRoom;
        this.inventory = new Inventory(10);
    }

    public int healMissingHP(double healPercentage){
        if(healthPoints == maxHP){
            System.out.println("Health is " + healthPoints + "/" + maxHP);
            return healthPoints;
        }
        int healPoints = (int)Math.ceil(getMissingHP() * healPercentage);
        if((addHealthPoints(healPoints)) >= maxHP){
            healthPoints = maxHP;
        }else{
            healthPoints = addHealthPoints(healPoints);
        }
        System.out.println("Health is " + healthPoints + "/" + maxHP);
        return healthPoints;
    }

    public int restoreHP(){
        setHealthPoints(getMaxHP());
        return getHealthPoints();
    }

    public int addHealthPoints(int hp){
        return healthPoints += hp;
    }

    public int subtractHealthPoints(int hp){
        return healthPoints -= hp;
    }

    public abstract void attack(Entity target);
    public abstract  void manageInteraction(Entity target);

    public int calculateDamage() {
        damage = rand.nextInt(getMaxDamage() + 1);
        return damage;
    }

    public int hasTakenDamage(int inflictedDamage){
        isUnderAttack = true;
        healthPoints = subtractHealthPoints(inflictedDamage);

        if(isDead()){
            healthPoints = 0;
            if(getCurrentRoom().getEntities().contains(this)) {
                getCurrentRoom().removeEntityFromRoom(this);
            }
            isUnderAttack = false;
            System.out.println(this.charName + " is dead.");
        } else {

            System.out.println(this.charName + " has taken " + inflictedDamage + " points of damage. Its health is now " + healthPoints + "/" + maxHP);
        }
        return healthPoints;
    }

    public boolean isDead(){
        return healthPoints <= 0;
    }

    public int getMissingHP(){
        return maxHP - healthPoints;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "charName: '" + charName + '\'' +
                ", healthPoints: " + healthPoints +
                ", maxDamage: " + maxDamage +
                ", inventory: " + inventory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(charName, entity.charName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(charName);
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        if(maxHP >= MAX_HP_POSSIBLE){
            maxHP = MAX_HP_POSSIBLE;
        }
        this.maxHP = maxHP;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMAX_HP_POSSIBLE() {
        return MAX_HP_POSSIBLE;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getCharName() {
        return charName;
    }

    public boolean getIsUnderAttack() {
        return isUnderAttack;
    }

    public void setIsUnderAttack(boolean underAttack) {
        isUnderAttack = underAttack;
    }

    public Inventory getInventory(){
        return inventory;
    }

}
