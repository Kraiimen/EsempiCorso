package org.generation.italy.sudProject.entities;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.Spawner;
import org.generation.italy.sudProject.map.Room;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.generation.italy.sudProject.map.Room.CAT_INDEX;
import static org.generation.italy.sudProject.map.Room.GUARD_INDEX;
import static org.generation.italy.sudProject.map.WorldMap.world;

public class Player extends Entity{
    // /--ATTRIBUTES--/
    private String firstName;
    private String lastName;
    private Map<String, String> credentials = new HashMap<>();
    private String playerName;
    private LocalDate creationDate = LocalDate.now();
    public static int numberOfPlayers;
    private static Room playerPosition = world.getFirst();
    private int playerLevel;
    private static final int HP_FIRST_SPAWN = 3;
    private static final int HP_MAX_FIRST_SPAWN = 10;

    // /--CONSTRUCTORS--/
    public Player(String firstName, String lastName, String email, String password, String playerName, int indexClassStat, int classStat){
        super(playerName, MIN_ATTRIBUTE_P_VALUE, MAX_ATTRIBUTE_P_VALUE, indexClassStat, classStat, HP_FIRST_SPAWN, HP_MAX_FIRST_SPAWN,
                2, playerPosition, -1, true, 10);
        this.firstName = firstName;
        this.lastName = lastName;
        credentials.put(email, password);
        this.playerName = playerName;
        numberOfPlayers++;
    }
    // /--METHODS--/
    public void login(boolean check){
        if(check){
            System.out.println("Welcome " +playerName+ " to MOON RISES AGAIN");
        }
    }
    public void logout(){
        System.out.println("Bye "+playerName);
    }
    //controlla che le credenziali siano giuste
    private boolean checkCredentials(String email, String password){
        return credentials.containsKey(email) && credentials.containsValue(password);
    }

    //NORD 0, SUD 1, EST 2, OVEST 3
    private void playerMove(String d) {
        String direction = d.toUpperCase();
        switch (direction) {
            case "NORD":
                if (playerPosition.getNorthRoom() != null) {
                    playerPosition = playerPosition.getNorthRoom();
                    Spawner.resetGuardsInRoom(playerPosition);
                }
                break;
            case "SOUTH":
                if (playerPosition.getSouthRoom() != null) {
                    playerPosition = playerPosition.getSouthRoom();
                    Spawner.resetGuardsInRoom(playerPosition);
                }
                break;
            case "EAST":
                if (playerPosition.getEastRoom() != null) {
                    playerPosition = playerPosition.getEastRoom();
                    Spawner.resetGuardsInRoom(playerPosition);
                }
                break;
            case "WEST":
                if (playerPosition.getWestRoom() != null) {
                    playerPosition = playerPosition.getWestRoom();
                    Spawner.resetGuardsInRoom(playerPosition);
                }
                break;
            default:
                System.out.println("INSERISCI LA DIREZIONE!");
                break;
        }
        System.out.println("Luogo attuale: "+playerPosition.getRoomName());
        System.out.println(playerPosition.getRoomDescription());
        playerPosition.showEntitiesInRoom();
    }
    @Override
    public void attack(Entity target) {
        switch(target.getIndexEntityPosition()){
            case CAT_INDEX:
                if(playerPosition.getRoomEntities().get(GUARD_INDEX) != null){
                    target.setHp(target.getHp() - this.getAtk());
                }else{
                    System.out.println("Ci sono guardie nei dintorni, non puoi attaccare");
                }
            default:
                if(target.isCanBeAttacked()){
                    target.setHp(target.getHp() - this.getAtk());
                }
        }
        if(isDead(target)){
            target.die();
        }
    }

    // /--GETTER-&-SETTER--/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public Room getPlayerPosition() {
        return playerPosition;
    }
}
