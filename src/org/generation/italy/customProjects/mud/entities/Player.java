package org.generation.italy.customProjects.mud.entities;

import org.generation.italy.customProjects.mud.engine.Movement;
import org.generation.italy.customProjects.mud.items.Food;
import org.generation.italy.customProjects.mud.items.Item;
import org.generation.italy.customProjects.mud.items.Weapon;
import org.generation.italy.customProjects.mud.world.Place;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Entity implements Movement {
    //   /-----/-STATE-/-----/
    private int exp;
    private static int killedEntities;
    private static int money;
    private Weapon fists = new Weapon("Fists", 0, true, 0);
    private List<Weapon> weaponInventory = new ArrayList<>();
    private List<Food> foodInventory = new ArrayList<>();



    //   /-----/-CONSTRUCTORS-/-----/
    public Player(String name, int currentHealth, int maxHealthPoint, Place currentPlace) {
        super(name, currentHealth, maxHealthPoint, currentPlace);
        weaponInventory.add(fists);
        exp = 0;
        killedEntities = 0;
        money = 10;
    }


    //   /-----/-METHODS-/-----/
    public int attack(int weaponIndex) {
        int attackDamage = getAttackDamage();
        if (weaponInventory.size() > 1 && weaponIndex < weaponInventory.size()) {
            attackDamage = getAttackDamage() + weaponInventory.get(weaponIndex).getDamage();
            System.out.println("Attacchi con " + weaponInventory.get(weaponIndex).getItemName());
        }
        else {
            System.out.println("Attacchi a mani nude!");
        }
        return attackDamage;
    }

    public void eat(int foodIndex) {
        int foodPoint = 0;
        if (foodInventory.isEmpty()) {
            System.out.println("Non hai cibo nel tuo inventario! Cerca del cibo in giro o comprane in un negozio");
        }
        else if(foodIndex >= 0 && foodIndex < foodInventory.size()) {
            foodPoint = foodInventory.get(foodIndex).getHealthPoint();
            setCurrentHealth(Math.max(getCurrentHealth() + foodPoint, getMaxHealthPoint()));
        }
        else if (foodIndex < 0) {
            System.out.println("Cerca bene nel tuo zaino");
        }
    }

    public void sleep() {
        setCurrentHealth(getMaxHealthPoint());
        System.out.println("Hai dormito, la tua salute si è ripristinata!");
    }

    public Weapon useWeapon(int i) {
        if (i > 0 && i < weaponInventory.size()) {
            return weaponInventory.get(i);
        }
        else {
            return weaponInventory.getFirst();
        }
    }

    public void buyWeapon(Weapon weapon) {
        if(money >= weapon.getCost()) {
            weaponInventory.add(weapon);
            money = getMoney() - weapon.getCost();
            System.out.println("Hai acquistato " + weapon.getItemName() + "per " + weapon.getCost() + "monete");
        }
        else{
            System.out.println("Non hai monete sufficienti per acquistare " + weapon.getItemName() + ", costa " + weapon.getCost());
        }
    }

    public void buyFood(Food food) {
        if(money >= food.getCost()) {
            foodInventory.add(food);
            money = getMoney() - food.getCost();
            System.out.println("Hai acquistato " + food.getItemName() + "per " + food.getCost() + "monete");
        }
        else{
            System.out.println("Non hai monete sufficienti per acquistare " + food.getItemName() + ", costa " + food.getCost());
        }
    }

    public abstract void speak();
    @Override
    public void move() {
        // IMPLEMENTARE!!!
    }

    //   /-----/-METHODS-/-GETTER-&-SETTER-/-----/
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getKilledEntities() {
        return killedEntities;
    }
    public void setKilledEntities(int killedEntities) {
        Player.killedEntities = killedEntities;
    }
    public static int getMoney() {
        return money;
    }
    public static void setMoney(int money) {
        Player.money = money;
    }
}
