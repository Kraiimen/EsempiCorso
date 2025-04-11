package capstoneproject.main;

import capstoneproject.Directions;
import capstoneproject.rooms.World;
import capstoneproject.entity.Player;
import capstoneproject.rooms.Room;

import java.util.Optional;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        World world = new World();
        world.chooseCharacter();
        world.create();

        Player player = world.getPlayer();// getPlayer ritorna il giocatore creato nella classe World
        Room currentRoom = player.getCurrentRoom();

        System.out.println("Benvenuto " + player.getName() +"!");
        printCurrentRoomDescription(currentRoom);

        while (true) {
            System.out.print("Dove vuoi andare? (n/s/e/w, q per uscire): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("q")) {
                System.out.println("Uscita dal gioco.");
                break;
            }

                Directions dir = switch (input) {
                    case "n" -> Directions.N;
                    case "s" -> Directions.S;
                    case "e" -> Directions.E;
                    case "w" -> Directions.W;
                    default -> null;
                };


            if (dir == null) {
                System.out.println("Comando non valido.");
                continue;
            }


            Optional<Room> nextRoom = currentRoom.getExitAt(dir);

            if (nextRoom.isPresent()) {
                currentRoom = nextRoom.get();
                player.setCurrentRoom(currentRoom);
                printCurrentRoomDescription(currentRoom);
            } else {
                System.out.println("Non puoi andare in quella direzione.");
            }
        }

        scanner.close();
    }

    private static void printCurrentRoomDescription(Room room) {
        System.out.println(">> Ti trovi in: " + room.getName());
        System.out.println(room.getDescription());
        System.out.println(room.getNpcList());
    }
}
