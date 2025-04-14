package sud.start;

import sud.actions.Action;
import sud.entity.Attackable;
import sud.entity.npc.InteractableNpc;
import sud.entity.npc.Npc;
import sud.entity.player.*;
import sud.inventory.Item;
import sud.inventory.UsableItem;
import sud.rooms.Direction;
import sud.rooms.RoomManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

//TODO
//Make more items, in ItemFactory for creation and RoomManager for distribution
//Make so that you have to pay to get items from sellers
//Make monsters, more types of enemies
//Interact with NPCs, especially sellers
//Make so that I can't fight cats specifically if there's a guard in the room
//Make levels
//Make so that you can't fight monsters if your level isn't high enough

public class Game {

    public static Scanner scanner = new Scanner(System.in);
    static RoomManager roomManager;
    static BattleManager battleManager;
    static Player player;
    static List<String> quitCommands = List.of("quit", "cancel", "back", "undo");

    public static void main(String[] args) {

        roomManager = new RoomManager();
        battleManager = new BattleManager();
        player = choosePlayer();
        roomManager.getCurrentRoom().onRoomEntered();
//        player.addMoney(50);
        gameLoop();
    }

    public static void gameLoop() {
        Action currentAction = Action.CHOOSE_ACTION;
        while (true) {
            currentAction = getActionInput();
            switch (currentAction) {
                case Action.MOVE:
                    roomManager.move(getDirectionInput());
                    continue;
                case Action.FIGHT:
                    List<Npc> attackableNpcs = roomManager.getCurrentRoom().getNpcContent()
                            .stream()
                            .filter(npc -> npc instanceof Attackable)
                            .filter(Npc::isAlive)
                            .toList();
                    if (attackableNpcs.isEmpty()) {
                        System.out.println("There's no one to attack in this room");
                        continue;
                    }
                    System.out.println("Available targets: ");
                    System.out.println(attackableNpcs);
                    while (true) {
                        System.out.println("Enter your target's name");

                        String targetInput = scanner.nextLine().toLowerCase();
                        Optional<Npc> currentTarget = attackableNpcs.stream()
                                .filter(npc -> npc.getName().toLowerCase().equals(targetInput))
                                .findFirst();
                        if (currentTarget.isEmpty()) {
                            System.out.println("No target with this name found");
                            continue;
                        }
                        battleManager.startBattle(player, currentTarget.get());
                        break;
                    }
                    continue;
                case Action.GRAB:
                    if (roomManager.getCurrentRoom().getItemContent().isEmpty()) {
                        System.out.println("There are no items in this room");
                        break;
                    }
                    System.out.println("Available items: ");
                    System.out.println(roomManager.getCurrentRoom().getItemContent());

                    while (true) {
                        System.out.println("Choose the item to grab");
                        String itemInput = scanner.nextLine().toLowerCase();
                        Optional<Item> itemToGrab = roomManager.getCurrentRoom().getItemContent()
                                .stream()
                                .filter(item -> item.getName().toLowerCase().equals(itemInput))
                                .findFirst();
                        if (itemToGrab.isEmpty()) {
                            System.out.println("The item input isn't valid. Try again");
                            continue;
                        }
                        System.out.println("You picked up " + itemToGrab.get().getName().toLowerCase());
                        player.getInventory().addItem(itemToGrab.get());
                        player.getInventory().print();
                        roomManager.getCurrentRoom().removeItemContent(itemToGrab.get());
                        break;
                    }
                    continue;
                case Action.USE:
                    List<Item> usableItems = player.getInventory().getHashMap().entrySet().stream()
                            .filter(entry -> entry.getKey() instanceof UsableItem)
                            .map(entry -> entry.getKey())
                            .toList();
                    if (usableItems.isEmpty()) {
                        System.out.println("You have no items you can use");
                        break;
                    }
                    System.out.println("Items you can use:\n" + usableItems);
                    while (true) {
                        System.out.println("Choose an item to use");

                        String itemInput = scanner.nextLine().toLowerCase();
                        Optional<Item> itemToUse = usableItems.stream()
                                .filter(item -> item.getName().toLowerCase().equals(itemInput))
                                .findFirst();
                        if (itemToUse.isEmpty()) {
                            System.out.println("There is no item with this name");
                            continue;
                        }
                        ((UsableItem) itemToUse.get()).use(player);
                        player.getInventory().removeItem(itemToUse.get());
                        break;
                    }
                    continue;
                case Action.BAG:
                    player.getInventory().print();
                    continue;
                case Action.TALK:
                    List<Npc> interactableNpcs = roomManager.getCurrentRoom().getNpcContent().stream()
                            .filter(npc -> npc instanceof InteractableNpc)
                            .toList();
                    if (interactableNpcs.isEmpty()) {
                        System.out.println("There's nobody here");
                        break;
                    }

                    while (true) {
                        System.out.println("Choose someone to talk to:");
                        System.out.println(interactableNpcs);
                        String interactInput = scanner.nextLine();
                        Optional<Npc> wantedNpc = interactableNpcs.stream()
                                .filter(npc -> npc.getName().toLowerCase().equals(interactInput.toLowerCase()))
                                .findFirst();
                        if (isQuitCommand(interactInput)) {
                            break;
                        }
                        if (wantedNpc.isEmpty()) {
                            System.out.println("There's nobody with this name");
                            continue;
                        }
                        ((InteractableNpc) wantedNpc.get()).interact(player);
                        break;
                    }
            }
        }
    }

    public static Direction getDirectionInput() {
        while (true) {
            System.out.print("Choose direction: ");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "north":
                case "n":
                    return Direction.NORTH;
                case "south":
                case "s":
                    return Direction.SOUTH;
                case "west":
                case "w":
                    return Direction.WEST;
                case "east":
                case "e":
                    return Direction.EAST;
                default:
                    System.out.println("This direction is incorrect. Try again");
            }
        }
    }

    public static Action getActionInput() {
        while (true) {
            System.out.print("Choose action (");
            System.out.print(Arrays.stream(Action.values())
                    .filter(action -> action != Action.CHOOSE_ACTION)
                    .map(action -> action.name().toLowerCase())
                    .collect(Collectors.joining(" / ")) + "):\n");

            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "move":
                case "m":
                    return Action.MOVE;
                case "fight":
                case "f":
                    return Action.FIGHT;
                case "grab":
                case "g":
                    return Action.GRAB;
                case "bag":
                case "b":
                    return Action.BAG;
                case "use":
                case "u":
                    return Action.USE;
                case "talk":
                case "t":
                    return Action.TALK;
                default:
                    System.out.println("Action invalid. Try again");
            }
        }
    }

    public static Player choosePlayer() {
        System.out.println("Choose your player's name");
        String name = scanner.nextLine();
        System.out.println("Choose a type of player: monk, paladin, wizard or thief ");
        String playerType = scanner.nextLine().toLowerCase();
        return createPlayer(playerType, name);
    }

    public static boolean isQuitCommand(String input) {
        return quitCommands.contains(input);
    }

    public static Player createPlayer(String playerType, String name) {
        switch (playerType) {
            case "wizard":
                return new Wizard(name, 100);
            case "monk":
                return new Monk(name, 87);
            case "paladin":
                return new Paladin(name, 93);
            case "thief":
                return new Thief(name, 81);
        }
        return null;
    }
}
