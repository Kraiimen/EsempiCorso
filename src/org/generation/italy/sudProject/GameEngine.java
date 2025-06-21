package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Npc;
import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.entities.mobTypes.mobs.Cultist;
import org.generation.italy.sudProject.entities.mobTypes.mobs.bosses.Necromancer;
import org.generation.italy.sudProject.entities.npcTypes.npcs.MoonPriest;
import org.generation.italy.sudProject.map.WorldMap;

import java.io.Console;
import java.util.List;
import java.util.Random;

import static org.generation.italy.sudProject.Entity.isDead;
import static org.generation.italy.sudProject.RoomScanner.fightControls;
import static org.generation.italy.sudProject.map.Room.*;
import static org.generation.italy.sudProject.map.Room.BOSS_INDEX;

public class GameEngine {
    static{
        boolean exit = false;
        Console console = System.console();
        PlayerCreator playerCreator = new PlayerCreator();
        WorldMap worldMap = new WorldMap();
        Player player = playerCreator.createNewPlayer();
        player.printRoomAndDesc(); //primo spawn
        String stringControls;
        List<Controls> controls;
        String input;
        Random escapeDice = new Random();
        do{
            controls = RoomScanner.scan(player.getPlayerPosition());
            stringControls = RoomScanner.getSb().toString();
            boolean checkInput = false;
            do {
                System.out.println("AZIONI DISPONIBILI: " + stringControls);
                System.out.println("Seleziona l'azione da compiere: ");
                input = console.readLine().toUpperCase().trim();
                for (Controls c : controls) {
                    if (input.equals(c.getValue())) {
                        checkInput = true;
                        break;
                    }
                }
            }while(!checkInput);
            switch (input){
                case "MOVE":
                    player.playerMove();
                    break;
                case "ATTACK":
                    boolean playerTurn = true; //se == true tocca al player, altrimenti ai nemici
                    //selezionare chi attaccare
                    System.out.println("Seleziona il bersaglio:");
                    //mostra i bersagli
                    player.getPlayerPosition().showEntitiesInRoom();
                    String targetSelected = console.readLine();
                    Entity target = (Entity) switch (targetSelected.trim().toUpperCase()){
                        case "CAT" ->!player.getPlayerPosition().getRoomEntities().get(CAT_INDEX).isEmpty()? player.getPlayerPosition().
                                getRoomEntities().get(CAT_INDEX).getLast(): null;
                        case "CULTIST" ->!player.getPlayerPosition().getRoomEntities().get(CULTIST_INDEX).isEmpty()? player.getPlayerPosition().
                                getRoomEntities().get(CULTIST_INDEX).getLast(): null;
                        case "GUARD" ->!player.getPlayerPosition().getRoomEntities().get(GUARD_INDEX).isEmpty()? player.getPlayerPosition().
                                getRoomEntities().get(GUARD_INDEX).getLast(): null;
                        case "UNDEADCAT" ->!player.getPlayerPosition().getRoomEntities().get(UNDEAD_CAT_INDEX).isEmpty()? player.getPlayerPosition().
                                getRoomEntities().get(UNDEAD_CAT_INDEX).getLast(): null;
                        case "NECROMANCER" ->!player.getPlayerPosition().getRoomEntities().get(BOSS_INDEX).isEmpty()? player.getPlayerPosition().
                                getRoomEntities().get(BOSS_INDEX).getLast(): null;
                        default -> null;
                    };
                    if(target == null){
                        System.out.println("Non puoi attaccare quest'entità");
                        break;
                    }
                    boolean endFight = false;
                    do{
                        if(playerTurn){
                            boolean actionIsSelected = false;
                            do {
                                System.out.println("(ATTACK) (ESCAPE)");
                                System.out.println("Seleziona l'azione da compiere: ");
                                input = console.readLine().trim().toUpperCase();
                                for(Controls c : fightControls){
                                    if (input.equals(c.getValue())) {
                                        actionIsSelected = true;
                                        break;
                                    }
                                }
                            }while(!actionIsSelected);
                            switch (input){
                                case "ATTACK":
                                    player.attack(target);
                                    System.out.println("il giocatore attacca!");
                                    playerTurn = false;
                                    break;
                                case "ESCAPE":
                                    endFight = escapeDice.nextInt(11) < 3;
                                    break;
                            }
                        }else{
                            //enemy turn
                            target.attack(player);
                            System.out.println("il nemico attacca!");
                            playerTurn = true;
                        }
                        //termina il combattimento (se uno dei due muore)
                        if(isDead(target)){
                            target.die();
                            endFight = true;
                        }
                        if(isDead(player)){
                            player.die();
                            endFight = true;
                        }
                    }while(!endFight);
                    break;
                case "LEVELUP":
                    MoonPriest moonPriest = (MoonPriest) player.getPlayerPosition().getRoomEntities().get(ROOM_MAIN_NPC_INDEX).getFirst();
                    moonPriest.levelUpPlayer(player);
                    break;
                case "PICKFROMCORPSE":
                    player.pickFromCorpse(player.getPlayerPosition());
                    break;
                case "PICKUP":
                    player.pickEnvironmentItems(player.getPlayerPosition());
                    break;
                case "BUY":
                    player.buy((Npc) player.getPlayerPosition().getRoomEntities().get(ROOM_MAIN_NPC_INDEX).getFirst());
                    break;
                case "EAT":
                    player.eat();
                    break;
                case "EQUIP":
                    player.equip();
                    break;
                case "UNEQUIP":
                    player.removeFromEquipment();
                    break;
                case "QUIT":
                    exit = true;
                    break;
                case "REST":
                    player.rest();
                    break;
            }
        }while(!exit);
        System.out.println("\nYOU QUITTED THE GAME");
    }
}
