package org.generation.italy.fantasyGame.entity.player;

import org.generation.italy.fantasyGame.entity.Entity;

public class Paladin extends Player {
    private boolean isVirgin;

    public Paladin(String name, int maxHp, String namePlayer, boolean isVirgin, long exp) {
        super(name, maxHp, 10, namePlayer, exp);
        this.isVirgin = isVirgin;
    }
    @Override
    public void attack(Entity target){
        if(isVirgin){
            damage = 20;
            System.out.println("Attacca con lancia divina");
        }else{
            System.out.println("Attacca con lancia");
        }
    }
}
