package org.generation.italy.fantasyGame.entity.player;

import java.util.Random;

public class Berserker extends Player {

    public Berserker(String name, int maxHp, String namePlayer){
        super(name, maxHp, 10, namePlayer);
    }
    public void berserk(){
        Random rand = new Random();
        int n = rand.nextInt(10);
        if(n == 10){
            damage = damage * 2;
            System.out.println("Attacco incazzato a bestia");
        }
    }
}
