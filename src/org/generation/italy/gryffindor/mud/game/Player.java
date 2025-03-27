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
            System.out.println(playerName +  " attacca " + target.getName());

            target.setCurrentHealthPoint(target.getCurrentHealthPoint() - getDamage());
            if (target.getCurrentHealthPoint() <= 0) {
                currentExpPoint += earnedExp;
            }
        }
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
