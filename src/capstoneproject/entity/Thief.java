package capstoneproject.entity;

import capstoneproject.Room;

import java.util.Random;

public class Thief extends Player {
    public Thief(int maxHealt, int maxDamage, String playerName) {
        super(maxHealt, maxDamage, playerName);
        this.playerName = playerName;
        this.strength = this.random.nextInt(21);
        this.intelligence =  this.random.nextInt(21);
        this.agility = 5 + this.random.nextInt(21);
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

}
