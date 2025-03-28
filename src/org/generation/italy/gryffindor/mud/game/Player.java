package org.generation.italy.gryffindor.mud.game;

public class Player extends Entity{

    private String playerName;
    private long currentExpPoint;


    public Player(String playerName, String name, int maxHealthPoint){
        super(name, maxHealthPoint);
        this.playerName = playerName;
        currentExpPoint = 0;
    }



    public void login(){
        System.out.println("sto facendo il login");
    }
    public void logout(){
        System.out.println("sto facendo il logout");
    }

    @Override
    public void attack(Entity target){
        Npc enemy;
        boolean canBeAttacked = true;
        long earnedExp = 0;
        if(target.getClass() == Npc.class) {
            enemy = (Npc)target;
            canBeAttacked = enemy.getCanBeAttacked();
            earnedExp = enemy.getEarnedXP();
        }
        if(target != null && canBeAttacked){
            target.setCurrentHealthPoint(target.getCurrentHealthPoint() - 10);
            System.out.println(playerName +  " attacca " + target.getName());
            if (target.getCurrentHealthPoint() <= 0) {
                currentExpPoint += earnedExp;
            }
        }
    }




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
