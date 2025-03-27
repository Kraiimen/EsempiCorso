package org.generation.italy.gryffindor.mud.game;

public class Player extends Entity{

    //     /-----/-VARIABLES-/-----/
    private String playerName;
    private long currentExpPoint;

    //     /-----/-CONSTRUCTORS-/-----/
    public Player(String playerName, String name, int maxHealthPoint) {
        super(name, maxHealthPoint);
        this.playerName = playerName;
        currentExpPoint = 0;
    }

    //     /-----/-METHODS-/-----/
    public void login() {
        System.out.println("Sto facendo il login...");
    }
    public void logout() {
        System.out.println("Sto facendo il logout...");
    }


    //     /-----/-METHODS-/-GETTER-&-SETTER-/-----/
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public long getCurrentExpPoint() {
        return currentExpPoint;
    }
    public void setCurrentExpPoint(long currentExpPoint) {
        if (currentExpPoint >= 0) {
            this.currentExpPoint = currentExpPoint;
        }
    }


}
