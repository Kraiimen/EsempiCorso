package capstoneproject.entity;

import capstoneproject.Room;

import java.util.Random;

public class Paladin extends Player {


    public Paladin(String name, Room startingRoom) {
        super(name, startingRoom);
        this.maxHealth = 20 + stamina;
        this.strength = 5 + new Random().nextInt(21);
        this.intelligence =  new Random().nextInt(21);
        this.agility = new Random().nextInt(21);
        this.stamina = new Random().nextInt(21);
    }
}
