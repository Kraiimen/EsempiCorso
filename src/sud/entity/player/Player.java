package sud.entity.player;


import sud.entity.Entity;
import sud.exceptions.InvalidAttackException;
import sud.inventory.Inventory;

public abstract class Player extends Entity {
    int intelligence;
    int strength;
    int agility;
    int stamina;
    int experiencePoints;
    int balance;
    Inventory inventory;


    public Player(String name, int maxHealth, int damage, int intelligence, int strength, int agility, int stamina) {
        super(name, maxHealth, damage);
        this.experiencePoints = 0;
        this.balance = 0;
        this.inventory = new Inventory();
    }

    @Override
    public void attack(Entity target) {
        if (!this.isAlive()) {
            throw new InvalidAttackException();
        } else if (!target.isAlive()) {
            System.out.println("Target is already dead");
            return;
        }
        target.getDamaged(damage);
    }

    public void obtainExperience(int experiencePoints) {
        this.experiencePoints += experiencePoints;
        System.out.println(getName() + " obtained " + experiencePoints + " experience points");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getBalance() {
        return balance;
    }

    public boolean hasMoneyAmount(int amount) {
        return balance >= amount;
    }

    public void removeMoney(int amount) {
        balance -= amount;
        System.out.println(getName() + " spent " + amount + "$");
        printBalance();
    }

    public void addMoney(int amount) {
        balance += amount;
        System.out.println(getName() + " earned " + amount + "$");
        printBalance();
    }

    public void printBalance() {
        System.out.println(getName() + " has " + balance + "$");
    }
}
