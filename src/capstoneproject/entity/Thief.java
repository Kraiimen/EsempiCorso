package capstoneproject.entity;

import capstoneproject.Room;

import java.util.Random;

public class Thief extends Player {
    public Thief(int maxHealt, int maxDamage, String playerName) {
        super(maxHealt, maxDamage, playerName);
        this.playerName = playerName;
        this.strength = new Random().nextInt(21);
        this.intelligence =  new Random().nextInt(21);
        this.agility = 5 + new Random().nextInt(21);
        this.stamina = new Random().nextInt(21);
    }

}
