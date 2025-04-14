package org.generation.italy.mud.codebreaker.zones;

import org.generation.italy.mud.codebreaker.entities.Bitborne;
import org.generation.italy.mud.codebreaker.entities.InteractiveEntity;
import org.generation.italy.mud.codebreaker.entities.Mob;

import java.util.*;

public class MapAreas {
    Zone currentZone;
    Zone startingZone;
    Zone intro;
    Scanner scanner = new Scanner(System.in);

    public MapAreas() {
//        introBuildWorld();
        Random random = new Random();
        buildWorld();
        Bitborne bitborne = new Bitborne("BitBorne",4,3,4,4);
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
                if(!fight.checkAlive()){
                    System.out.println("Hai ottenuto " + fight.getXp() + " punti esperienza!");
                    bitborne.checkLevelUp(fight);
                    System.out.println("Punti esperienza mancanti per il prossimo livello: " + bitborne.getXpMissingToLevelUp() );
                }
                checkAndResetBitborneIfDead(bitborne);

            }

                if(random.nextInt(1,101) > 55) {
                    currentZone.getPassiveMobs().removeIf(mob -> mob.getCharacterName().equalsIgnoreCase("PointerGuard"));
                }
            int passiveMobsArraySizeCycleStart = currentZone.getPassiveMobs().size(); //CHECK PRIMA DEI FIGHT PER AGGRESSIVITA GUARDIE
            if (!currentZone.getPassiveMobs().isEmpty()) { //MENU MULTISCELTA SE CI SONO MOB IN ZONA
                try {
                    System.out.println(bitborne.printHpBar());
                    System.out.println("Luogo: " + currentZone.getName());
                    System.out.println(currentZone.getDescription());
                    printPassiveMobsInZone();
                    Thread.sleep(1000);
                    System.out.println(
                            "----------MENU DI SCELTA---------- \n" +
                                    "1)visualizza i nemici nella zona attuale\n" +
                                    "2)Muoviti in un altra zona");

                    System.out.println("3)Mostra statistiche del tuo personaggio.");
                    System.out.println("4)Riposa per recuperare il 20% degli hp massimi");
                    String choiceMenu = "";
                    boolean choiceMenuBoolean = false;

                    do {
                        choiceMenu = scanner.nextLine();
                        switch (choiceMenu) {
                            case "1":
                                if (!currentZone.getPassiveMobs().isEmpty()) {
                                    getPassiveMobAvailableMenu(bitborne);
                                    choiceMenuBoolean = true;
                                    break;
                                }
                                break;
                            case "2":
                                showDirections();
                                moveInDirections();
                                choiceMenuBoolean = true;
                                break;
                            case "3":
                                bitborne.showStats();
                                System.out.println("--------------------------------");
                                System.out.println("2)Muoviti in un altra zona.\n" +
                                        "3)Visualizza i nemici nella zona attuale." +
                                        "4)Riposa di nuovo");
                                break;
                            case "4":
                                bitborne.rest();
                                choiceMenuBoolean = true;
                                break;
                            default:
                                System.out.println("Digita una scelta disponibile");
                                break;
                        }

                    } while (!choiceMenuBoolean);
                } catch (InterruptedException e) {
                    System.out.println("Questo è il catch di un errore, ora son stanco è tardi");
                }
            }
            if(currentZone.getPassiveMobs().size() < passiveMobsArraySizeCycleStart) {//Versione funzionante del codice sotto
                List<Mob> fight = new ArrayList<>();
                for (Mob mob : currentZone.getPassiveMobs()) {
                    if (mob.getCharacterName().equalsIgnoreCase("PointerGuard")) {
                        System.out.println("\u001B[31mPointerGuard\u001B[0m ti ha visto commettere atti atroci su un povero file \u001B[33mCat.class\u001B[0m ed è diventato ostile");
                        fight.add(mob);
                    }
                }
                for (Mob mob : fight) {
                    mob.getAttacked(bitborne);
                    if (!bitborne.checkAlive()) {
                        System.out.println();
                        bitborne.losingXp();
                        System.out.println("Sei morto, sarai teletrasportato a " + startingZone.getName() + " E perderai X xp"); //ANCORA DA SETTARE
                        currentZone = startingZone;
                        bitborne.setCurrentHealth(bitborne.getMaxHp());
                        System.out.println();
                        System.out.println("----------------------------------");
                        printZoneInfos();
                        break;
                    }
                    if(!mob.checkAlive()) {
                        System.out.println("Hai ottenuto " + mob.getXp() + " punti esperienza!");
                        bitborne.checkLevelUp(mob);
                        System.out.println("Punti esperienza mancanti per il prossimo livello: " + bitborne.getXpMissingToLevelUp());
                    }
                }

            }

            currentZone.getAggressiveMobs().removeIf(mob -> mob.getCharacterName().equalsIgnoreCase("PointerGuard"));
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
                    System.out.println(bitborne.printHpBar());
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


    private void buildWorld() { //Set mobs, zone, ZoneLinks
        //Zone tutorial
        Zone unknownHallway1 = new Zone("Unknown Hallway", "\u001B[34mDavanti a te si estende una strada lunga e luminosa, sospesa nel vuoto.\u001B[0m");
        Zone unknownHallway2 = new Zone("Unknown Hallway", "\u001B[34mI bordi in questo luogo sembrano composti da stringhe di codice che scorrono senza fine.\u001B[0m");
        Zone unknownHallway3 = new Zone("Unknown Hallway", "\u001B[34mUn piccolo segnaposto brilla sul terreno: \"Runtime Path - Inizio Esecuzione\".\u001B[0m");
        Zone unknownHallway4 = new Zone("Unknown Hallway", "\u001B[34mMentre prosegui lungo il Runtime Path, noti un bagliore debole all'orizzonte. Una figura vaga si staglia nel codice pulsante.\u001B[0m");
        Zone unknownHallway5 = new Zone("Unknown Hallway", "\u001B[34mAvvicinandoti, la figura diventa più nitida. È umanoide... ma sembra instabile. Fatto di frammenti di stringhe e byte disordinati.\u001B[0m");
        Zone helloWorldRoom = new Zone("Echo Chamber", "");
        helloWorldRoom.setAggressiveMob(new Mob("HelloWorld.class",4,4,3,1,20,false));
        Zone postHelloWorldRoom = new Zone("Interpreter Core", "\u001B[34m????\u001B[0m");
        Zone teleport = new Zone("Interpreted and compiled", "\u001B[34m????\u001B[0m");

        Zone templesquare = new Zone("Temple Square", "\u001B[34mIl primo luogo che hai visto dopo essere uscito dal Runtime Path. Una piazza sacra, fluttuante tra linee di codice statiche e librerie importate da dimensioni sconosciute.\nuna leggenda narra che il tempio sussurri metodi dimenticati a chi sa ascoltare.\u001B[0m");

        Zone marketSquare = new Zone("Market Square", "\u001B[34mUn luogo in cui commercianti barattano variabili, frammenti di classi ed API, i suoni sembrano glitchare di tanto in tanto, come se il sistema non riuscisse a reggere tutte interazioni.\u001B[0m");

        Zone theTemple = new Zone("TheTemple", "\u001B[34mQuesto è il vero cuore spirituale del sistema. Si dice che qui viva il Main thread, un entità sospesa nel ciclo eterno dell'esecuzione.\u001B[0m");

        Zone bakery = new Zone("Bakery", "\u001B[34mUn luogo che profuma di pane.. e byte, si dice che il cibo prodotto qui curi le NullPointerException dell'anima.\u001B[0m");

        Zone armory = new Zone("Armory", "\u001B[34mQui ogni arma è compilata a mano, Troverai spade PUBLIC STATIC FINAL e ARMATURE che proteggono il tuo sistema da attacchi di tipo DDos\u001B[0m");

        Zone gardens1 = new Zone("gardens1", "\u001B[34mUn oasi di pace tra parentesi graffe e lunghe arraylist di fiori\u001B[0m");

        Zone gardens2 = new Zone("gardens2", "\u001B[34mQuesta parte del giardino sembra compilata con un framework instabile\u001B[0m");

        Zone gardens3 = new Zone("gardens3", "\u001B[34mUn luogo dimenticato dal garbage collector. Le piante sono cresciute senza più uno sviluppatore a mantenerle, e si nutrono dei frammenti di memoria lasciati da chi è crashato qui.\u001B[0m");

        Zone cityDoors = new Zone("City gates", "\u001B[34mLe porte della città di CODETOPIA, enormi muraglie firewall si stagliano davanti ai tuoi occhi, le entrate sono vigilate da un discreto numero di PointerGuards, al passaggio la tua classe viene controllata e se estendi ciò che può essere un problema.. ti negano l'accesso o peggio ancora di mandano in stackOverflow il cervello\u001B[0m");

        Zone southernRoad = new Zone("Southern Road", "\u001B[34mStrada logora con scarsa documentazione a riguardo\u001B[0m");

        Zone thewoods = new Zone("The Woods", "\u001B[34mI tronchi accatastati attorno a te son stati scritti in vecchie versioni di java ormai obsolete, le creature che vivono qui son mutazioni di classi ormai deprecate.\u001B[0m");


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
            currentZone.setPassiveMobSpawnChanceType(new Mob("Cat.class",2,2,2,2,45,false),2,25);
            currentZone.setGuardsMechanics();
        }
        if (currentZone.getName().equalsIgnoreCase("TheWoods")) {
            currentZone.setAggroMobSpawnChanceType(new Mob("DeprecatedClass",6,12,16,6,120,false),2,25);
        }
        if(currentZone.getName().equalsIgnoreCase("Southern Road")){
            currentZone.setPassiveMobSpawnChanceType(new Mob("BadSyntax",5,15,9,5,70,false),2,10);
            currentZone.setAggroMobSpawnChanceType(new Mob("CorruptedLibrary",2,36,3,1,55,false),2,15);
        }
    }

    public Zone getStartingZone() {
        return startingZone;
    }
    public void checkAndResetBitborneIfDead(Bitborne bitborne){
        if (!bitborne.checkAlive()) {
            System.out.println();
            bitborne.losingXp();
            System.out.println("Sei morto, sarai teletrasportato a " + startingZone.getName() + " E perderai X xp"); //ANCORA DA SETTARE
            currentZone = startingZone;
            bitborne.setCurrentHealth(bitborne.getMaxHp());
            System.out.println();
            System.out.println("----------------------------------");
            printZoneInfos();
        }

    }
    public void printZoneInfos() {
        System.out.println("Luogo: " + "\u001B[34m" + currentZone.getName() + "\u001B[0m");
        System.out.println(currentZone.getDescription());
        if(currentZone.getNpcs() != null && !currentZone.getNpcs().isEmpty()){
            System.out.println(currentZone.getNpcs());
        }
        if(currentZone.getPassiveMobs().isEmpty()) {
//            System.out.println("Scegli una destinazione:");
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
                System.out.println("\u001B[36m" + displayCounter + "\u001B[0m) \u001B[33m" + direction + "\u001B[0m: \u001B[34m" + tempZone.getName() + "\u001B[0m");


            }
        }
    }

    public void printPassiveMobsInZone() {
        if (currentZone.getPassiveMobs() != null && !currentZone.getPassiveMobs().isEmpty()) {
            System.out.print("In zona si aggirano dei nemici: ");
            for (int i = 0; i < currentZone.getPassiveMobs().size(); i++) {
                System.out.print("\u001B[93m" + currentZone.getPassiveMobs().get(i).getCharacterName() + "\u001B[0m");
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

        public void getPassiveMobAvailableMenu(Bitborne attacker){
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
                                checkChoice = true;
                                if(!currentZone.getPassiveMobs().getFirst().checkAlive()){ //SE IL MOB E' MORTO
                                    System.out.println("Hai ottenuto " + currentZone.getPassiveMobs().getFirst().getXp() + " punti esperienza!");
                                    attacker.checkLevelUp(currentZone.getPassiveMobs().getFirst());
                                    System.out.println("Punti esperienza mancanti per il prossimo livello: " + attacker.getXpMissingToLevelUp() );
                                    currentZone.getPassiveMobs().removeFirst();
                                }
                                if(!attacker.checkAlive()) { //PENITENZE IN CASO DI MORTE
                                    attacker.losingXp();
                                    System.out.println("Sei morto, sarai teletrasportato a " + startingZone.getName() + " E perderai una parte dei tuoi xp"); //ANCORA DA SETTARE
                                    currentZone = startingZone;
                                    attacker.setCurrentHealth(attacker.getMaxHp());
                                    printZoneInfos();
                                }
                            }
                            break;
                            case "2":
                            if (currentZone.getPassiveMobs().size() >= 2) {
                                currentZone.getPassiveMobs().get(1).engageFight(attacker);
                                checkChoice = true;
                                if(!currentZone.getPassiveMobs().get(1).checkAlive()){ //SE IL MOB E' MORTO
                                    System.out.println("Hai ottenuto " + currentZone.getPassiveMobs().get(1).getXp() + " punti esperienza!");
                                    attacker.checkLevelUp(currentZone.getPassiveMobs().get(1));
                                    System.out.println("Punti esperienza mancanti per il prossimo livello: " + attacker.getXpMissingToLevelUp() );
                                    currentZone.getPassiveMobs().remove(1);
                                }
                                if(!attacker.checkAlive()) { //PENITENZE IN CASO DI MORTE
                                    attacker.losingXp();
                                    System.out.println("Sei morto, sarai teletrasportato a " + startingZone.getName() + " E perderai una parte dei tuoi xp"); //ANCORA DA SETTARE
                                    currentZone = startingZone;
                                    attacker.setCurrentHealth(attacker.getMaxHp());
                                    printZoneInfos();
                                }
                            }
                            break;
                        case "3":
                            if (currentZone.getPassiveMobs().size() >= 3) {
                                currentZone.getPassiveMobs().get(2).engageFight(attacker);
                                checkChoice = true;
                                if(!currentZone.getPassiveMobs().get(2).checkAlive()){ //SE IL MOB E' MORTO
                                    System.out.println("Hai ottenuto " + currentZone.getPassiveMobs().get(2).getXp() + " punti esperienza!");
                                    attacker.checkLevelUp(currentZone.getPassiveMobs().get(2));
                                    System.out.println("Punti esperienza mancanti per il prossimo livello: " + attacker.getXpMissingToLevelUp() );
                                    currentZone.getPassiveMobs().remove(2);
                                }
                                if(!attacker.checkAlive()) { //PENITENZE IN CASO DI MORTE
                                    attacker.losingXp();
                                    System.out.println("Sei morto, sarai teletrasportato a " + startingZone.getName() + " E perderai una parte dei tuoi xp"); //ANCORA DA SETTARE
                                    currentZone = startingZone;
                                    attacker.setCurrentHealth(attacker.getMaxHp());
                                    printZoneInfos();
                                }

                            }
                            break;
                        case "4":
                            if (currentZone.getPassiveMobs().size() >= 4) {
                                currentZone.getPassiveMobs().get(3).engageFight(attacker);
                                checkChoice = true;
                                if(!currentZone.getPassiveMobs().get(3).checkAlive()){ //SE IL MOB E' MORTO
                                    System.out.println("Hai ottenuto " + currentZone.getPassiveMobs().get(3).getXp() + " punti esperienza!");
                                    attacker.checkLevelUp(currentZone.getPassiveMobs().get(3));
                                    System.out.println("Punti esperienza mancanti per il prossimo livello: " + attacker.getXpMissingToLevelUp() );
                                    currentZone.getPassiveMobs().remove(3);
                                }
                                if(!attacker.checkAlive()) { //PENITENZE IN CASO DI MORTE
                                    attacker.losingXp();
                                    System.out.println("Sei morto, sarai teletrasportato a " + startingZone.getName() + " E perderai una parte dei tuoi xp"); //ANCORA DA SETTARE
                                    currentZone = startingZone;
                                    attacker.setCurrentHealth(attacker.getMaxHp());
                                    printZoneInfos();
                                }
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
                if(currentZone.getPassiveMobs() != null &&currentZone.getName().equalsIgnoreCase("Temple Square") &&currentZone.getPassiveMob().getCharacterName().equalsIgnoreCase("Cat.class")){
                    System.out.print("Meow");
                }

                if (currentZone.getName().equalsIgnoreCase("Southern Road") && currentZone.getPassiveMobs() != null && !currentZone.getPassiveMobs().isEmpty() && currentZone.getPassiveMobs().get(0).getCharacterName().equalsIgnoreCase("BadSyntax")) {
                    System.out.println("\u001B[31mAssicurarsi che tutte le parentesi siano indentate scorrettamente e che le variabili siano dichiarate nel modo più confuso possibile.\u001B[0m");
                }

                if(!currentZone.getAggressiveMobs().isEmpty() && currentZone.getAggressiveMobs().getFirst().getCharacterName().equalsIgnoreCase("CorruptedLibrary") && !currentZone.getAggressiveMobs().isEmpty()){
                    System.out.println("\u001B[31mVerificare l'integrità dei file di sistema o reinstallare la libreria.\u001B[0m");
                }
                if(currentZone.getAggressiveMobs() != null && currentZone.getAggressiveMobs().getFirst().getCharacterName().equalsIgnoreCase("DeprecatedClass") && !currentZone.getAggressiveMobs().isEmpty()){
                    System.out.println("\u001B[35mQuesta classe era destinata a morire nel dimenticatoio, ma qualcosa ha fatto in modo che non fosse mai del tutto cancellata... e ora ti osserve.\u001B[0m");
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
