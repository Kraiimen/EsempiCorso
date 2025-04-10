package org.generation.italy.fantasyGame.entity.player;

import org.generation.italy.fantasyGame.entity.Entity1;

public class Berserker extends Player {
    private boolean isRaging;
    private static final int BASE_XP = 10;


    public Berserker(String name, int maxHp, String namePlayer){
        super(name, maxHp, 10, namePlayer, BASE_XP);
    }
    public void berserk(){
        int n = rand.nextInt(10);
        if(n == 10){
            damage = damage * 2;
            System.out.println("Attacco incazzato a bestia");
        }
    }
    public void attack(Entity1 target){
        if(getHealthPoints() < 20){
            System.out.println("Attacco incazzato a bestia");
        } else {
            int n = rand.nextInt(1, 6);
            if((n == 4) && (5>= 1)){
                System.out.println("Attacco incazzato a bestia");
            }
        }
    }
}
