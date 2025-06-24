package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Npc;
import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.entities.mobTypes.mobs.bosses.Necromancer;
import org.generation.italy.sudProject.entities.npcTypes.npcs.MoonPriest;
import org.generation.italy.sudProject.map.WorldMap;

import java.io.Console;
import java.util.List;
import java.util.Random;

import static org.generation.italy.sudProject.Entity.isDead;
import static org.generation.italy.sudProject.Entity.showFightStats;
import static org.generation.italy.sudProject.RoomScanner.fightControls;
import static org.generation.italy.sudProject.map.Room.*;
import static org.generation.italy.sudProject.map.Room.BOSS_INDEX;

public class GameEngine {
    static{
        boolean endGame = false;
        boolean exit = false;
        Console console = System.console();
        PlayerCreator playerCreator = new PlayerCreator();
        WorldMap worldMap = new WorldMap();
        TimeHandler timeHandler = new TimeHandler();
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
                    boolean endFight = false;
                    do {
                        //selezionare chi attaccare
                        System.out.println("Seleziona il bersaglio:");
                        //mostra i bersagli
                        player.getPlayerPosition().showEntitiesInRoom();
                        String targetSelected = console.readLine();
                        Entity target = (Entity) switch (targetSelected.trim().toUpperCase()) {
                            case "CAT" ->
                                    !player.getPlayerPosition().getRoomEntities().get(CAT_INDEX).isEmpty() ? player.getPlayerPosition().
                                            getRoomEntities().get(CAT_INDEX).getLast() : null;
                            case "CULTIST" ->
                                        !player.getPlayerPosition().getRoomEntities().get(CULTIST_INDEX).isEmpty() ? player.getPlayerPosition().
                                                getRoomEntities().get(CULTIST_INDEX).getLast() : null;
                            case "GUARD" ->
                                        !player.getPlayerPosition().getRoomEntities().get(GUARD_INDEX).isEmpty() ? player.getPlayerPosition().
                                                getRoomEntities().get(GUARD_INDEX).getLast() : null;
                            case "UNDEADCAT" ->
                                        !player.getPlayerPosition().getRoomEntities().get(UNDEAD_CAT_INDEX).isEmpty() ? player.getPlayerPosition().
                                                getRoomEntities().get(UNDEAD_CAT_INDEX).getLast() : null;
                            case "NECROMANCER" ->
                                        !player.getPlayerPosition().getRoomEntities().get(BOSS_INDEX).isEmpty() ? player.getPlayerPosition().
                                                getRoomEntities().get(BOSS_INDEX).getLast() : null;
                            default -> null;
                        };
                        if (target == null) {
                            System.out.println("Non puoi attaccare quest'entità");
                            break;
                        }
                        boolean actionIsSelected = false;
                        do {
                            System.out.println("(ATTACK) (ESCAPE)");
                            System.out.println("Seleziona l'azione da compiere: ");
                            input = console.readLine().trim().toUpperCase();
                            for (Controls c : fightControls) {
                                if (input.equals(c.getValue())) {
                                    actionIsSelected = true;
                                    break;
                                }
                            }
                        }while(!actionIsSelected);
                        switch (input) {
                            case "ATTACK":
                                if (target.getIndexEntityPosition() == CAT_INDEX) {
                                    if (!player.getPlayerPosition().getRoomEntities().get(GUARD_INDEX).isEmpty()) {
                                        System.out.println("Non puoi attaccare, ci sono guardie nei dintorni!");
                                        endFight = true;
                                        break;
                                    }
                                }
                                showFightStats(player, target);
                                player.attack(target);
                                System.out.println("il giocatore ha terminato l'attacco");
                                if (isDead(target)) {
                                    if (target instanceof Necromancer) {
                                        endGame = true;
                                        endFight = true;
                                    }else{
                                        target.die();
                                        endFight = true;
                                    }
                                }
                                break;
                            case "ESCAPE":
                                endFight = escapeDice.nextInt(11) < 3;
                                break;
                        }
                        if (!endFight) {
                            //attacco dei nemici presenti nella zona se si tratta del necromancer
                            if (target instanceof Necromancer) {
                                //attacco del necromancer
                                target.attack(player);
                                System.out.println("il nemico" + target.getName() + " ha terminato l'attacco");
                                //attacco di undead cats
                                for(int i = 0; i < player.getEntityPosition().getRoomEntities().get(UNDEAD_CAT_INDEX).size(); i++){
                                    target = (Entity) player.getEntityPosition().getRoomEntities().get(UNDEAD_CAT_INDEX).get(i);
                                    target.attack(player);
                                    System.out.println("il nemico" + target.getName() + " ha terminato l'attacco");
                                }
                                target = (Entity) player.getPlayerPosition().getRoomEntities().get(BOSS_INDEX).getLast();
                            } else {
                                showFightStats(player, target);
                                target.attack(player);
                                System.out.println("il nemico " + target.getName() + " ha terminato l'attacco");
                            }
                            //termina il combattimento (se uno dei due muore / se muoiono tutti i nemici)
                            if (isDead(player)) {
                                player.die();
                                timeHandler.increaseTime(500);
                                endFight = true;
                            }
                        }
                    }while (!endFight);
                    System.out.println("COMBATTIMENTO TERMINATO!\n");
                    timeHandler.increaseTime(100);
                    break;
                case "LEVELUP":
                    MoonPriest moonPriest = (MoonPriest) player.getPlayerPosition().getRoomEntities().get(ROOM_MAIN_NPC_INDEX).getFirst();
                    moonPriest.levelUpPlayer(player);
                    break;
                case "PICKFROMCORPSE":
                    player.pickFromCorpse(player.getPlayerPosition());
                    break;
                case "INVENTORY":
                    player.openInventory();
                    break;
                case "PICKUP":
                    player.pickEnvironmentItems(player.getPlayerPosition());
                    break;
                case "BUY":
                    player.buy((Npc) player.getPlayerPosition().getRoomEntities().get(ROOM_MAIN_NPC_INDEX).getFirst());
                    break;
                case "UNEQUIP":
                    player.removeFromEquipment();
                    break;
                case "QUIT":
                    exit = true;
                    break;
                case "REST":
                    player.rest();
                    timeHandler.increaseTime(500);
                    break;
            }
            //visualizza tempo
            timeHandler.showTime();
            //gestione spawn boss
            if(TimeHandler.day >= 30 && TimeHandler.timePhase.getValue().equals("NIGHT")){
                System.out.println("LA NOTTE SEMBRA NON FINIRE MAI...");
                System.out.println("Si sente una strana presenza provenire dai boschi\n");
                //boss spawn
                WorldMap.spawnNecromancer();
            }
        }while(!exit && !endGame);
        if(exit){
            System.out.println("\nYOU QUITTED THE GAME");
        }else{
            System.out.println("\nHAI RIPORTATO LA LUCE A MOONVEIL!");
        }
    }
}
