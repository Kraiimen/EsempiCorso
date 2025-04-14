package org.generation.italy.capstonProject.mudGame.entity;

import org.generation.italy.capstonProject.mudGame.entity.player.*;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.List;
import java.util.Scanner;

import static org.generation.italy.capstonProject.mudGame.entity.WorldBuilder.createCharacter;

public class Game {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Room startingRoom = Room.getRoomByName("Temple Square");

        WorldBuilder.populateWorld();

        Player player = createCharacter(scanner, startingRoom);

        startingRoom.playerHasEntered(player);

    }


}
