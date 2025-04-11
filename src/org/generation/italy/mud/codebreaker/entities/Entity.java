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
