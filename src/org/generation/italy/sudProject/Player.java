package org.generation.italy.sudProject;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Player extends Entity {
    // /--ATTRIBUTES--/
    private String firstName;
    private String lastName;
    private Map<String, String> credentials = new HashMap<>();
    protected String playerName;
    private LocalDate creationDate = LocalDate.now();
    protected int playerLevel;

    // /--CONSTRUCTORS--/
    public Player(String firstName, String lastName, String email, String password, String playerName, indice, valore){
        super(getStats(new int[6], indice, valore));
        this.firstName = firstName;
        this.lastName = lastName;
        credentials.put(email, password);
        this.playerName = playerName;
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
}
