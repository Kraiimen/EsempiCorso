package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Npc;
import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.entities.npcTypes.npcs.MoonPriest;
import org.generation.italy.sudProject.map.WorldMap;

import java.io.Console;
import java.util.List;

import static org.generation.italy.sudProject.RoomScanner.fightControls;
import static org.generation.italy.sudProject.map.Room.ROOM_MAIN_NPC_INDEX;

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
        do{
            controls = RoomScanner.scan(player.getPlayerPosition());
            stringControls = RoomScanner.getSb().toString();
            boolean checkInput = false;
            do {
                System.out.println("AZIONI DISPONIBILI: " + stringControls);
                System.out.println("Seleziona l'azione da compiere: ");
                input = console.readLine();
                for (Controls c : controls) {
                    if (input.trim().toUpperCase().equals(c.getValue())) {
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


                    boolean endFight = false;
                    do{
                        if(playerTurn){
                            boolean actionIsSelected = false;
                            do {
                                System.out.println("(ATTACK) (ESCAPE)");
                                System.out.println("Seleziona l'azione da compiere: ");
                                input = console.readLine();
                                for(Controls c : fightControls){
                                    if (input.trim().toUpperCase().equals(c.getValue())) {
                                        actionIsSelected = true;
                                        break;
                                    }
                                }
                            }while(!actionIsSelected);
                            switch (input){
                                case "ATTACK":
                                    break;
                                case "ESCAPE":
                                    break;
                            }
                        }else{
                            //enemy turn
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
    }
}
