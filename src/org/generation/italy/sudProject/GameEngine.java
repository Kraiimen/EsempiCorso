package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.map.WorldMap;

import java.io.Console;

public class GameEngine {
    static{
        GameMenu menu = new GameMenu();
        WorldMap worldMap = new WorldMap();
        Player player = menu.createNewPlayer();



    }
}
