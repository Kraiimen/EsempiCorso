package org.generation.italy.gryffindor.mud.game;

public class Paladin extends Player {
    // /-----------/ ATTRIBUTI (FIELDS) /-----------/
    private boolean isVirgin;

    // /-----------/ CONSTRUCTORS /-----------/
    public Paladin(String name, int maxHealthPoint, int damage, String playerName, boolean isVirgin){
        super(name, maxHealthPoint, damage, playerName);
        this.isVirgin = isVirgin;
    }

    // /-----------/ METHODS /-----------/
    public void attackWithLance() {
        System.out.println("attacca con la lancia");
    }


    // /-----------/ METHODS - GETTER & SETTER /-----------/
    public boolean getIsVirgin() {
        return isVirgin;
    }
    public void setIsVirgin(boolean isVirgin) {
        if(this.isVirgin){
            this.isVirgin = isVirgin;
        }
    }
}
