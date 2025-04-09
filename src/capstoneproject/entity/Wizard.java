package capstoneproject.entity;

import capstoneproject.Room;

import java.util.Random;

public class Wizard extends Player {

    public Wizard(String name, Room startingRoom) {
        super(name, startingRoom);
        this.maxHealth = 20 + stamina;
        this.strength = new Random().nextInt(21);
        this.intelligence = 5 + new Random().nextInt(21);
        this.agility = new Random().nextInt(21);
        this.stamina = stamina;
    }

}
