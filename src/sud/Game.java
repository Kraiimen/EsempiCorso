package sud;

import sud.GameChoicesEnums.MainChoice;
import sud.actors.Actor;
import sud.actors.characters.Mage;
import sud.actors.characters.Paladin;
import sud.actors.characters.Warrior;
import sud.engine.GUI.GUI;
import sud.engine.mechanics.MovementHandler;
import sud.engine.mechanics.SpawnHandler;
import sud.environment.CardinalDirection;
import sud.environment.WorldMap;
import sud.environment.rooms.Room;
import sud.items.Item;

import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;

    private static boolean isPlayerTurn;

    private static Actor player;
    private static Room currentRoom;

    public static String getInput(){
        input = scanner.next().trim();
        if(input.equalsIgnoreCase(MainChoice.QUIT.getValue())){
            quit();
        }
        return input;
    }

    //START
    public static void start() {
        System.out.println("questa è un'avventura grafica, per compiere un'azione scrivi cosa vuoi fare\n");
        WorldMap.generateWorld();
        player = choosePlayer();
        //GUI.loading();
    }
    private static Actor choosePlayer() {
        while(true){
            System.out.println("Seleziona il personaggio:\nPaladino    Mago    Guerriero");
            switch (getInput().toLowerCase()){
                case "paladino" -> {
                    return new Paladin(getNome());
                }
                case "mago" -> {
                    return new Mage(getNome());
                }
                case "guerriero" -> {
                    return new Warrior(getNome());
                }
                default -> System.out.println("personaggio non disponibile");
            }
        }
    }
    private static String getNome(){
        System.out.println("qual'è il tuo nome?");
        return getInput();
    }



    public static void printGUI() {
        GUI.printRoom(player.getPosition());
    }
    public static void update() {
        currentRoom = player.getPosition();

        //CardinalDirection.valueOf("nord");
        //System.out.print("> ");
        //String input = scanner.nextLine();
        //player.move(input);

        playerTurn();
        enemyTurn();
        worldTurn();

    }

    private static void playerTurn() {
        isPlayerTurn = true;
        while(isPlayerTurn) {
            getInput();

            if(MainChoice.getMainMenu().contains(input.toLowerCase())){
                var choice = MainChoice.valueOf(input.toUpperCase());
                switch (choice) {
                    case MainChoice.INTERACT -> interact();
                    case MainChoice.ATTACK -> attack();
                    case MainChoice.PICK -> pick();
                    case MainChoice.INVENTORY -> inventory();
                }
            }
            if(CardinalDirection.getCompass().contains(input.toLowerCase())){
                var choice = CardinalDirection.valueOf(input.toUpperCase());
                MovementHandler.moveCharacter(player, choice);
            }
        }
    }

    private static void interact() {
        chooseResidentAndDoThings(Game.class.getEnclosingMethod().getName());
    }
    private static void attack() {
        chooseResidentAndDoThings(Game.class.getEnclosingMethod().getName());
    }

    private static void chooseResidentAndDoThings(String caller){   //TODO nome più orribile della storia, da cambiare
        if(!currentRoom.hasResidents()) {//se non ci sono personaggi con cui interagire
            GUI.noResidentFound();
            return;
        }
        while (true){//loop interazione
            System.out.println("scegli bersaglio:");   //"menu interazione:"/"menu attacco:"???
            //stampa lista dei personaggi nella stanza
            getInput();//input nome del personaggio con cui interagire
            if(input.equalsIgnoreCase(MainChoice.BACK.getValue())){
                return;//torno alla scelta dell'azione da fare (menù principale) (esco dal case "interagisci", ma è ancora il turno del giocatore)
            }
            //get del personaggio sulla lista,
            if(true){//se il personaggio c'è
                switch (caller){
                    case "attack" -> player.attack(null); //richiama metodo attacca sul player, passandogli il personaggio
                    case "interact" -> player.attack(null); //richiama metodo parla sul personaggio
                }
                isPlayerTurn = false;//esce dalla scelta dell'azione da fare (menù principale/turno del giocatore) (inizia turno avversario)
            }else{//se il personaggio non c'è:
                GUI.invalidChoice();
            }
        }
    }

    private static void pick() {
        if(!currentRoom.hasItems()) {//se non ci sono oggetti da raccogliere
            GUI.noItemsFound();
            return;
        }
        while (true){//loop raccolta
            System.out.println("cosa vuoi raccogliere (scrivi tutto per raccogliere tutto):");
            //stampa lista degli oggetti nella stanza
            getInput();//input oggetto da raccogliere
            if(input.equalsIgnoreCase(MainChoice.BACK.getValue())){
                return;//torno alla scelta dell'azione da fare (menù principale) (esco dal case "raccogli", ma è ancora il turno del giocatore)
            }if(input.equals("tutto")){
                for(Item i : currentRoom.getLoot()){
                    player.pickItem(i);
                }
                return;
            }
            //get dell'oggetto sulla lista
            if(true){//se l'oggetto c'è
                player.pickItem(null);//viene aggiunto all'inventario
                isPlayerTurn = false;//esce dalla scelta dell'azione da fare (menù principale/turno del giocatore) (inizia turno avversario)
            }else{//se l'oggetto non c'è:
                GUI.invalidChoice();
            }
        }
    }

    private static void inventory() {
        if(currentRoom.hasItems()) {//se non ci sono oggetti nell'inventario
            GUI.noItemsFound();
            return;
        }
        while (true){//loop inventario
            System.out.println("inventario (per uscire premi back):");
            //stampa lista degli oggetti nell'inventario
            getInput();//input oggetto da raccogliere
            if(input.equalsIgnoreCase(MainChoice.BACK.getValue())){
                return;//torno alla scelta dell'azione da fare (menù principale) (esco dal case "inventario", ma è ancora il turno del giocatore)
            }
            //get dell'oggetto sulla lista
            if(true){//se l'oggetto c'è
                //System.out.print("vuoi usarlo:");//mi derivo il titolo dal tipo di oggetto scelto (consumabile equipaggiabile)
                //System.out.print("vuoi dis/equipaggiarlo:"); //cambio stringa col ternario se è equipaggiato meno
                if(getConfirmation()){//yes
                    //player.useItem(null);//lo usa
                    //player.un/equip Item //changeState()? metodo che usa l'oggetto o lo dis/equipaggia?
                    //ternario se è equipaggiato e con quello chiamo uno o l'altro metodo?
                }
            }else{//se l'oggetto non c'è:
                GUI.invalidChoice();
            }
        }
    }

    private static void enemyTurn() {
        for(Actor a : currentRoom.getEnemies()){
            //se è stato attaccato
                //attacca chi lo ha attaccato   (ternario sul parametro in input)
            //altrimenti
                //attacca il player
        }
    }

    private static void worldTurn() {
        //un (vero)nemico normale può essere nella stessa stanza di una guardia? se si voglio che combattano in background?
        for(Room r : WorldMap.getWorldMap()){//Prendo TUTTI i movable invece della singola stanza? (ma solo i non mid fight.. i nemici possono fuggire?)
            MovementHandler.moveCharacters(r.getMovables());
            SpawnHandler.updatePopulation();
        }
    }

    private static boolean getConfirmation(){
        //stampa confirmation menu
        while (true){
            getInput();
            //operatore ternario su oggetto Boolean input.equals("yes"/"no/back") se nessuno dei 2(3), null;
            //se null continue
            return true;//boolean precedente (tanto non sarà mai null)
        }
    }

    private static void quit() {
        System.exit(0);
    }

}
