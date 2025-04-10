package org.generation.italy.sudProject;

import org.generation.italy.sudProject.map.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.generation.italy.sudProject.map.WorldMap.world;

public class Player extends Entity {
    // /--ATTRIBUTES--/
    private String firstName;
    private String lastName;
    private Map<String, String> credentials = new HashMap<>();
    protected String playerName;
    private LocalDate creationDate = LocalDate.now();
    protected int playerLevel;
    public static int numberOfPlayers;
    public Room playerPosition = world.getFirst();

    // /--CONSTRUCTORS--/
    public Player(String firstName, String lastName, String email, String password, String playerName, int indexClassStat, int classStat){
        super(getStats(new int[6]), indexClassStat, classStat);
        this.firstName = firstName;
        this.lastName = lastName;
        credentials.put(email, password);
        this.playerName = playerName;
        numberOfPlayers++;
    }
    // /--METHODS--/
    public void login(boolean check){
        if(check){
            System.out.println("Welcome " +playerName+ " to GAMENAME");
        }
    }
    public void logout(){
        System.out.println("Bye "+playerName);
    }
    //controlla che le credenziali siano giuste
    private boolean checkCredentials(String email, String password){
        return credentials.containsKey(email) && credentials.containsValue(password);
    }

    public static int[] getStats(int[] stats){
        for(int n : stats){
            n = dice.nextInt(MIN_ATTRIBUTE_P_VALUE, MAX_ATTRIBUTE_P_VALUE);
        }
        return stats;
    }

    //NORD 0, SUD 1, EST 2, OVEST 3
    private void playerMove(String d) {
        String direction = d.toUpperCase();
        switch (direction) {
            case "NORD":
                if (playerPosition.getNorthRoom() != null) {
                    playerPosition = playerPosition.getNorthRoom();
                }
                break;
            case "SOUTH":
                if (playerPosition.getSouthRoom() != null) {
                    playerPosition = playerPosition.getSouthRoom();
                }
                break;
            case "EAST":
                if (playerPosition.getEastRoom() != null) {
                    playerPosition = playerPosition.getEastRoom();
                }
                break;
            case "WEST":
                if (playerPosition.getWestRoom() != null) {
                    playerPosition = playerPosition.getWestRoom();
                }
                break;
            default:
                System.out.println("INSERISCI LA DIREZIONE!");
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
