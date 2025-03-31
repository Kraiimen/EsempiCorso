package edoardo.myMud;

import edoardo.myMud.items.DefensiveGear;
import edoardo.myMud.items.Weapon;

import java.util.Random;

public abstract class Entity {
    private static int itemCategories = ItemsCategories.values().length;
    private static int limitForObjectCategory = 5;
    private int damage;
    private int hp;
    private int maxHp;
    private int defence;
    private int agility;
    private int lv;
    private Weapon[] weaponEquipped;
    private DefensiveGear[] defensiveGearEquipped;
    private Item[][] inventary = new Item[itemCategories][limitForObjectCategory];
    private int weight;
    private Random random;


    public Entity(int damage, int defence, int agility, int maxHp){
        this.damage = damage;
        this.defence = defence;
        this.agility = agility;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }
    public Entity(int damage, int defence, int agility, int maxHp, int lv){
        this(damage, defence, agility, maxHp);
        this.lv = lv;
    }
    public abstract void attack(Entity enemy);
    public abstract void defendFromAttack();
    public abstract boolean isDodging();
    public abstract int getAgilityAdjustedByWeight();
    public void heal(int receivedHealth){
        if(maxHp<receivedHealth+hp){
            hp = maxHp;
        } else{
            hp += receivedHealth;
        }

    }

}
