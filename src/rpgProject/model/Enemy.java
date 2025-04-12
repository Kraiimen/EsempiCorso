package rpgProject.model;

public abstract class Enemy extends Character {

    public Enemy(String name, int health, int level, int attackPower) {
        super(name, health, level, "Enemy", attackPower,0);
    }

    public void attack(Character target) {
        int damage = getAttackPower();
        System.out.println(getName() + " attacks " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }
    @Override
    public void turnManage() {
        System.out.println(getName()+" attack");
    }
}
