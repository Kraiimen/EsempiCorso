package VideoGame.Charactes.Personaggi;

import VideoGame.Charactes.Player;

import java.util.Random;

public class Paladin extends Player {

    public Paladin(String nome, int esperienza){
           Random dude = new Random();
           int fo = dude.nextInt(12,18);
           int dest = dude.nextInt(6,12);
           int cos = dude.nextInt(12,18);
           int inte = dude.nextInt(6,12);
           int sag = dude.nextInt(12,16);
           int car = dude.nextInt(10,14);
           int vita = dude.nextInt(16,20);
           super(nome, fo, dest, cos, inte, sag, car, vita);

       }



}

