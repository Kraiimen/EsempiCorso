package rpgProject.model;

public class Orc extends Enemy {

    public Orc(String name, int health, int level, int attackPower) {
        super(name, health, level, attackPower);
    }

    //Bonk
    public void bonk(Character target) {
        int damage = getAttackPower() / 2 + 5; // Balanced damage formula
        System.out.println(getName() + " swings its club and Bonks " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }
}

