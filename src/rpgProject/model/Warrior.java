package rpgProject.model;

import java.util.Random;

public class Warrior extends Character {
    Random random=new Random();
    public Warrior(String name, int health, int level) {
        super(name, health, level, "Warrior", 15,0);
    }

    //Double Slash
    public void doubleSlash(Character target) {
        int damage = (random.nextInt(getAttackPower())/2)+2;
        System.out.println(getName() + " performs a Double Slash on " + target.getName() + "!");
        target.takeDamage(damage);
        System.out.println("Follow-up strike!");
        target.takeDamage(damage);
        if(target.getHealth()<=0) {
            int expGained = (random.nextInt(getLevel()) * 3) + 5;
            setExperience(getExperience() + expGained);
            System.out.println(getName() + " gained " + expGained+" xp!");
            levelUpManage();
        }
    }
}

