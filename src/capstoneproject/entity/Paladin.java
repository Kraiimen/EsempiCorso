package capstoneproject.entity;

import capstoneproject.Room;

import java.util.Random;

public class Paladin extends Player {

    public Paladin(int maxHealt, int maxDamage, String playerName) {
        super(maxHealt, maxDamage, playerName);
        this.playerName = playerName;
        this.strength = 5 + new Random().nextInt(21);
        this.intelligence =  new Random().nextInt(21);
        this.agility = new Random().nextInt(21);
        this.stamina = new Random().nextInt(21);
    }

    @Override
    public String toString() {
        return "Paladin{" +
                "playerName='" + playerName + '\'' +
                ", exp=" + exp +
                ", intelligence=" + intelligence +
                ", stamina=" + stamina +
                ", agility=" + agility +
                ", strength=" + strength +
                '}';
    }
}
