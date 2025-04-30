package org.generation.italy.gryffindor.mud.game;

public class Player extends Entity{
    // /-----------/ ATTRIBUTI (FIELDS) /-----------/
    private String playerName;
    private long currentExpPoint;

    // /-----------/ CONSTRUCTORS /-----------/
    public Player(String name, int maxHealthPoint, int damage, String playerName){
        super(name, maxHealthPoint, damage);
        this.playerName = playerName;
        currentExpPoint = 0;
    }


    // /-----------/ METHODS /-----------/
    public void login(){
        System.out.println("sto facendo il login");
    }
    public void logout(){
        System.out.println("sto facendo il logout");
    }

    @Override
    protected boolean canNotAttack(Entity target){
        boolean res = super.canNotAttack(target);

        if ( !(res) && isNpc(target)){
            Npc npc = (Npc)target;
            res = !(npc.getCanBeAttacked());
        }
        return res;
    }
    @Override
    protected void handleEnemyDeath(Entity target){
        super.handleEnemyDeath(target);
        if(isNpc(target)){
            Npc npc = (Npc)target;
            currentExpPoint += npc.getEarnedXP();
        }
    }

    protected boolean isNpc(Entity target){
        return target.getClass() == Npc.class;
    }

    // /-----------/ METHODS - GETTER & SETTER /-----------/
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String n){
        playerName = n;
    }
    public long getCurrentExpPoint(){
        return currentExpPoint;
    }
    public void setCurrentExpPoint(long exp){
        if (exp >= 0) {
            currentExpPoint = exp;
        }
    }
}
