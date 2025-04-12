package org.generation.italy.capstonProject.mudGame.entity;

import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.npc.Vendor;
import org.generation.italy.capstonProject.mudGame.entity.player.Player;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Direction;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GameMenuUtils {

    public static Integer readIntInputOrExit(Scanner scanner, int min, int max, String exitCmd) {
        Integer choice = null;
        boolean valid = false;

        while (!valid) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(exitCmd)){
                return null;
            }

            try {
                int num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    choice = num;
                    valid = true;
                } else {
                    System.out.println("There is no option corresponding to your choice. Please choose another one");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose an option by its index or press '" + exitCmd + "' to exit.");
            }
        }
        return choice;
    }

    public static Integer readIntInput(Scanner scanner, int min, int max) {
        Integer choice = null;
        boolean valid = false;

        while (!valid) {
            String input = scanner.nextLine().trim();

            try {
                int num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    choice = num;
                    valid = true;
                } else {
                    System.out.println("There is no option corresponding to your choice. Please choose another one");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose an option by its index.");
            }
        }
        return choice;
    }

    public static void printChoiceMenu(List<String> options){
        for(int i = 0; i < options.size(); i++){
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public static Integer showAndChooseMenu(List<String> options, Scanner scanner, String exitCmd) {
        printChoiceMenu(options);
        System.out.println("Choose an option or press '" + exitCmd + "' to cancel:");
        return readIntInputOrExit(scanner, 1, options.size(), exitCmd);
    }

    public static Integer showAndChooseMenu(List<String> options, Scanner scanner) {
        printChoiceMenu(options);
        System.out.println("Choose an option");
        return readIntInput(scanner, 1, options.size());
    }

    public static void displayInventoryMenu(Player player, Scanner scanner) {
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
                System.out.println(index.get() + ". " + item.getName() + " x" + quantity);
                inventoryItems.add(item);
                index.getAndIncrement();
                System.out.println();
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

                List<String> options = List.of("Inspect item", "Use Item", "Remove item from your inventory", "Go back to inventory to choose a different item");
                Integer action = showAndChooseMenu(options, scanner, "x");

                if (action == null) {
                    System.out.println("Closing inventory menu.");
                    running = false;
                    break;
                }

                switch (action) {
                    case 1:
                        selectedItem.inspect();
                        break;
                    case 2:
                        player.useItem(selectedItem);
                        selecting = false;
                        break;
                    case 3:
                        player.getInventory().removeItem(selectedItem);
                        System.out.println("One " + selectedItem.getName() + " was removed from your inventory.");
                        selecting = false;
                        break;
                    case 4:
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
                    System.out.println(index.get() + ". " + direction + " -> " + room.getName());
                    options.add(direction);
                    index.getAndIncrement();
                    System.out.println();
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
        boolean running = true;

        while(running){
            Room currentRoom = player.getCurrentRoom();

            System.out.println("\n------" + currentRoom.getName() + " ACTIONS------");

            System.out.println("\nChoose what you want to do:");

//            List<String> options = new ArrayList<>();
//            options.add("Show what's in this room again");
//            options.add("Open inventory");
//            options.add("Move to another room");
//
//            if (currentRoom.isHasItems()) {
//                options.add("Pick up item");
//            }
//            if (currentRoom.isHasEntities()) {
//                options.add("Interact with NPC");
//            }

            Map<String, Runnable> actions = new LinkedHashMap<>();

            actions.put("Show what's in this room again", currentRoom::printRoomContents);
            actions.put("Open inventory", player::openInventory);
            actions.put("Move to another room", player::handleMovement);
            actions.put("Rest", player::sleep);

            if (currentRoom.isHasItems()) {
                actions.put("Pick up item", () -> pickUpItemMenu(player, scanner));
            }
            if (currentRoom.isHasEntities()) {
                actions.put("Interact with NPC", () -> interactWithNpcMenu(player, scanner));
            }
            List<String> options = new ArrayList<>(actions.keySet());

            Integer choice = showAndChooseMenu(options, scanner, "x");

            if (choice == null) {
                System.out.println("Do you want to leave the game? (y to exit / n to return to room menu)");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("y")) {
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                } else if (input.equalsIgnoreCase("n")){
                    continue;
                } else {
                    System.out.println("Invalid input. Returning to room menu.");
                    continue;
                }
            } else {
                Runnable selectedAction = actions.get(options.get(choice - 1));
                if (selectedAction != null) {
                    selectedAction.run();
                } else {
                    System.out.println("Invalid option selected.");
                }
            }

//            switch(choice){
//                case 1:
//                    currentRoom.printRoomContents();
//                    break;
//                case 2:
//                    player.openInventory();
//                    break;
//                case 3:
//                    player.handleMovement();
//                    break;
//                case 4:
//                    if(currentRoom.isHasItems()){
//                        pickUpItemMenu(player, scanner);
//                    }
//                    break;
//                case 5:
//                    if(currentRoom.isHasEntities()){
//                        interactWithNpcMenu(player, scanner);
//                    }
//                    break;
//                default:
//                    System.out.println("Leaving the Room Action Menu");
//                    running = false;
//                    break;
//            }
        }
    }

    public static void  pickUpItemMenu(Player player, Scanner scanner) {
        boolean running = true;

        while (running) {
            Room currentRoom = player.getCurrentRoom();
            List<Item> roomItems = new ArrayList<>(currentRoom.getItems());
            AtomicInteger index = new AtomicInteger(1);

            index.set(1);
            System.out.println("\n------" + currentRoom.getName() + " ITEMS------");

            if (roomItems.isEmpty()) {
                System.out.println("This room does not have any item in it.");
                running = false;
                break;
            }

            roomItems.forEach((item) -> {
                System.out.println(index.get() + ". " + item.getName());
                index.getAndIncrement();
                System.out.println();
            });

            System.out.println("Choose an item by its index or press 'x' to esc:");
            Integer answer = readIntInputOrExit(scanner, 1, roomItems.size(), "x");

            if (answer == null) {
                System.out.println("Closing room items menu.");
                running = false;
                break;
            }
            Item selectedItem = roomItems.get(answer - 1);
            boolean selecting = true;

            while (selecting) {
                System.out.println("\nYou selected: " + selectedItem.getName());

                List<String> options = List.of("Inspect item", "Use Item", "Add item to your inventory", "Go back to room items menu to choose a different item");
                Integer action = showAndChooseMenu(options, scanner, "x");

                if (action == null) {
                    System.out.println("Closing item menu.");
                    running = false;
                    break;
                }

                switch (action) {
                    case 1:
                        selectedItem.inspect();
                        break;
                    case 2:
                        player.useItem(selectedItem);
                        selecting = false;
                        break;
                    case 3:
                        player.pickUpItem(selectedItem);
                        selecting = false;
                        break;
                    case 4:
                        selecting = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            }
        }
    }

    public static void interactWithNpcMenu (Player player, Scanner scanner){
        boolean running = true;

        while (running) {
            Room currentRoom = player.getCurrentRoom();
            List<Entity> roomEntities = new ArrayList<>(currentRoom.getEntities());
            AtomicInteger index = new AtomicInteger(1);

            index.set(1);
            System.out.println("\n------" + currentRoom.getName() + " NPCs------");

            if (roomEntities.isEmpty()) {
                System.out.println("This room does not have anyone in it.");
                running = false;
                break;
            }

            roomEntities.forEach((entity) -> {
                System.out.println(index.get() + ". " + entity.getCharName());
                index.getAndIncrement();
                System.out.println();
            });

            System.out.println("Choose an entity by its index or press 'x' to esc:");
            Integer answer = readIntInputOrExit(scanner, 1, roomEntities.size(), "x");

            if (answer == null) {
                System.out.println("Closing room entities menu.");
                running = false;
                break;
            }
            Entity selectedEntity = roomEntities.get(answer - 1);
            boolean selecting = true;

            while (selecting) {
                System.out.println("\nYou selected: " + selectedEntity.getCharName());

                List<String> options = List.of("Attack NPC", "Interact with NPC", "Go back to room entities menu to choose a different entity");

                Integer action = showAndChooseMenu(options, scanner, "x");

                if (action == null) {
                    System.out.println("Closing entity menu.");
                    running = false;
                    break;
                }

                switch (action) {
                    case 1:
                        player.manageAttack(selectedEntity);
                        selecting = false;
                        break;
                    case 2:
                        player.speakWith(selectedEntity, scanner);
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

    public static void displayShopMenu(Vendor vendor, Player player, Scanner scanner){
        Map<Item, Integer> shopInventoryCopy;
        Map<Item, Integer> prices = vendor.getPrices();

        AtomicInteger index = new AtomicInteger(1);
        List<Item> shopItems = new ArrayList<>();
        boolean running = true;
        while(running) {
            System.out.println("\n---------SHOP MENU---------");
            index.set(1);
            shopItems.clear();
            shopInventoryCopy = vendor.getInventory().getAll();

            if (shopInventoryCopy.isEmpty()) {
                System.out.println("Sorry, the shop is currently empty.");
                break;
            }

            shopInventoryCopy.forEach((item, quantity) -> {
                int price = prices.getOrDefault(item, -1);
                String priceInfo = price >= 0 ? price + " coins" : "Price not available";
                System.out.println(index.get() + ". " + item.getName() + " x" + quantity + " - " + priceInfo);
                shopItems.add(item);
                index.getAndIncrement();
                System.out.println();
            });

            System.out.println("Your wallet: " + player.getWallet().getBalance() + " coins");
            System.out.println("Select the number of the item to buy or press 'x' to exit:");

            Integer answer = readIntInputOrExit(scanner, 1, shopItems.size(), "x");

            if (answer == null) {
                System.out.println("Leaving the shop.");
                running = false;
                break;
            }

            Item selectedItem = shopItems.get(answer - 1);
            boolean selecting = true;

            while (selecting) {
                System.out.println("\nYou selected: " + selectedItem.getName());

                List<String> options = List.of(
                        "Inspect item",
                        "Buy item",
                        "Go back to the shop list"
                );
                Integer action = showAndChooseMenu(options, scanner, "x");

                if (action == null || action == 3) {
                    selecting = false;
                    break;
                }

                switch (action) {
                    case 1:
                        selectedItem.inspect();
                        break;
                    case 2:
                        if (!player.getInventory().isFull()) {
                            int itemPrice = prices.getOrDefault(selectedItem, -1);
                            if (itemPrice < 0) {
                                System.out.println("This item is not for sale.");
                            } else if (player.getWallet().getBalance() >= itemPrice) {
                                vendor.sell(player, selectedItem);
                                selecting = false;
                            } else {
                                System.out.println("You don't have enough coins to buy that item.");
                            }
                        } else {
                            System.out.println("Your inventory is full!");
                        }
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
}
