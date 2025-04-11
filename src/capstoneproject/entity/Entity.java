package capstoneproject.entity;

import capstoneproject.Directions;
import capstoneproject.rooms.Item;
import capstoneproject.rooms.Room;

import java.util.*;

public abstract class Entity {
    private String name;
    private int healthPoints;
    private int maxHealth;
    private int maxDamage;
    protected Random random;
    protected Room currentRoom;
    protected Inventory inventory;

    public Entity(String name,int maxHealth, int maxDamage,Room currentRoom) {
        this.name = name;
        this.healthPoints = maxHealth;
        this.maxHealth = maxHealth;
        this.inventory = new Inventory();
        this.maxDamage = maxDamage;
        this.currentRoom= currentRoom;
        this.random = new Random();
    }

//    public void printStats(){
//        System.out.println("Name: " + name);
//        System.out.println("Intelligence: " + intelligence);
//        System.out.println("Strength: " + strength);
//        System.out.println("Agility : " + agility);
//        System.out.println("Stamina: " + stamina);
//        System.out.println("Health: " + healthpoint + "/" + maxHealth);
//    }
     public int takeDamage(int damage){
        healthPoints -= damage;
        if(healthPoints < 0) healthPoints = 0;
        return healthPoints;
     }

     public void heal(int amount){
        healthPoints += amount;
        if(healthPoints > maxHealth) healthPoints = maxHealth;
     }

     public boolean isDead(){
        return healthPoints <= 0;
     }

     public abstract void attack(Entity target);

     public void addHealthPoints(int hp) {
         healthPoints += hp;
    }

     public void subtractHealthPoints(int hp){
        healthPoints -= hp;
    }

    public int healMissingPercent(double healPercent){
        if(isFullyHealed()){
            return getMaxHealth();
        }
        double heal = getMissingHp() * healPercent;
        healthPoints += (int)heal;
        return healthPoints;
    }

    public boolean isFullyHealed(){
        return getHealthPoints() == getMaxHealth();
    };

    public void addToInventory(Item i){
        inventory.addItem(i);
    }

    public Optional<Item> removeFromInventory (String itemName){
        return inventory.removeItem(itemName);
    }

    public String getInventoryDescription(){
        return inventory.toString();
    }

    public boolean move(Directions dir){
        Optional<Room> optRoom = currentRoom.getExitAt(dir);
        if(optRoom.isPresent()){
            Room destination = optRoom.get();
            currentRoom = destination;
            return true;
        } else{
            return false;
        }
    }

    public int getMissingHp(){
         return maxHealth - healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
