package org.generation.italy.gryffindor.mud.game;

public class Wizard extends Player{
    // /-----------/ ATTRIBUTI (FIELDS) /-----------/
    private int intelligence;

    // /-----------/ CONSTRUCTORS /-----------/
    public Wizard(String name, int maxHealthPoint, int damage, String playerName, int intelligence){
        super(name, maxHealthPoint, damage, playerName);
        this.intelligence = getValidIntelligence(intelligence);
    }

    // /-----------/ METHODS /-----------/
    public void castFireBall() {
        System.out.println("lancia palla di fuoco");
    }

    public int getValidIntelligence(int intelligence){
        if(intelligence < 0){
            return 0;
        }
        if(intelligence > 100){
            return 100;
        }
        return intelligence;
    }


    // /-----------/ METHODS - GETTER & SETTER /-----------/
    public int getIntelligence() {
        return intelligence;
    }
    public void setEarnedXP(int intelligence) {
        this.intelligence = getValidIntelligence(intelligence);
    }
}
