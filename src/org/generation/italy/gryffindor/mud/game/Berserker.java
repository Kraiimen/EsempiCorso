package org.generation.italy.gryffindor.mud.game;

import java.util.Random;

public class Berserker extends Player{
    // /-----------/ ATTRIBUTI (FIELDS) /-----------/
    //NO DIFFERENCE FROM PLAYER YET

    // /-----------/ CONSTRUCTORS /-----------/
    public Berserker(String name, int maxHealthPoint, int damage, String playerName){
        super(name, maxHealthPoint, damage, playerName);
    }

    // /-----------/ METHODS /-----------/
    public int berserk() {
        Random r = new Random();
        int n = r.nextInt(10);
        if (n == 0){
            return 2;
        }
        return 1;
    }

    // /-----------/ METHODS - GETTER & SETTER /-----------/
    @Override
    public int getDamage(){
        return super.getDamage() * berserk();
    }
}
