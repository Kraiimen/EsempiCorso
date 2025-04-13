package org.generation.italy.mud.codebreaker.zones;

import org.generation.italy.mud.codebreaker.entities.Bitborne;
import org.generation.italy.mud.codebreaker.entities.InteractiveEntity;
import org.generation.italy.mud.codebreaker.entities.Mob;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapAreas {
    Zone currentZone;
    Zone startingZone;
    Zone intro;
    Scanner scanner = new Scanner(System.in);

    public MapAreas() {
//        introBuildWorld();
        buildWorld();
        Bitborne bitborne = new Bitborne("BitBorne",4,3,4,4, true);
        System.out.println("\u001B[36mCome ti chiami?(Scegli un nome per il tuo personaggio!)\u001B[0m");
        bitborne.setCharacterName(scanner.nextLine());
        System.out.println("Il tuo personaggio si chiamerà " + bitborne.getCharacterName());
        System.out.println("\u001B[36mPuoi muoverti con i numeri o digitando la direzione cardinale in cui vuoi andare\n" +
                "Premi 1 per iniziare a muoverti!\u001B[0m");


        while (true) { //GAME LOOP
            setSpawnMechanics();
            if(currentZone.getEvent() && currentZone.getName().equalsIgnoreCase("Temple Square")){ //Metodo per quests, non ancora utilizzato
            }
            if(!currentZone.getAggressiveMobs().isEmpty()){ //CHECK FIGHT CON AGGRESSIVE MOB PRESENTI
                mobDialogue();
                Mob fight = currentZone.getAggressiveMobs().getFirst();
                System.out.println(currentZone.getAggressiveMob());
                fight.getAttacked(bitborne);
                bitborne.setAlive(bitborne.checkAlive());
                if(!fight.checkAlive()){
                    System.out.println("Hai ottenuto " + fight.getXp() + " punti esperienza!");
                    bitborne.checkLevelUp(fight);
                    System.out.println("Punti esperienza mancanti per il prossimo livello: " + bitborne.getXpMissingToLevelUp() );
                }
                if(!bitborne.checkAlive()){ //PENITENZE IN CASO DI MORTE
                    bitborne.losingXp();
                    System.out.println("Sei morto, sarai teletrasportato a " + startingZone.getName() + " E perderai X xp"); //ANCORA DA SETTARE
                    currentZone = startingZone;
                    bitborne.setCurrentHealth(bitborne.getMaxHp());
                    printZoneInfos();
                }
            }
            int passiveMobsArraySizeCycleStart = currentZone.getPassiveMobs().size(); //CHECK PRIMA DEI FIGHT PER AGGRESSIVITA GUARDIE
            if(!currentZone.getPassiveMobs().isEmpty()) { //MENU A 2 SCELTE SE CI SONO MOB IN ZONA
                System.out.println("Luogo: " + currentZone.getName());
                printPassiveMobsInZone();
                System.out.println(
                    "Scegli una delle seguenti opzioni: \n" +
                    "1)Muoviti in un altra zona");

                System.out.println("2)I log sussurrano di presenze ostili, visualizza i nemici nella zona.");
                String choiceMenu = "";
                boolean choiceMenuBoolean = false;
                do {
                    choiceMenu = scanner.nextLine();
                    switch (choiceMenu) {
                        case "1":
                            printZoneInfos(); //PRINT INFO ZONA
                            moveInDirections();
                            choiceMenuBoolean = true;
                            break;
                        case "2":
                            if(!currentZone.getPassiveMobs().isEmpty()) {
                                getPassiveMobAvailableMenu(bitborne);
                                choiceMenuBoolean = true;
                                break;
                            }
                        default: System.out.println("Digita una scelta disponibile");
                        break;
                    }

                } while (!choiceMenuBoolean);
            }
            if(currentZone.getPassiveMobs().size() < passiveMobsArraySizeCycleStart) { //Versione funzionante del codice sotto
                List<Mob> toBeMoved = new ArrayList<>();
                for (Mob mob : currentZone.getPassiveMobs()) {
                    if (mob.getCharacterName().equalsIgnoreCase("PointerGuard")) {
                        toBeMoved.add(mob);
                    }
                }
                for (Mob mob : toBeMoved) {
                    currentZone.getAggressiveMobs().add(mob);
                    currentZone.getPassiveMobs().remove(mob);
                }
            }
            //Iterazione del ciclo for che fa ciò che fa la stessa iterazione su ma non funziona per ConcurrentModificationException
//                if(currentZone.getPassiveMobs().size() < passiveMobsArraySizeCycleStart){ //PointerGuard diventano aggressivi se uccidi qualcuno(gattini)
//                    for(Mob mob: currentZone.getPassiveMobs()){
//                        if(mob.getCharacterName().equalsIgnoreCase("PointerGuard")){
//                            currentZone.getAggressiveMobs().add(mob);
//                            currentZone.getPassiveMobs().remove(mob);
//                        }
//                    }
//                }

                if(currentZone.getPassiveMobs().isEmpty()){ //MENU IN CASO DI ASSENZA MOB/EVENTI
                    printZoneInfos(); //PRINT INFO ZONA
                    moveInDirections();
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

    private void buildWorld() { //Set mobs, zone, ZoneLinks
        //Zone tutorial
        Zone unknownHallway1 = new Zone("Unknown Hallway", "Davanti a te si estende una strada lunga e luminosa, sospesa nel vuoto.");
        Zone unknownHallway2 = new Zone("Unknown Hallway", "I bordi in questo luogo sembrano composti da stringhe di codice che scorrono senza fine.");
        Zone unknownHallway3 = new Zone("Unknown Hallway", "Un piccolo segnaposto brilla sul terreno: \"Runtime Path - Inizio Esecuzione\".");
        Zone unknownHallway4 = new Zone("Unknown Hallway", "Mentre prosegui lungo il Runtime Path, noti un bagliore debole all'orizzonte. Una figura vaga si staglia nel codice pulsante.");
        Zone unknownHallway5 = new Zone("Unknown Hallway", "Avvicinandoti, la figura diventa più nitida. È umanoide... ma sembra instabile. Fatto di frammenti di stringhe e byte disordinati.");
        Zone helloWorldRoom = new Zone("Echo Chamber", "");
        helloWorldRoom.setAggressiveMob(new Mob("HelloWorld.class",8,4,2,1,2));
        Zone postHelloWorldRoom = new Zone("Interpreter Core","????");
        Zone teleport = new Zone("Interpreted and compiled", "????");


        //Zone CodeTopia
        Zone templesquare = new Zone("Temple Square", "PLACE HOLDER DESCRIPTION");
        templesquare.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,2),2,35);
        templesquare.setPassiveMob(new Mob("Cat.class",2,2,2,2,2));
        templesquare.setPassiveMob(new Mob("Cat.class",2,2,2,2,2));
        templesquare.setGuardsMechanics();

        Zone marketSquare = new Zone("Market Square", "PLACE HOLDER DESCRIPTION");
        marketSquare.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,2),2,35);
        marketSquare.setGuardsMechanics();

        Zone theTemple = new Zone("TheTemple", "PLACE HOLDER DESCRIPTION");
        theTemple.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,2),1,40);
        theTemple.setGuardsMechanics();

        Zone bakery = new Zone("Bakery", "PLACE HOLDER DESCRIPTION");
        Zone armory = new Zone("Armory", "PLACE HOLDER DESCRIPTION");

        Zone gardens1 = new Zone("gardens1", "PLACE HOLDER DESCRIPTION");
        gardens1.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,2),2,40);
        gardens1.setGuardsMechanics();

        Zone gardens2 = new Zone("gardens2", "PLACE HOLDER DESCRIPTION");
        gardens2.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,2),1,50);
        gardens2.setGuardsMechanics();

        Zone gardens3 = new Zone("gardens3", "PLACE HOLDER DESCRIPTION");
        gardens3.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,2),1,25);
        gardens3.setGuardsMechanics();

        Zone cityDoors = new Zone("City gates", "PLACE HOLDER DESCRIPTION");
        cityDoors.setGuardsMechanics();
        cityDoors.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,2),1,10);

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

    public void setSpawnMechanics(){
        if(currentZone.getName().equalsIgnoreCase("Temple Square")|| //Set degli spawn mob in città
                currentZone.getName().equalsIgnoreCase("The temple")||
                currentZone.getName().equalsIgnoreCase("Market Square")||
                currentZone.getName().equalsIgnoreCase("TheTemple")||
                currentZone.getName().equalsIgnoreCase("gardens1")||
                currentZone.getName().equalsIgnoreCase("gardens2")||
                currentZone.getName().equalsIgnoreCase("gardens3")||
                currentZone.getName().equalsIgnoreCase("City Gates")){
            currentZone.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,2),2,35);
            currentZone.setGuardsMechanics();
        }
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
        if(currentZone.getPassiveMobs().isEmpty()) {
            System.out.println("Scegli una destinazione:");
        } else {
            System.out.println("Scegli una destinazione o digita \"BACK\" per tornare indietro:");
        }
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

    public void printPassiveMobsInZone() {
        if (currentZone.getPassiveMobs() != null && !currentZone.getPassiveMobs().isEmpty()) {
            System.out.print("In zona si aggirano dei nemici: ");
            for (int i = 0; i < currentZone.getPassiveMobs().size(); i++) {
                System.out.print(currentZone.getPassiveMobs().get(i).getCharacterName());
                if (i < currentZone.getPassiveMobs().size() - 1) {
                    System.out.print(", ");
                }
                if (i == currentZone.getPassiveMobs().size() -1) {
                    System.out.print(".");
                    System.out.println();
                }
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
                            check = true;
                        }

                        if (!check) {
                            System.out.println("Hai sbattuto contro un muro! non sei mica un fantasma!");
                        }
                        break;
                    case "back":
                        check = true;
                        break;
                    default:
                        System.out.println("Digita una destinazione disponibile!");
                }
                System.out.println();
            } while (!check);
        }

        public void getPassiveMobAvailableMenu(InteractiveEntity attacker){
            if (currentZone.getPassiveMobs() != null && !currentZone.getPassiveMobs().isEmpty()) {
                System.out.println("Scegli un target da attaccare o scrivi \"BACK per tornare indietro\"");
                for (int i = 1; i <= currentZone.getPassiveMobs().size(); i++) {
                    System.out.println(i + ") " + currentZone.getPassiveMobs().get(i - 1).getCharacterName());
                }
                String fightMonster = "";
                boolean checkChoice = false;
                do {
                    fightMonster = scanner.nextLine();

                    switch (fightMonster.toLowerCase()) {
                        case "1":
                            if (!currentZone.getPassiveMobs().isEmpty()) {
                                currentZone.getPassiveMobs().getFirst().engageFight(attacker);
                                currentZone.getPassiveMobs().removeFirst();
                                checkChoice = true;
                            }
                            break;
                        case "2":
                            if (currentZone.getPassiveMobs().size() >= 2) {
                                currentZone.getPassiveMobs().get(1).engageFight(attacker);
                                currentZone.getPassiveMobs().remove(1);
                                checkChoice = true;

                            }
                            break;
                        case "3":
                            if (currentZone.getPassiveMobs().size() >= 3) {
                                currentZone.getPassiveMobs().get(2).engageFight(attacker);
                                currentZone.getPassiveMobs().remove(2);
                                checkChoice = true;

                            }
                            break;
                        case "4":
                            if (currentZone.getPassiveMobs().size() >= 4) {
                                currentZone.getPassiveMobs().get(3).engageFight(attacker);
                                currentZone.getPassiveMobs().remove(3);
                                checkChoice = true;
                            }
                        case "back":
                            checkChoice = true;
                            break;
                    }
                    if (!checkChoice) {
                        System.out.println("La tua scelta non è disponibile, scegli un nemico o premi F per tornare indietro");
                    }
                } while (!checkChoice);
            }

        }


        public void mobDialogue() {
            try {
                //HelloWorld Dialogue in ChamberEcho
                if (currentZone.getName().equalsIgnoreCase("Echo Chamber") && currentZone.getAggressiveMob().getCharacterName().equalsIgnoreCase("HelloWorld.class")) {
                    System.out.println("La figura si volta. Ha un volto fatto di caratteri ASCII. Sorride. Sul petto lampeggia un messaggio: \"Hello, World!\"");
                    System.out.println("\"Oh! Un nuovo processo? Che bello! È passato tanto tempo dall'ultimo...\"");
                    Thread.sleep(4000);
                    System.out.println("\"Mi chiamo HelloWorld. Sono stato il primo. Il primo programma, il primo saluto.\"");
                    Thread.sleep(4000);
                    System.out.println("\"Oltre questo corridoio, c'è qualcosa di strano. Un luogo dove mandano quelli come me.\"");
                    Thread.sleep(4000);
                    System.out.println("...");
                    Thread.sleep(4000);
                    System.out.println("\"Tanti dei miei fratelli sono scomparsi lì. Dicevano che era… la Compilazione Finale.\"");
                    Thread.sleep(4000);
                    System.out.println("...");
                    Thread.sleep(4000);
                    System.out.println();
                    System.out.println("\033[31m\"...Ma tu non sei come loro, vero?\"\033[0m");
                    Thread.sleep(4000);
                    System.out.println("\033[31m\"Tu non sei qui per imparare. Tu sei qui per S̶O̶P̶R̷A̴V̸V̷IV̷E̴R̴E̸.\"\033[0m");
                    Thread.sleep(4000);
                    System.out.println("\033[31m\"Benvenuto a C̶OD̷E̴T̶O̸P̶IA̴, piccolo snip...snipp...snippet. Spero tu sappia gestire gli err#%... ehm... gli errori.\"\033[0m");
                    Thread.sleep(4000);
                    System.out.println("\033[31m\"Perché io... sono il tuo primo b̴̗Ŭ̶͇̤G̶̛͈̍..\"\033[0m");
                    Thread.sleep(5000);
//                System.out.println("\033[31m\"Se non sai combattere un Hello World... non sei pronto per il main()!\"\033[0m");
//                Thread.sleep(5000);
                }

            } catch (InterruptedException e) {
                System.out.println("Qualcosa è andato storto durante il dialogo con" + currentZone.getAggressiveMob().getCharacterName());
            }
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
