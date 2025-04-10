package org.generation.italy.capstonProject.mudGame.entity;

import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.player.Player;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Direction;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class GameMenuUtils {

    public static Integer readIntInputOrExit(Scanner scanner, int min, int max, String exitCmd) {
        Integer choice = null;
        boolean valid = false;

        while (!valid) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(exitCmd)){
                return null;
            }

            try {
                int num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    choice = num;
                    valid = true;
                } else {
                    System.out.println("There is no item corresponding to your choice. Please choose another one");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose an object by its index or press '" + exitCmd + "' to exit.");
            }
        }

        return choice;
    }

    public static void handleInventoryMenu(Player player, Scanner scanner) {
        Map<Item, Integer> inventoryCopy;

        AtomicInteger index = new AtomicInteger(1);
        List<Item> inventoryItems = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n------INVENTORY MENU-------");
            index.set(1);
            inventoryItems.clear();
            inventoryCopy = player.getInventory().getAll();

            if (inventoryCopy.isEmpty()) {
                System.out.println("Your inventory is empty.");
                running = false;
                break;
            }

            inventoryCopy.forEach((item, quantity) -> {
                System.out.println(index.get() + ") " + item.getName() + " x" + quantity);
                inventoryItems.add(item);
                index.getAndIncrement();
            });

            System.out.println("Choose an item by its index or press 'x' to esc:");
            Integer answer = readIntInputOrExit(scanner, 1, inventoryItems.size(), "x");

            if (answer == null) {
                System.out.println("Closing inventory menu.");
                running = false;
                break;
            }
            Item selectedItem = inventoryItems.get(answer - 1);
            boolean selecting = true;

            while (selecting) {
                System.out.println("\nYou selected: " + selectedItem.getName());
                System.out.println("""
                        1. Use Item
                        2. Remove Item
                        3. Go back to Inventory
                        Choose an option or press 'x' to exit
                        """);

                Integer action = readIntInputOrExit(scanner, 1, 3, "x");

                if (action == null) {
                    System.out.println("Closing inventory menu.");
                    running = false;
                    break;
                }

                switch (action) {
                    case 1:
                        player.useItem(selectedItem);
                        selecting = false;
                        break;
                    case 2:
                        player.getInventory().removeItem(selectedItem);
                        selecting = false;
                        break;
                    case 3:
                        selecting = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            }
        }
    }

    public static void displayMovementOptions(Player player, Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\n------MOVEMENT MENU------");
            Map<Direction, Room> nextRooms = player.getCurrentRoom().getNextRooms();

            List<Direction> options = new ArrayList<>();
            AtomicInteger index = new AtomicInteger(1);

            nextRooms.forEach((direction, room) -> {
                if (room != null) {
                    System.out.println(index.get() + ") " + direction + " -> " + room.getName());
                    options.add(direction);
                    index.getAndIncrement();
                }
            });

            System.out.println("Choose a direction to move, or press 'x' to cancel:");
            Integer choice = readIntInputOrExit(scanner, 1, options.size(), "x");

            if (choice == null) {
                System.out.println("You stayed in the current room.");
                running = false;
            } else {
                Direction chosenDirection = options.get(choice - 1);
                player.move(chosenDirection);
                running = false;
            }
        }
    }

    public static void displayRoomActions(Player player, Scanner scanner){

    }

}
