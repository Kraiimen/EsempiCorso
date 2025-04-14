package sud.actors.characters;

import sud.actors.Actor;

public class Player {
    private Actor player;

    private int currentExp;
    private int level;
    private int expToLevelUp;

    public Player(Actor a){
        player = a;
    }

    public void levelUp(){

    }

    public void obtainExp(int exp){

    }

    public int getCurrentExp() {
        return currentExp;
    }
    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getExpToLevelUp() {
        return expToLevelUp;
    }
    public void setExpToLevelUp(int expToLevelUp) {
        this.expToLevelUp = expToLevelUp;
    }
}
