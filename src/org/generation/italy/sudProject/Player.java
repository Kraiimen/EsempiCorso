package org.generation.italy.sudProject;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

public class Player extends Entity {
    // /--ATTRIBUTES--/
    private String firstName;
    private String lastName;
    private Map<String, String> credentials;
    protected String playerName;
    private LocalDate creationDate = LocalDate.now();
    private int[] stats = new int[6];


    // /--CONSTRUCTORS--/
    public Player(String firstName, String lastName, String email, String password, String playerName){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        credentials.put(email, password);
        this.playerName = playerName;
    }
    // /--METHODS--/
    public void login(){
        System.out.println("Welcome " +playerName+ " to GAMENAME");
    }
    public void logout(){
        System.out.println("Bye "+playerName);
    }
    private boolean checkCredentials(String email, String password){
        return credentials.containsKey(email) && credentials.containsValue(password);
    }
    private int[] randomizeStats(int indexClassStat, int classStat){
        Random dice = new Random();

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
}
