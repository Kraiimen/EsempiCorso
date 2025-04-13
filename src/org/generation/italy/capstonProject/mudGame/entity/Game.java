package org.generation.italy.capstonProject.mudGame.entity;

import org.generation.italy.capstonProject.mudGame.entity.player.*;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Room startingRoom = Room.getRoomByName("Temple Square");

        WorldBuilder.populateWorld();

        Player player = createCharacter(scanner, startingRoom);

        startingRoom.playerHasEntered(player);

    }

    public static Player createCharacter(Scanner scanner, Room startRoom){
        Player newPlayer;
        System.out.println("Welcome Player! Please enter your name: ");
        String player = scanner.nextLine();

        System.out.println("Please select a class for your character: ");
        List<String> options = List.of("Wizard", "Thief", "Paladin", "Priest");
        Integer roleChoice = GameMenuUtils.showAndChooseMenu(options, scanner);

        System.out.println("Enter your character's name: ");
        String name = scanner.nextLine();

        switch(roleChoice) {
            case 1:
                newPlayer = new Wizard(name, startRoom, player);
                break;
            case 2:
                newPlayer = new Thief(name, startRoom, player);
                break;
            case 3:
                newPlayer = new Paladin(name, startRoom, player, true);
                break;
            case 4:
                newPlayer = new Priest(name, startRoom, player);
                break;
            default:
                System.out.println("Invalid choice, please try again");
                return createCharacter(scanner, startRoom);
        }

        System.out.println("Character created! Welcome " + newPlayer.getCharName() + " the " + newPlayer.getRole() + "!");
        System.out.println();
        newPlayer.printStats();
        System.out.println();
        return newPlayer;
    }
}
