package sud.entity;

import sud.items.*;
import sud.rooms.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Entity {
    private String name;
    private int healthPoints;
    private int maxHp;
    private int attackDamage; //danno base della creatura
    private boolean isDead;
    private int xpOnDeath=0;
    private Room currentroom;
    private ArrayList<Item> inventory;
    private String entityColor;
    public static String colorBlack = "\u001B[30m";
    public static String colorR = "\u001B[31m";
    public static String colorG = "\u001B[32m";
    public static String colorY = "\u001B[33m";
    public static String colorB = "\u001B[34m";
    public static String colorP = "\u001B[35m";
    public static String colorC = "\u001B[36m";
    public static String colorW = "\u001B[37m";
    public static String resetColor = "\033[0m";

    public Entity(String name, int maxHp, int attackDamage, Room currentroom) {
        this.name = name;
        this.healthPoints = maxHp;
        this.maxHp = maxHp;
        this.attackDamage = attackDamage;
        this.currentroom = currentroom;
        inventory = new ArrayList<>();

    }

    public Entity(String name, int maxHp, int attackDamage, Room currentroom, String entityColor){
        this( name, maxHp, attackDamage, currentroom);
        this.colorR = entityColor;
    }

    public Entity(String name, int maxHp, int attackDamage, Room currentroom, int xpOnDeath){
        this( name, maxHp, attackDamage, currentroom);
        this.xpOnDeath = xpOnDeath;
    }
    public Entity(String name, int maxHp, int attackDamage, Room currentroom, int xpOnDeath, String entityColor){
        this( name, maxHp, attackDamage, currentroom, entityColor);
        this.xpOnDeath = xpOnDeath;
    }

    // METODI DI COMBATTIMENTO

    public void hurt (int recivedDamage){
        if(recivedDamage >= healthPoints){
            isDead=true;
            healthPoints =0;
        }else{
            healthPoints -= recivedDamage;
            //@todo implementare un modo di ridurre i danni in base al armatura
        }
    }

    public void Attack (Entity attacked){
        int damage;
        Random dice = new Random();
        int roll = dice.nextInt(20);
        if( roll == 19){
            damage = getAttackDamage()*2;
        } else if (roll == 0) {
            damage = 0;
        }else{
            damage = getAttackDamage();
        }

        System.out.printf(" %s is attacking %s for %d damage\n ", name, attacked.getName(),damage);
        attacked.hurt(damage);

        if(attacked.isDead){
            System.out.println(attacked.getName() + " has died by that hit\n ");
        }

    }

    // METODI DI RIPRISTINO
    public void heal (int recivedHeal){
        if((maxHp - healthPoints)> recivedHeal){
            healthPoints += recivedHeal;
            System.out.printf("%s healed %d",name,recivedHeal);
        }else {
            healthPoints = maxHp;
            System.out.printf("%s has fully healed",name);
        }
    }

    public void sleep(){
        heal(10000000);
        System.out.printf("%s sleeps",name);
    }

    public void eat (Item item){
        //@TODO implementare una cura in base a i parametri di cura del oggetto di cura
    }

    // METODI DI GESTIONE

    public void pickUpItem (Item item){

        switch (item.getType()){
            case ARMOR -> {
                AtomicInteger numOfItem= new AtomicInteger();
                inventory.forEach(item1 -> {
                    if (item1.getType() == ItemType.ARMOR) {
                        numOfItem.getAndIncrement();
                    }
                });
                if(numOfItem.get()<=2){inventory.add(item);}

            }
            case FOOD -> {
                AtomicInteger numOfItem= new AtomicInteger();
                inventory.forEach(item1 -> {
                    if (item1.getType() == ItemType.FOOD) {
                        numOfItem.getAndIncrement();
                    }
                });
                if(numOfItem.get()<=5){inventory.add(item);}

            }
            case WEAPON -> {
                AtomicInteger numOfItem= new AtomicInteger();
                inventory.forEach(item1 -> {
                    if (item1.getType() == ItemType.WEAPON) {
                        numOfItem.getAndIncrement();
                    }
                });
                if(numOfItem.get()<=3){inventory.add(item);}

            }
            case POTION -> {
                AtomicInteger numOfItem= new AtomicInteger();
                inventory.forEach(item1 -> {
                    if (item1.getType() == ItemType.POTION) {
                        numOfItem.getAndIncrement();
                    }
                });
                if(numOfItem.get()<=5){inventory.add(item);}

            }
            case JUNK -> {
                AtomicInteger numOfItem= new AtomicInteger();
                inventory.forEach(item1 -> {
                    if (item1.getType() == ItemType.JUNK) {
                        numOfItem.getAndIncrement();
                    }
                });
                if(numOfItem.get()<=10){inventory.add(item);}

            }
        }

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttackDamage() {
        return attackDamage;
        //@todo implementare un modo di aggiungere danni in base al arma usata per attaccare
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public Room getCurrentroom() {
        return currentroom;
    }

    public void setCurrentroom(Room currentroom) {
        this.currentroom = currentroom;
    }

    public int getXpOnDeath() {
        return xpOnDeath;
    }

    public void setXpOnDeath(int xpOnDeath) {
        this.xpOnDeath = xpOnDeath;
    }

    public String getEntityColor() {
        return entityColor;
    }

    public void setEntityColor(String entityColor) {
        this.entityColor = entityColor;
    }
}
