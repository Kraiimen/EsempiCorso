package capstoneproject.entity;

import capstoneproject.Room;

import java.util.Random;

public class Wizard extends Player {
    public Wizard(int maxHealt, int maxDamage, String playerName) {
        super(maxHealt, maxDamage, playerName);
        this.playerName = playerName;
        this.strength = this.random.nextInt(21);
        this.intelligence = 5 + this.random.nextInt(21);
        this.agility = this.random.nextInt(21);
        this.stamina = this.random.nextInt(21);
    }

    @Override
    public void attack(Entity target) {

    }

    @Override
    void openInventory() {

    }

    @Override
    void runAway() {

    }

//    public Wizard(String name, Room startingRoom) {
//        super(name, startingRoom);
//        this.maxHealth = 20 + stamina;
//        this.strength = new Random().nextInt(21);
//        this.intelligence = 5 + new Random().nextInt(21);
//        this.agility = new Random().nextInt(21);
//        this.stamina = stamina;
//    }

}
