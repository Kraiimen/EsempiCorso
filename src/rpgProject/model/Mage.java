package rpgProject.model;

import java.util.Random;

public class Mage extends Character {
    Random random = new Random();
    public Mage(String name, int health, int level) {
        super(name, health, level, "Mage", 10,0);

    }
    @Override
    // Mage's basic attack
    public void attack(Character target) {
        int damage = random.nextInt(getAttackPower())+2; // Slightly stronger attack
        System.out.println(getName() + " casts Energy Ball on " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
        if(target.getHealth()<=0) {
            int expGained = (random.nextInt(getLevel()) * 3) + 5;
            setExperience(getExperience() + expGained);
            System.out.println(getName() + " gained " + expGained+" xp!");
            levelUpManage();
        }
    }

    // Mage's powerful fireball spell
    public void castFireball(Character target) {
        int damage = random.nextInt(getAttackPower())+5;
        System.out.println(getName() + " hurls a Fireball at " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
        if(target.getHealth()<=0) {
            int expGained = (random.nextInt(getLevel()) * 3) + 5;
            setExperience(getExperience() + expGained);
            System.out.println(getName() + " gained " + expGained+" xp!");
            levelUpManage();
        }
    }
}
