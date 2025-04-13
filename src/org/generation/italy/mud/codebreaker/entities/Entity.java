package org.generation.italy.mud.codebreaker.entities;

public abstract class Entity {
    private String characterName;
    private int maxHp;
    private int currentHealth;

    public Entity(){

    }
    public Entity(String characterName){
        this.characterName = characterName;
    }
    public Entity(String characterName, int maxHp){
        this.characterName = characterName;
        this.maxHp = maxHp;
        this.currentHealth = maxHp;
    }



    public String printHpBar(){
        int barLenght = 20;
        if(currentHealth > 100){
            barLenght = 50;
        }
        int filledLenght = (int)((double) currentHealth / maxHp * barLenght);

        String bar = "HP [";

        for(int i = 0; i < barLenght; i++){
            if(i < filledLenght) {
                bar += "█";
            } else {
                bar += "░";
            }
        }
        bar += "] ";
        return getCharacterName() + ": "  + "\u001B[32m" + bar + "\u001B[0m" + currentHealth + "/"+ maxHp ;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth){
        this.currentHealth = currentHealth;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }
    public String getCharacterName(){
        return characterName;
    }
    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }

}
