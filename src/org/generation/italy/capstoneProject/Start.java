package org.generation.italy.capstoneProject;

import org.generation.italy.capstoneProject.models.worldMap.Map;
import org.generation.italy.capstoneProject.models.worldMap.Room;

import java.util.List;

public class Start {
    public static void main(String[] args) {

        Map map = new Map();
        Room current = map.templeSquare;

        // Comandi da tastiera: w=nord, s=sud, d=est, a=ovest, x=esci
        List<String> comandi = List.of(
                "s", // sud → Market Square
                "d", // est → Bakery
                "a", // ovest → Market Square
                "s", // sud → Gardens
                "s", // sud → City Gate
                "x"  // uscita
        );

        System.out.println("Welcome to M.U.D. !!!");
        int step = 0;

        while (step < comandi.size()) {
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

            String comando = comandi.get(step);
            System.out.println("> You press: " + comando);

            switch (comando) {
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
            step++;
        }

        System.out.println("Final room: " + current.getName());
    }
}
