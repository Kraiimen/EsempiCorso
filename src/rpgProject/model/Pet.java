package rpgProject.model;

import java.util.Random;

public class Pet extends Character{
    Random random = new Random();
    public Pet(String name,int health,int attackpower,String classType){
        super(name,health,attackpower,classType);
    }
    @Override
    public void attack(Character target){
            int damage = random.nextInt(getAttackPower())/2;
            System.out.println(getName()+" attacks "+target.getName());
            target.takeDamage(damage);
    }
    public void attackHeal(Character target,Character ally) {
        int damage = random.nextInt(getAttackPower()) / 3;
        System.out.println(getName() + " attacks " + target.getName());
        target.takeDamage(damage);
        int heal = random.nextInt(getAttackPower()) / 2;
        System.out.println(getName() + " is healing " + ally.getName());
        ally.heal(heal);
    }
    @Override
    public void displayInfo() {
        System.out.println("=== CHARACTER INFO ===");
        System.out.println("Name   : " + getName());
        System.out.println("Class  : " + classType);
        System.out.println("Health : " + getHealth());
        System.out.println("======================\n");
    }
}
