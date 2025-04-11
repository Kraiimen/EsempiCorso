package org.generation.italy.mud.codebreaker.zones;

import org.generation.italy.mud.codebreaker.entities.Bitborne;
import org.generation.italy.mud.codebreaker.entities.Mob;
import java.util.Map;
import java.util.Scanner;

public class MapAreas {
    Zone currentZone;
    Zone startingZone;
    Zone intro;
    Scanner scanner = new Scanner(System.in);

    public MapAreas() {
//        introBuildWorld();
        buildWorld();
        Bitborne bitborne = new Bitborne("BitBorne",4,3,4,4);


        while (true) {
        moveInDirections();
        if(currentZone.getEvent() && currentZone.getName().equalsIgnoreCase("Temple Square")){
        }
        if(!currentZone.getMobs().isEmpty()){
           Mob fight = currentZone.getMobs().getFirst();
           bitborne.engageFight(fight);
           System.out.println("prova");
        }


            //scegli direzione
            //print info
        }


        //set movements
        //Creazione mob
        //Creazione npc npcworld();
        //Creazione quest npcquest();

    }

//    public void introBuildWorld(){
//        Zone unknownHallway1 = new Zone("Unknown Hallway", "Davanti a te si estende una strada lunga e luminosa, sospesa nel vuoto.");
//        Zone unknownHallway2 = new Zone("Unknown Hallway", "I bordi in questo luogo sembrano composti da stringhe di codice che scorrono senza fine.");
//        Zone unknownHallway3 = new Zone("Unknown Hallway", "Un piccolo segnaposto brilla sul terreno: \"Runtime Path - Inizio Esecuzione\".");
//        Zone unknownHallway4 = new Zone("Unknown Hallway", "Mentre prosegui lungo il Runtime Path, noti un bagliore debole all'orizzonte. Una figura vaga si staglia nel codice pulsante.");
//        Zone unknownHallway5 = new Zone("Unknown Hallway", "Avvicinandoti, la figura diventa più nitida. È umanoide... ma sembra instabile. Fatto di frammenti di stringhe e byte disordinati.");
//        Zone helloWorldRoom = new Zone("Echo Chamber", "La figura si volta. Ha un volto fatto di caratteri ASCII. Sorride. Sul petto lampeggia un messaggio: \"Hello, World!\"");
//        helloWorldRoom.setMob(new Mob("HelloWorld.class",8,8,8,1));
//        Zone postHelloWorldRoom = new Zone("Interpreter Core","????");
//        Zone teleport = new Zone("Interpreted and compiled", "????");
//
//        unknownHallway1.setNearZones(Navigate.NORTH,unknownHallway2);
//        unknownHallway2.setNearZones(Navigate.NORTH,unknownHallway3);
//        unknownHallway3.setNearZones(Navigate.NORTH,unknownHallway4);
//        unknownHallway4.setNearZones(Navigate.NORTH,unknownHallway5);
//        unknownHallway5.setNearZones(Navigate.NORTH,helloWorldRoom);
//        helloWorldRoom.setNearZones(Navigate.NORTH,postHelloWorldRoom);
//        postHelloWorldRoom.setNearZones(Navigate.NORTH,teleport);
//        currentZone = unknownHallway1;
//    }

    private void buildWorld() {
        //Zone tutorial
        Zone unknownHallway1 = new Zone("Unknown Hallway", "Davanti a te si estende una strada lunga e luminosa, sospesa nel vuoto.");
        Zone unknownHallway2 = new Zone("Unknown Hallway", "I bordi in questo luogo sembrano composti da stringhe di codice che scorrono senza fine.");
        Zone unknownHallway3 = new Zone("Unknown Hallway", "Un piccolo segnaposto brilla sul terreno: \"Runtime Path - Inizio Esecuzione\".");
        Zone unknownHallway4 = new Zone("Unknown Hallway", "Mentre prosegui lungo il Runtime Path, noti un bagliore debole all'orizzonte. Una figura vaga si staglia nel codice pulsante.");
        Zone unknownHallway5 = new Zone("Unknown Hallway", "Avvicinandoti, la figura diventa più nitida. È umanoide... ma sembra instabile. Fatto di frammenti di stringhe e byte disordinati.");
        Zone helloWorldRoom = new Zone("Echo Chamber", "La figura si volta. Ha un volto fatto di caratteri ASCII. Sorride. Sul petto lampeggia un messaggio: \"Hello, World!\"");
        helloWorldRoom.setMob(new Mob("HelloWorld.class",8,5,3,1));
        Zone postHelloWorldRoom = new Zone("Interpreter Core","????");
        Zone teleport = new Zone("Interpreted and compiled", "????");


        //Zone CodeTopia
        Zone templesquare = new Zone("Temple Square", "PLACE HOLDER DESCRIPTION");
        Zone marketSquare = new Zone("Market Square", "PLACE HOLDER DESCRIPTION");
        Zone theTemple = new Zone("TheTemple", "PLACE HOLDER DESCRIPTION");
        Zone bakery = new Zone("Bakery", "PLACE HOLDER DESCRIPTION");
        Zone armory = new Zone("Armory", "PLACE HOLDER DESCRIPTION");
        Zone gardens1 = new Zone("gardens1", "PLACE HOLDER DESCRIPTION");
        Zone gardens2 = new Zone("gardens2", "PLACE HOLDER DESCRIPTION");
        Zone gardens3 = new Zone("gardens3", "PLACE HOLDER DESCRIPTION");
        Zone cityDoors = new Zone("City gates", "PLACE HOLDER DESCRIPTION");
        Zone southernRoad = new Zone("Southern Road", "PLACE HOLDER DESCRIPTION");
        Zone thewoods = new Zone("The Woods", "PLACE HOLDER DESCRIPTION");

        unknownHallway1.setNearZones(Navigate.NORTH,unknownHallway2);
        unknownHallway2.setNearZones(Navigate.NORTH,unknownHallway3);
        unknownHallway3.setNearZones(Navigate.NORTH,unknownHallway4);
        unknownHallway4.setNearZones(Navigate.NORTH,unknownHallway5);
        unknownHallway5.setNearZones(Navigate.NORTH,helloWorldRoom);
        helloWorldRoom.setNearZones(Navigate.NORTH,postHelloWorldRoom);
        postHelloWorldRoom.setNearZones(Navigate.NORTH,teleport);
        teleport.setNearZones(Navigate.NORTH, templesquare);

        currentZone = unknownHallway1;


        templesquare.setNearZones(Navigate.SOUTH, marketSquare);
        templesquare.setNearZones(Navigate.EAST, theTemple);

        theTemple.setNearZones(Navigate.WEST, templesquare);

        marketSquare.setNearZones(Navigate.NORTH, templesquare);
        marketSquare.setNearZones(Navigate.EAST, bakery);
        marketSquare.setNearZones(Navigate.WEST, armory);
        marketSquare.setNearZones(Navigate.SOUTH, gardens1);

        bakery.setNearZones(Navigate.SOUTH, marketSquare);

        armory.setNearZones(Navigate.EAST, marketSquare);

        gardens1.setNearZones(Navigate.SOUTH, gardens2);
        gardens1.setNearZones(Navigate.NORTH, marketSquare);

        gardens2.setNearZones(Navigate.NORTH, gardens1);
        gardens2.setNearZones(Navigate.SOUTH, gardens3);

        gardens3.setNearZones(Navigate.SOUTH, cityDoors);
        gardens3.setNearZones(Navigate.NORTH, gardens2);

        cityDoors.setNearZones(Navigate.SOUTH, southernRoad);
        cityDoors.setNearZones(Navigate.NORTH, gardens3);

        southernRoad.setNearZones(Navigate.SOUTH, thewoods);
        southernRoad.setNearZones(Navigate.NORTH, cityDoors);

        thewoods.setNearZones(Navigate.NORTH, southernRoad);

        startingZone = templesquare;
    }

    public Zone getStartingZone() {
        return startingZone;
    }

    public void printZoneInfos() {
        System.out.println("Luogo: " + currentZone.getName());
        System.out.println(currentZone.getDescription());
        if(currentZone.getNpcs() != null && !currentZone.getNpcs().isEmpty()){
            System.out.println(currentZone.getNpcs());
        }
        if(currentZone.getMob() != null){
            System.out.println(currentZone.getMob());
        }
        System.out.println("Scegli una destinazione:");
        showDirections();

    }

    public void showDirections() {
        int displayCounter = 0;
        for (Navigate direction : Navigate.values()) {
            displayCounter++;
            Zone tempZone = currentZone.getNearZone(direction);
            if (tempZone != null) {
                System.out.println(displayCounter + ")" + direction + ":" + tempZone.getName());
            }

        }
    }

        public void moveInDirections () {
//            for (Navigate direction : Navigate.values()) {
//                Zone tempZone = currentZone.getNearZone(direction);
//                int zoneCounter = 0;
//                if (tempZone != null) {
//                    zoneCounter++;
//                    System.out.println(zoneCounter + ") " + tempZone.getName());
//                }
//
//            }
            boolean check = false;
            String destination = "";
            do {
                destination = scanner.nextLine();
                check = false;
                switch (destination.toLowerCase()) {
                    case "1":
                    case "north":
                        if (currentZone.getNearZone(Navigate.NORTH) != null) {
                            currentZone = currentZone.getNearZone(Navigate.NORTH);
                            printZoneInfos();
                            check = true;
                        }

                        if (!check) {
                            System.out.println("Hai sbattuto contro un muro! non sei mica un fantasma!");
                        }

                        break;
                    case "2":
                    case "south":

                        if (currentZone.getNearZone(Navigate.SOUTH) != null) {

                            currentZone = currentZone.getNearZone(Navigate.SOUTH);
                            printZoneInfos();
                            check = true;
                        }

                        if (!check) {
                            System.out.println("Hai sbattuto contro un muro! non sei mica un fantasma!");
                        }

                        break;
                    case "east:":
                    case "3":

                        if (currentZone.getNearZone(Navigate.EAST) != null) {
                            currentZone = currentZone.getNearZone(Navigate.EAST);
                            printZoneInfos();
                            check = true;
                        }

                        if (!check) {
                            System.out.println("Hai sbattuto contro un muro! non sei mica un fantasma!");
                        }

                        break;
                    case "west":
                    case "4":
                        if (currentZone.getNearZone(Navigate.WEST) != null) {
                            currentZone = currentZone.getNearZone(Navigate.WEST);
                            printZoneInfos();
                            check = true;
                        }

                        if (!check) {
                            System.out.println("Hai sbattuto contro un muro! non sei mica un fantasma!");
                        }

                        break;
                    default:
                        System.out.println("Digita una destinazione disponibile!");
                }
            } while (!check);
        }

//    public void movementLogic() {
//        int choose = 0;
//        System.out.println(
//                "Azioni disponibili:/n" +
//                        "1) Muoviti in un altra zona/n" +
//                        "2) Parla con qualcuno"
//        );
//        switch (choose) {
//            case 1:
//        }
//    }



}
