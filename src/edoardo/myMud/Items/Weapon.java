package edoardo.myMud.Items;

import edoardo.myMud.Item;

public class Weapon extends Item {
    private int damage;
    private int precision;

    public Weapon(String name, int price, int damage, int precision){
        super(name, price);
        this.damage = damage;
        this.precision = precision;
    }
    @Override
    public void printDetails(){
        System.out.printf("Name: %s, Price: %d,Damage: %d, Precision: %d", getName(), getPrice(), damage, precision);
    }
    public int getDamage(){
        return damage;
    }
    public int getPrecision(){
        return precision;
    }
}
