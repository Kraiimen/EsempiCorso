package sud.rooms;

import sud.items.*;
import sud.entity.*;
import java.util.*;

public class Room {
    private String name;
    private Room nordPath, sudPath, westPath, eastPath;
    private boolean hasItems, hasNPC, hasGuards, hasCritters, hasMOBS;
    private ArrayList<Item> itemsInRoom;
    private ArrayList<Entity> MOBSInRoom, guardsInRoom, crittersInRoom;
    private Set<Entity> NPCInRoom;
    private static Map<String, Room> roomMap = new HashMap();
    private String description;

    static {
        Room debugroom = new Room("debroom");

        Room castle = new Room("castle");
        roomMap.put("castle", castle);
        Room prison = new Room("prison");
        roomMap.put("prison", prison);
        Room temple = new Room("temple");
        roomMap.put("temple", temple);
        Room templeSq = new Room("templeSquare");
        Room tavern = new Room("tavern");
        roomMap.put("tavern", tavern);
        Room market = new Room("market");
        roomMap.put("market", market);
        Room forge = new Room("forge");
        roomMap.put("forge", forge);
        Room bakery = new Room("bakery");
        roomMap.put("bakery", bakery);
        Room alchemist = new Room("alchemist");
        roomMap.put("alchemist", alchemist);
        Room fieldsN = new Room("fieldsN");
        roomMap.put("fieldsN", fieldsN);
        Room fieldsS = new Room("fieldsS");
        roomMap.put("fieldsS", fieldsS);
        Room forest = new Room("forest");
        roomMap.put("forest", forest);
        Room bossRoom = new Room("bossRoom");
        roomMap.put("bossRoom", bossRoom);

        castle.setPaths(debugroom, templeSq, prison, debugroom);
        castle.setRoomProperties(false, true, true, false, false);
        castle.getNPCInRoom().add(Npc.getNpcMap().get("King"));
        castle.getNPCInRoom().add(Npc.getNpcMap().get("Kings Guard"));

        prison.setPaths(debugroom, debugroom, debugroom, castle);
        prison.setRoomProperties(false, true, true, false, false);

        templeSq.setPaths(debugroom, market, debugroom, temple);
        templeSq.setRoomProperties(false, true, true, false, false);
        templeSq.getNPCInRoom().add(Npc.getNpcMap().get("TQ Guard"));

        tavern.setPaths(debugroom, debugroom, templeSq, debugroom);
        tavern.setRoomProperties(true, true, false, false, false);
        tavern.getNPCInRoom().add(Npc.getNpcMap().get("TavernK"));

        temple.setPaths(debugroom, debugroom, templeSq, debugroom);
        temple.setRoomProperties(false, true, true, false, false);
        temple.getNPCInRoom().add(Npc.getNpcMap().get("Cleric"));

        market.setPaths(templeSq, fieldsN, forge, bakery);
        market.setRoomProperties(true, true, true, false, false);
        market.getNPCInRoom().add(Npc.getNpcMap().get("MQ Guard"));

        bakery.setPaths(debugroom, debugroom, market, debugroom);
        bakery.setRoomProperties(true, true, true, false, false);
        bakery.getNPCInRoom().add(Npc.getNpcMap().get("Baker"));

        forge.setPaths(debugroom, alchemist, debugroom, market);
        forge.setRoomProperties(true, true, true, false, false);
        forge.getNPCInRoom().add(Npc.getNpcMap().get("Assistant"));

        alchemist.setPaths(forge, debugroom, debugroom, debugroom);
        alchemist.setRoomProperties(true, true, true, false, false);
        alchemist.getNPCInRoom().add(Npc.getNpcMap().get("Alchemist"));

        fieldsN.setPaths(market, fieldsS, debugroom, debugroom);
        fieldsN.setRoomProperties(true, false, false, true, false);
        fieldsN.getMOBSInRoom().add(Mob.getMobMap().get("Critter"));
        fieldsN.getMOBSInRoom().add(Mob.getMobMap().get("Critter"));
        fieldsN.getMOBSInRoom().add(Mob.getMobMap().get("Critter"));
        fieldsN.getMOBSInRoom().add(Mob.getMobMap().get("Critter"));
        fieldsN.getMOBSInRoom().add(Mob.getMobMap().get("Critter"));

        fieldsS.setPaths(fieldsN, forest, debugroom, debugroom);
        fieldsS.setRoomProperties(true, false, false, false, true);
        fieldsS.getMOBSInRoom().add(Mob.getMobMap().get("Goblin"));
        fieldsS.getMOBSInRoom().add(Mob.getMobMap().get("Goblin"));
        fieldsS.getMOBSInRoom().add(Mob.getMobMap().get("Goblin"));
        fieldsS.getMOBSInRoom().add(Mob.getMobMap().get("Goblin"));
        fieldsS.getMOBSInRoom().add(Mob.getMobMap().get("Goblin"));

        forest.setPaths(fieldsS, debugroom, debugroom, bossRoom);
        forest.setRoomProperties(true, false, false, false, true);
        forest.getMOBSInRoom().add(Mob.getMobMap().get("Bugbear"));
        forest.getMOBSInRoom().add(Mob.getMobMap().get("Bugbear"));
        forest.getMOBSInRoom().add(Mob.getMobMap().get("Bugbear"));
        forest.getMOBSInRoom().add(Mob.getMobMap().get("Ogre"));
        forest.getMOBSInRoom().add(Mob.getMobMap().get("Ogre"));

        bossRoom.setPaths(debugroom, debugroom, forest, debugroom);
        bossRoom.setRoomProperties(true, false, false, false, true);
        bossRoom.getMOBSInRoom().add(Mob.getMobMap().get("Boss"));

        castle.setDescription("Un enorme sala del trono si presenta davanti a te, muri in marmo bianco, un lungo tappeto rosso che dalla porta indica la via per il trono ," +
                "4 guardie svettano fiere alla tua destra quando entri, e altr 4 sono appena arrivate dal cambio turno sulla tua sinistra " +
                "le mura della stanza sono ricoperte di arazzi e quadri, riesci tranquillamente a vedere che l'arazzo più grande raffigura l'attuale re, " +
                "alla fine della stanza puoi vedere una scalinata di circa 6-7 gradini, che alla sua sommità ha un lussuoso trono fatto d'oro e intarsiato in madre perla, " +
                "sul trono svetta una figura umanoide, un uomo grasso, dalle spalle larghe e dalla barba ben curata, sulla sua testa svetta una corona, lui è il re");

        prison.setDescription("Scendendo le scale ti ritrovi in un ambiente umido e illuminato da sole torce, l'aria e viziata e la polvere è molta, alla fine delle scale vedi una porta in legno" +
                "una guardia è seduta ad un tavolo li vicino,quando passi segna il tuo nome sul registro, la porta della prigione è aperta, da su un corridoio, " +
                "riesci già a vedere una fila di celle con sbarre di metallo larghe quanto il manico di una scopa" +
                "le celle sono sporche, c'è puzza di urina e le facce al suo interno non sono amichevoli");

        templeSq.setDescription("La piazza del tempio è colma di persone, vedi bambini che giocano a campana, guardie che fanno la ronda, vecchie signore che danno da mangiare a dei piccioni" +
                "a nord il ponte levatoio che da sul entrata per il castello, dove 3 guardie fanno da sentinelle, riesci quasi a vedere la sala del trono in lontananza, " +
                "verso sud il gran mercato cittadino, con le sue bancarelle e empori, senti già il chiasso dei venditori che ti propongono \" il grande affare della tua vita\" provenire da quella direction " +
                "verso est invece sfoggia fiero il grande tempio degli dei, completamente fatto in marmo dei migliori al mondo, li potresti trovare l'aiuto dei sacerdoti, riconosciuti per le loro abilità curative e di potenziamento");

        tavern.setDescription("Entrando nella taverna vieni stordito da un odore di alcol pungente, ci sono varie persone al suo interno, la stanza principale è colma di brio e di risate" +
                " davanti al bancone ci sono un paio di tavoli rotondi, alcuni pieni alcuni vuoti, i muri della taverna sono ricoperti di graffi, trofei di caccia e poster" +
                "sul muro alla destra del entrata si può trovare una bacheca con affisse delle missioni scritte su dei fogli di carta" +
                "la taverniera si gira al rumore del campanello fissato al di spora della porta, ti guarda per un attimo prima di tornare a discutere con un cliente, " +
                "vedi un gruppetto di persone che si è raggruppata nel guardare quello che sembrerebbe uno scontro mortale tra 2 scarafaggi,");

        temple.setDescription("L'enorme arcata del portone del tempio da su una stanza di marmo, con file di panche fatte in legno di mogano al altro capo della stanza rispetto al entrata si vede una statua di una divinità" +
                "una serena melodia sfocia da una serie di tubi di avorio che sbucano in vari punti della stanza, e si può sentire un forte odore di incenso" +
                "i monaci e i chierici sono sparsi per le varie stanze, nella sala principale si vede solamente un uomo vestito in una tunica nera, che sta pregando in ginocchio");

        bakery.setDescription("Varcando la porta della pasticceria, il profumo di vaniglia e burro ti avvolge dandoti un dolce benvenuto. " +
                "Esposti su degli scaffali in legno chiaro ci sono vari dolci e focacce. " +
                "l'angolo alla destra del entrata è adibito come salotto, puoi vedere un divanetto e delle sedie attorno a un tavolino da caffè, l'idea di sederti un attimo e berti un bel tè è alquanto invitante. " +
                "Sul bancone di fronte a tè noti subito esposti dei pasticcini adorabili, decorati con crema e frutta di stagione. " +
                "Dietro al bancone, un uomo grande e virile, barba curata e braccia forti, maneggia con sorprendente delicatezza una sac à poche, disegnando orecchie da gatto su un cupcake alla vaniglia.");

        market.setDescription("Avvicinandoti al mercato, le voci e le urla dei mercanti si fanno sempre più forti,I negozi fanno da recinto alla piazza in cui si erige il mercato cittadino," +
                "le bancarelle sono come al solito affisse in una forma a doppio cerchio, con le bancarelle si cibo nel centro e le altre tutte intorno, i vari venditori provano a invitarti, con promesse di affaroni e modi eccessivamente intrusivi" +
                "a sud vedi gli enormi camellia delle mura che proteggono la città da i pericoli della foresta, a est e a ovest invece ci sono vari negozi come l' alchimista e la forgia");

        forge.setDescription("La forgia è divisa in 2 ambienti, una stanza chiusa, dove comprare o vendere, e una parte aperta sulla piazza dove forgiare armi," +
                "nella zona aperta della forgia puoi vedere una donna, vestita con una canottiera e un grembiule che sta attualmente modellando a colpi di martello una spada sulla sua incudine," +
                "come entri nel negozio noti che la parete alla tua destra e la parete in fondo alla stanza sono rio coperte da armi e scudi in mostra per la vendita, leggendo i prezzi capisci che la maggior parte di queste, non p minimamente alla tua portata" +
                "dietro il bancone in legno scuro che si trova sulla sinistra del entrata, un uomo magrolino dai capelli lunghi sta lucidando una spada, ");

        alchemist.setDescription("Entrando nel emporio del alchimista sei subito accecato da una forte luce, un uomo abbastanza giovane ha appena fatto espodere una sacchetta di qualche ingrediente alchemico ed adesso è ricoperto di polvere viola" +
                "dietro di lui il muro in fondo alla stanza è riempito fino al orlo di scaffali colmi di pergamene, ampolle, strumenti alchemici e cianfrusaglie varie," +
                "la stanza è un labirinto di tavoli e vetrine pieni di merci alchemiche e intrugli vari");

        fieldsN.setDescription("Appena oltrepassi i cancelli delle mura, lasciandoti alle spalle il trambusto del borgo, ti accoglie la quiete distesa delle campagne. " +
                "Piccole fattorie di legno e mattoni  chiari immerse nel verde punteggiano i campi coltivati. I contadini lavorano con calma, " +
                "guidando i buoi lungo i solchi della terra fertile. L’aria profuma di sole e terra smossa, e più a sud, un fiume tranquillo scorre tra le due sponde coltivate," +
                " unite da un ponte di pietra che sembra lì da sempre, in lontananza si vede la fitta foresta.");

        fieldsS.setDescription("Nel momento in cui attraversi il ponte di pietra, i campi cambiano volto. L'erba cresce più alta, i sentieri si fanno incerti, e il paesaggio inizia a perdere l'ordine delle mani umane." +
                " Il fiume si divide in piccoli ruscelli che scorrono lenti, come se volessero accompagnarti via dalla sicurezza delle mura. " +
                "Più a sud, il bosco si avvicina, fitto e silenzioso, noto per essere ostile: non è un posto per chi viaggia incautamente.");

        forest.setDescription("Ti addentri nella foresta, la luce e la sicurezza dei campi ormai svaniscono velocemente con ogni passo che fai. " +
                "senti sguardi ostili puntare su di te da dietro i rami degli alberi accompagnati da sibili e fruscii di creature sconosciute e da dentro i cespugli di felce. " +
                "Creature ostili, diverse da quelle già incontrate, più forti e più primitive si aggirano per questi boschi. " +
                "L'orientamento svanisce tra le fronde e tra i cespugli rovi che rendono i sentieri più difficili da navigare e identificare. " +
                "è tutto confuso, tranne una certezza: la via per tornare a casa riesci ancora a vedere i mulini e le fattorie in lontananza, ma addentrandoti di più questa ancora di salvezza potrebbe andare perduta.");

        bossRoom.setDescription(" arrivi in una radura, l'arie e secca e la foresta è silenziosa il rumore degli uccelli, e degli animali è completamente svanito il vento ulula forte passando tra le fronde degli alberi" +
                "qualcosa non va, è calmo, troppo calmo");
    }

    public Room(String name, Room nordPath, Room sudPath, Room westPath, Room eastPath,
                boolean hasItems, boolean hasNPC, boolean hasGuards, boolean hasCritters, boolean hasMOBS,
                ArrayList<Item> itemsInRoom, ArrayList<Entity> MOBSInRoom, ArrayList<Entity> guardsInRoom,
                ArrayList<Entity> crittersInRoom, Set<Entity> NPCInRoom, String description) {
        this.name = name;
        this.nordPath = nordPath;
        this.sudPath = sudPath;
        this.westPath = westPath;
        this.eastPath = eastPath;
        this.hasItems = hasItems;
        this.hasNPC = hasNPC;
        this.hasGuards = hasGuards;
        this.hasCritters = hasCritters;
        this.hasMOBS = hasMOBS;
        this.itemsInRoom = itemsInRoom;
        this.MOBSInRoom = MOBSInRoom;
        this.guardsInRoom = guardsInRoom;
        this.crittersInRoom = crittersInRoom;
        this.NPCInRoom = NPCInRoom;
        this.description = description;
    }

    public Room(String name) {
        this.name = name;
        this.itemsInRoom = new ArrayList<>();
        this.MOBSInRoom = new ArrayList<>();
        this.guardsInRoom = new ArrayList<>();
        this.crittersInRoom = new ArrayList<>();
        this.NPCInRoom = new HashSet<>();
        this.description = "";
    }

    public void setPaths(Room nord, Room sud, Room west, Room east) {
        this.nordPath = nord;
        this.sudPath = sud;
        this.westPath = west;
        this.eastPath = east;
    }

    public void setRoomProperties(boolean hasItems, boolean hasNPC, boolean hasGuards, boolean hasCritters, boolean hasMOBS) {
        this.hasItems = hasItems;
        this.hasNPC = hasNPC;
        this.hasGuards = hasGuards;
        this.hasCritters = hasCritters;
        this.hasMOBS = hasMOBS;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Room getNordPath() {
        return nordPath;
    }
    public void setNordPath(Room nordPath) {
        this.nordPath = nordPath;
    }

    public Room getSudPath() {
        return sudPath;
    }
    public void setSudPath(Room sudPath) {
        this.sudPath = sudPath;
    }

    public Room getWestPath() {
        return westPath;
    }
    public void setWestPath(Room westPath) {
        this.westPath = westPath;
    }

    public Room getEastPath() {
        return eastPath;
    }
    public void setEastPath(Room eastPath) {
        this.eastPath = eastPath;
    }

    public boolean isHasItems() {
        return hasItems;
    }
    public void setHasItems(boolean hasItems) {
        this.hasItems = hasItems;
    }

    public boolean isHasNPC() {
        return hasNPC;
    }
    public void setHasNPC(boolean hasNPC) {
        this.hasNPC = hasNPC;
    }

    public boolean isHasGuards() {
        return hasGuards;
    }
    public void setHasGuards(boolean hasGuards) {
        this.hasGuards = hasGuards;
    }

    public boolean isHasCritters() {
        return hasCritters;
    }
    public void setHasCritters(boolean hasCritters) {
        this.hasCritters = hasCritters;
    }

    public boolean isHasMOBS() {
        return hasMOBS;
    }
    public void setHasMOBS(boolean hasMOBS) {
        this.hasMOBS = hasMOBS;
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }
    public void setItemsInRoom(ArrayList<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

    public ArrayList<Entity> getMOBSInRoom() {
        return MOBSInRoom;
    }
    public void setMOBSInRoom(ArrayList<Entity> MOBSInRoom) {
        this.MOBSInRoom = MOBSInRoom;
    }

    public ArrayList<Entity> getGuardsInRoom() {
        return guardsInRoom;
    }
    public void setGuardsInRoom(ArrayList<Entity> guardsInRoom) {
        this.guardsInRoom = guardsInRoom;
    }

    public ArrayList<Entity> getCrittersInRoom() {
        return crittersInRoom;
    }
    public void setCrittersInRoom(ArrayList<Entity> crittersInRoom) {
        this.crittersInRoom = crittersInRoom;
    }

    public Set<Entity> getNPCInRoom() {
        return NPCInRoom;
    }
    public void setNPCInRoom(Set<Entity> NPCInRoom) {
        this.NPCInRoom = NPCInRoom;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    static public Room getRoomPointerFromName(String name) {
        return roomMap.get(name);
    }
}
