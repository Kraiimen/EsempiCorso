package org.generation.italy.capstoneProject;

import org.generation.italy.capstoneProject.models.worldMap.Map;
import org.generation.italy.capstoneProject.models.worldMap.Room;

import java.util.List;

public class Start {
    public static void main(String[] args) {

        // CREAZIONE MAPPA
        Map map = new Map();

        // POSIZIONE INIZIALE
        Room currentPosition = map.templeSquare;

        // COMANDI
        List<String> commands = List.of(
           "look", "go south", "look", "go east", "look", "go south", "go south", "go south", "look", "go north", "go north", "go west", "esc"
        );

        System.out.println("Welcome to MUD");
        System.out.println(("You are currently in: " + currentPosition.getName()));

        for(String command : commands) {
            System.out.println("\n> " + command);

            switch(command) {
                case "look":
                    System.out.println();
            }
        }


    }
}
