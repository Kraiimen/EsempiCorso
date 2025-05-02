package personal.mudGame;

public abstract class NPC extends Entity {
    private int expGiven;
    private boolean isEnemy;

    public NPC(String name, int maxHP, int power, int expGiven, boolean isEnemy){
        super(name, maxHP, power);
        this.expGiven = expGiven;
        this.isEnemy = isEnemy;
    }

    public abstract void giveInstructions(Entity player);

    public int getExpGiven(){
        return expGiven;
    }
    public boolean getIsEnemy(){
        return isEnemy;
    }
}
