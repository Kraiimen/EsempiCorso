package org.generation.italy.capstoneProject;

import org.generation.italy.capstoneProject.models.npc.monsters.Monster;
import org.generation.italy.capstoneProject.models.utility.InTheWoods;
import org.generation.italy.capstoneProject.models.worldMap.Map;
import org.generation.italy.capstoneProject.models.worldMap.Room;

import java.util.List;
import java.util.Random;

public class Start {
    public static void main(String[] args) {

        Map map = new Map();
        Room current = map.templeSquare;

        // Comandi da tastiera: w=nord, s=sud, d=est, a=ovest, x=esci
        List<String> commands = List.of(
                "w", // north
                "d", // east
                "a", // west
                "s", // south
                "x"  // exit
        );

        System.out.println("Welcome to M.U.D. !!!");
        int step = 0;

        while (step < commands.size()) {
            System.out.println("\n You are in: " + current.getName());
            System.out.println("Available directions:");

            if (current.getNorth() != null) {
                System.out.println("w - North → " + current.getNorth().getName());
            }
            if (current.getSouth() != null) {
                System.out.println("s - South → " + current.getSouth().getName());
            }
            if (current.getEast()  != null) {
                    System.out.println("d - East → " + current.getEast().getName());
            }
            if (current.getWest()  != null) {
                    System.out.println("a - West → " + current.getWest().getName());
            }
                System.out.println("x - Exit");

            String command = commands.get(step);
            System.out.println("> You press: " + command);

            switch (command) {
                case "w":
                    if (current.getNorth() != null) {
                        current = current.getNorth();
                        System.out.println("You go north.");
                    } else {
                        System.out.println("You can't go north.");
                    }
                    break;
                case "s":
                    if (current.getSouth() != null) {
                        current = current.getSouth();
                        System.out.println("You go south.");
                    } else {
                        System.out.println("You can't go south.");
                    }
                    break;
                case "d":
                    if (current.getEast() != null) {
                        current = current.getEast();
                        System.out.println("You go east.");
                    } else {
                        System.out.println("You can't go east.");
                    }
                    break;
                case "a":
                    if (current.getWest() != null) {
                        current = current.getWest();
                        System.out.println("You go west.");
                    } else {
                        System.out.println("You can't go west.");
                    }
                    break;
                case "x":
                    System.out.println("Game ended. Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid input.");
            }

            System.out.println("Now in: " + current.getName());
            // Se sei nel bosco o antro, c'è una probabilità di incontrare un mostro
            if (current.getName().startsWith("Bosco") || current.getName().equals("Antro Oscuro")) {
                Random random = new Random();
                boolean generateMonster = random.nextBoolean(); // 50% chance

                if (generateMonster) {
                    Monster mostro = InTheWoods.generateRandomMonster();
                    System.out.println("A wild " + mostro.getNome() + " appears!");
                    mostro.takeAction();
                } else {
                    System.out.println("The area seems quiet... for now.");
                }
            }

            step++;
        }

        System.out.println("Final room: " + current.getName());
    }
}
