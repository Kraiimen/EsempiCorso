package org.generation.italy.footballTeamProject.team;

import java.util.ArrayList;

public class Footballteam {

    private ArrayList players;

    public void addPlayer(Player p){ //ho una variabile di nome p di tipo Player, p è un oggetto di tipo Player, Player è la classe
        if( players != null){
            return; // la keyword return senza nulla mi esce dalla funzione
        }
        if(p != null) {
            players.add(p);
        }
    }
}

