package VideoGame.Charactes.Personaggi;

import VideoGame.Charactes.Player;

import java.util.Random;

public class Wizard extends Player {




    public Wizard(String nome, int esperienza){
        Random dude = new Random();
        int fo = dude.nextInt(6,10);
        int dest = dude.nextInt(8,12);
        int cos = dude.nextInt(6,10);
        int inte = dude.nextInt(14,21);
        int sag = dude.nextInt(10,16);
        int car = dude.nextInt(8,14);
        int vita = dude.nextInt(5,12);
        super(nome, fo, dest, cos, inte, sag, car, vita);

    }

}
