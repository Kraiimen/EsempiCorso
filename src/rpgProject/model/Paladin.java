package rpgProject.model;

import java.util.Random;

public class Paladin extends Character{
    Random random = new Random();
    public Paladin(String name,int health,int level){
        super(name,health,level,"Paladin",10,0);
    }
    public void cure(Character target){
        int heal = random.nextInt(getAttackPower());
        System.out.println(getName()+" is healing "+target.getName());
        target.heal(heal);
    }
    public void salvation(Character target){
        System.out.println(getName()+" cast Salvation");
        heal(random.nextInt(getAttackPower()));
        attack(target);
    }
}
