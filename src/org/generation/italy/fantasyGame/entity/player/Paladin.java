package org.generation.italy.fantasyGame.entity.player;

public class Paladin extends Player {
    private boolean isVirgin;

    public Paladin(String name, int maxHp, String namePlayer, boolean isVirgin) {
        super(name, maxHp, 10, namePlayer);
        this.isVirgin = isVirgin;
    }
    public void spearAttack(){
        if(isVirgin){
            damage = 20;
            System.out.println("Attacca con lancia divina");
        }else{
            System.out.println("Attacca con lancia");
        }
    }
}
