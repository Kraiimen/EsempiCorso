package capstoneproject.main;

import capstoneproject.Directions;
import capstoneproject.entity.Npc;
import capstoneproject.rooms.World;
import capstoneproject.entity.Player;
import capstoneproject.rooms.Room;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Play{
    private static Room currentRoom;
    private static Player player;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        World world = new World();
        world.chooseCharacter();
        world.create();

        player = world.getPlayer();// getPlayer ritorna il giocatore creato nella classe World
        currentRoom = player.getCurrentRoom();

        System.out.println("Benvenuto " + player.getName() +"!");
        printCurrentRoomDescription(currentRoom);

        fightLoop();
//        printDirectionsForUser();
    }

    private static void printCurrentRoomDescription(Room room) {
        System.out.println(">> Ti trovi in: " + room.getName());
        System.out.println(room.getDescription());
        room.printNpcInCurrentRoom();
    }

    private static void printDirectionsForUser(){
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

    private static void fightLoop(){
        System.out.print("Vuoi combattere? (Numero del target o 0 per uscire): ");
        int choice = scanner.nextInt();
        if(choice < 0 || choice > currentRoom.getNpcList().size() ){
            System.out.println("Inserisci un valore valido");
        } else if(choice == 0){
            return;
        } else {
            List<Npc> npcList = currentRoom.getNpcList();
            Npc target = npcList.get(choice-1);
            player.attack(target);
        }

    }
}
