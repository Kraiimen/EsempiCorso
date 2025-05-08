package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Player;

import java.util.HashMap;

public class PlayerData {
    private static HashMap<HashMap, Player> playerData = new HashMap<>();

    public static void addPlayerData(Player player){
        playerData.put(player.getCredentials(), player);
    }
    // /--METHODS--/
    public static Player checkCredentials(String email, String password){
        for(HashMap h : playerData.keySet()){
            if(h.containsKey(email)){
                return h.get(email).equals(password)? playerData.get(h) : null;
            }
        }
        return null;
    }

    // /--GETTER-&-SETTER--/
    public static HashMap<HashMap, Player> getPlayerData() {
        return playerData;
    }
}
