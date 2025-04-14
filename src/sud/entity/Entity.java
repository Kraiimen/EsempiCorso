package sud.entity;

import sud.dices;
import sud.items.*;
import sud.rooms.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Entity {
    private String name;
    private int healthPoints;
    private int maxHp;
    private int attackDamage;
    private boolean isDead;
    private int xpOnDeath=0;
    private Room currentRoom;
    private ArrayList<Item> inventory;
    public static Weapon baseWeapon = new Weapon(0,"Nothing",2);
    private Weapon equipedWeapon = baseWeapon;
    public static Armor baseArmor = new Armor(0,"Nothing", 0,0);
    private Armor equipedArmor= baseArmor;
    private int ac;
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
        this.currentRoom = currentroom;
        inventory = new ArrayList<>();
        this.ac = 10;
    }

    public Entity(String name, int maxHp, int attackDamage, Room currentroom, String entityColor){
        this( name, maxHp, attackDamage, currentroom);
        this.entityColor = entityColor;
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
            healthPoints -= recivedDamage-equipedArmor.getDamageReducer();
        }
    }

    public void printHpBar(){
        int barLenght = 20;
        if(this.healthPoints > 100){
            barLenght = 50;
        }
        int filledLenght = (int)(((double) this.healthPoints) / maxHp * barLenght);

        String bar = " [";

        for(int i = 0; i < barLenght; i++){
            if(i < filledLenght) {
                bar += "█";
            } else {
                bar += "░";
            }
        }
        bar += "] ";
        System.out.printf("%-20s: %s%s%s%d/%d\n", this.getName(),this.entityColor,bar,Entity.resetColor,healthPoints,maxHp);
    }

    public void attack (Entity attacked){
        int damage=0;
        int roll = dices.rd20();
        if( roll == 20){
            damage = equipedWeapon.rollDamage()*2;
        } else if (roll == 1) {
            System.out.printf(getWithColor("<Your attack was soo weak %s uses the opportunity and attacks you>\n"),attacked.getName());
            attacked.attack(this);
            return;
        }else if(doesAttackRollHit(attacked,roll)){
            damage = equipedWeapon.rollDamage();
            System.out.printf(getWithColor("<%s is attacking %s for %d damage>\n"), name, attacked.getName(),damage);
            attacked.hurt(damage);
        } else if (!doesAttackRollHit(attacked,roll )) {
            System.out.printf(getWithColor("<%s missed his attack>\n"), name);
        }
        if(attacked.isDead){
            System.out.printf(getWithColor("<%s has died by that hit>\n"),attacked.getName());

        }

    }

    // METODI DI RIPRISTINO
    public void heal (int recivedHeal){
        if((maxHp - healthPoints)> recivedHeal){
            healthPoints += recivedHeal;
            System.out.printf(getWithColor("%s healed %d"),name,recivedHeal);
        }else {
            healthPoints = maxHp;
            System.out.printf(getWithColor("%s has fully healed"),name);
        }
    }

    public void sleep(){
        heal(10000000);
        System.out.printf(getWithColor("\n%s sleeps\n"),name);
    }

    public void eat (Food food){
        if(food == null){
            System.out.println(getWithColor("This is not edible"));
        }else{
            heal(food.getHealingFacotr());
        }
    }

    // METODI DI GESTIONE

    public void pickUpItem (Item item, Boolean wantToEquip){

        switch (item.getType()){
            case ARMOR -> {
                AtomicInteger numOfItem= new AtomicInteger();
                inventory.forEach(item1 -> {
                    if (item1.getType() == ItemType.ARMOR) {
                        numOfItem.getAndIncrement();
                    }
                });
                if(wantToEquip){equipedArmor = (Armor)item;}
                if(numOfItem.get()<=2){inventory.add(item);}


            }
            case WEAPON -> {
                AtomicInteger numOfItem= new AtomicInteger();
                inventory.forEach(item1 -> {
                    if (item1.getType() == ItemType.WEAPON) {
                        numOfItem.getAndIncrement();
                    }
                });
                if(wantToEquip){equipedWeapon = (Weapon)item;}
                if(numOfItem.get()<=3){inventory.add(item);}

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

    public Item doesEntityHaveItem(ItemType type){
        return inventory.stream().filter(i-> i.getType() == type).findFirst().orElse(null);
    }
    public boolean doesEntityhaveitemInInventoryOfType(ItemType type){
        for (Item i : inventory){
            if(i.getType() == type){
                return true;
            }
        }
        return false;
    }

    public boolean doesAttackRollHit (Entity attacked, int roll){
        if(roll >= attacked.getAc()){
            return true;
        }
        return false;
    }

    public String getWithColor(String message) {
        return entityColor + message + resetColor;
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

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getXpOnDeath() {
        return xpOnDeath;
    }
    public void setXpOnDeath(int xpOnDeath) {
        this.xpOnDeath = xpOnDeath;
    }

    public String getEntityColor() {return entityColor;}
    public void setEntityColor(String entityColor) {this.entityColor = entityColor;}

    public Weapon getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setEquipedWeapon(Weapon equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    public Armor getEquipedArmor() {
        return equipedArmor;
    }

    public void setEquipedArmor(Armor equipedArmor) {
        this.equipedArmor = equipedArmor;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
