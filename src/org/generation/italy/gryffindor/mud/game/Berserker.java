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

    @Override
    public void attack(Entity target){
        Npc enemy;
        boolean canBeAttacked = true;
        long earnedExp = 0;
        int multiplier = berserk();

        if(target.getClass() == Npc.class) {
            enemy = (Npc)target;
            canBeAttacked = enemy.getCanBeAttacked();
            earnedExp = enemy.getEarnedXP();
        }
        if(target != null && canBeAttacked){
            target.setCurrentHealthPoint(target.getCurrentHealthPoint() - (getDamage() * multiplier));
            System.out.println(getPlayerName() +  " attacca " + target.getName());
            if (target.getCurrentHealthPoint() <= 0) {
                setCurrentExpPoint(getCurrentExpPoint() + earnedExp);
                System.out.println(target.getName() + " è morto");
            }
        }
    }


    // /-----------/ METHODS - GETTER & SETTER /-----------/
    //NO DIFFERENCE FROM PLAYER YET
}
