package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.map.WorldMap;

public class GameEngine {
    static{
        boolean exit = false;
        PlayerCreator playerCreator = new PlayerCreator();
        WorldMap worldMap = new WorldMap();
        Player player = playerCreator.createNewPlayer();
        player.printRoomAndDesc(); //primo spawn
        String controls;
        do{
            RoomScanner.scan(player.getPlayerPosition());
            controls = RoomScanner.getSb().toString();
            System.out.println("AZIONI DISPONIBILI: "+ controls);
            //gestire le azioni





        }while(!exit);
    }
}
