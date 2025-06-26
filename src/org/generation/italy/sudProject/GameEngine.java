package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Npc;
import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.entities.mobTypes.mobs.bosses.Necromancer;
import org.generation.italy.sudProject.entities.npcTypes.npcs.MoonPriest;
import org.generation.italy.sudProject.map.MapFrame;
import org.generation.italy.sudProject.map.WorldMap;

import java.io.Console;
import java.util.List;
import java.util.Random;

import static org.generation.italy.sudProject.Entity.isDead;
import static org.generation.italy.sudProject.Entity.showFightStats;
import static org.generation.italy.sudProject.RoomScanner.fightControls;
import static org.generation.italy.sudProject.entities.Player.mapFrame;
import static org.generation.italy.sudProject.entities.Player.printRoomNameAndDesc;
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
        MapFrame mapFrame = new MapFrame();
        Player.setMapFrame(mapFrame);
        mapFrame.updateMap(player.printRoomNameAndDesc() + player.getPlayerPosition().getMapOutput()); //primo spawn
        mapFrame.updateTime("Giorno: " + TimeHandler.day + "\nOrario: " + TimeHandler.time + "\nFase: " + TimeHandler.timePhase.getValue());
        mapFrame.updateEntities(player.getPlayerPosition().getEntitiesText());
        mapFrame.refreshPlayerStats(player);
        mapFrame.updateColorTheme();
        String stringControls;
        List<Controls> controls;
        String input;
        Random escapeDice = new Random();
        boolean spawnBoss = true;
        do{
            controls = RoomScanner.scan(player.getPlayerPosition());
            stringControls = RoomScanner.getSb().toString();
            boolean checkInput = false;
            do {
                String actionsString = "AZIONI DISPONIBILI: " +
                        stringControls +
                        "\n" +
                        "Seleziona l'azione da compiere: ";
                MapFrame.appendToLog(actionsString);

                input = console.readLine().toUpperCase().trim();
                for (Controls c : controls) {
                    if (input.equals(c.getValue())) {
                        checkInput = true;
                        break;
                    }
                }
                MapFrame.setLog("");
            }while(!checkInput);
            switch (input){
                case "MOVE":
                    player.playerMove();
                    break;
                case "ATTACK":
                    boolean endFight = false;
                    boolean hasFought = false;
                    do {
                        //selezionare chi attaccare
                        MapFrame.appendToLog("Seleziona il bersaglio:");
                        //mostra i bersagli
                        mapFrame.updateEntities(player.getPlayerPosition().getEntitiesText());
                        String targetSelected = console.readLine();
                        Entity target = (Entity) switch (targetSelected.trim().toUpperCase()) {
                            case "CAT" ->
                                    !player.getPlayerPosition().getRoomEntities().get(CAT_INDEX).isEmpty() && player.getPlayerPosition().getRoomEntities().get(GUARD_INDEX).isEmpty() ?
                                            player.getPlayerPosition().getRoomEntities().get(CAT_INDEX).getLast() : null;
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
                            MapFrame.appendToLog("\nNon puoi attaccare quest'entità");
                            if(!hasFought){
                                break;
                            }else{
                                MapFrame.setLog("");
                                continue;
                            }
                        }
                        boolean actionIsSelected = false;
                        do {
                            MapFrame.setLog("Seleziona l'azione da compiere: (ATTACK) (ESCAPE) ");
                            input = console.readLine().trim().toUpperCase();
                            for (Controls c : fightControls) {
                                if (input.equals(c.getValue())) {
                                    actionIsSelected = true;
                                    break;
                                }
                            }
                            MapFrame.setLog("");
                        }while(!actionIsSelected);
                        switch (input) {
                            case "ATTACK":
                                showFightStats(player, target);
                                player.attack(target);
                                hasFought = true;
                                MapFrame.appendToLog("il giocatore ha terminato l'attacco\n");
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
                                hasFought = true;
                                break;
                        }
                        if (!endFight) {
                            //attacco dei nemici presenti nella zona se si tratta del necromancer
                            if (target instanceof Necromancer) {
                                //attacco del necromancer
                                target.attack(player);
                                MapFrame.appendToLog("il nemico " + target.getName() + " ha terminato l'attacco\n");
                                //attacco di undead cats
                                for(int i = 0; i < player.getEntityPosition().getRoomEntities().get(UNDEAD_CAT_INDEX).size(); i++){
                                    target = (Entity) player.getEntityPosition().getRoomEntities().get(UNDEAD_CAT_INDEX).get(i);
                                    target.attack(player);
                                    MapFrame.appendToLog("il nemico " + target.getName() + " ha terminato l'attacco\n");
                                }
                                target = (Entity) player.getPlayerPosition().getRoomEntities().get(BOSS_INDEX).getLast();
                            } else {
                                showFightStats(player, target);
                                target.attack(player);
                                MapFrame.appendToLog("il nemico " + target.getName() + " ha terminato l'attacco\n");
                            }
                            //termina il combattimento (se uno dei due muore / se muoiono tutti i nemici)
                            if (isDead(player)) {
                                player.die();
                                TimeHandler.increaseTime(500);
                                mapFrame.updateMap(printRoomNameAndDesc() + player.getPlayerPosition().getMapOutput());
                                mapFrame.updateTime("Giorno: " + TimeHandler.day + "\nOrario: " + TimeHandler.time + "\nFase: " + TimeHandler.timePhase.getValue());
                                mapFrame.updateEntities(player.getPlayerPosition().getEntitiesText());
                                mapFrame.updateColorTheme();
                                endFight = true;
                            }
                        }
                    }while (!endFight);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    MapFrame.setLog("COMBATTIMENTO TERMINATO!\n");
                    MapFrame.clearFightStats();
                    if(hasFought){
                        TimeHandler.increaseTime(100);
                        mapFrame.updateTime("Giorno: " + TimeHandler.day + "\nOrario: " + TimeHandler.time + "\nFase: " + TimeHandler.timePhase.getValue());
                        mapFrame.updateColorTheme();
                    }
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
                    TimeHandler.increaseTime(500);
                    mapFrame.updateTime("Giorno: " + TimeHandler.day + "\nOrario: " + TimeHandler.time + "\nFase: " + TimeHandler.timePhase.getValue());
                    mapFrame.updateColorTheme();
                    break;
            }
            //gestione spawn boss
            if(TimeHandler.day >= 30 && TimeHandler.timePhase.getValue().equals("NIGHT") && spawnBoss){
                MapFrame.appendToLog("""
                        LA NOTTE SEMBRA NON FINIRE MAI...
                        Si sente una strana presenza provenire dai boschi
                        """);
                //boss spawn
                WorldMap.spawnNecromancer();
                spawnBoss = false;
            }
        }while(!exit && !endGame);
        if(exit){
            MapFrame.setLog("\nYOU QUITTED THE GAME");
            mapFrame.dispose();
        }else{
            MapFrame.setLog("\nHAI RIPORTATO LA LUCE A MOONVEIL!");
        }
    }
}
