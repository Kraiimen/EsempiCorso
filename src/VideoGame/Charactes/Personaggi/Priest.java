package VideoGame.Charactes.Personaggi;

import VideoGame.Charactes.Player;

import java.util.Random;

public class Priest extends Player {


    public Priest(String nome, int esperienza){
        Random dude = new Random();
        int fo = dude.nextInt(6,10);
        int dest = dude.nextInt(6,12);
        int cos = dude.nextInt(6,12);
        int inte = dude.nextInt(12,18);
        int sag = dude.nextInt(14,20);
        int car = dude.nextInt(8,14);
        int vita = dude.nextInt(10,16);
        super(nome, fo, dest, cos, inte, sag, car, vita);

    }


}



