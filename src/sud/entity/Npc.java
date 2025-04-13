package sud.entity;

import sud.dices;
import sud.items.Item;
import sud.rooms.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Npc extends Entity{
    private NpcState state;
    private boolean canInteract;
    private String Description;
    private ArrayList<String> lines = new ArrayList<>();
    public static Map<String, Npc> npcMap = new HashMap<>();
    static {
        Npc debugNPC = new Npc("deb",100000,0,Room.getRoomPointerFromName("debugroom"),0,NpcState.PASSIVE,false);
        npcMap.put("deb", debugNPC);
        Npc king = new Npc("The King", 100000000,0, Room.getRoomPointerFromName("castle"), 0, NpcState.PASSIVE, true);
        npcMap.put("KING", king);
        Npc kingsGuard = new Npc("King's Guard", 50,15, Room.getRoomPointerFromName("castle"), 0, NpcState.NEUTRAL, false);
        npcMap.put("KINGSGUARD", kingsGuard);
        Npc Guard = new Npc("The Guard", 50,15, Room.getRoomPointerFromName("templeSquare"), 0, NpcState.NEUTRAL, false);
        npcMap.put("GUARD", Guard);
        Npc cleric = new Npc("The Cleric", 50,15, Room.getRoomPointerFromName("temple"), 0, NpcState.PASSIVE, true);
        npcMap.put("CLERIC", cleric);
        Npc blackSmithAssistant = new Npc("The Assistant", 10000000,0, Room.getRoomPointerFromName("forge"), 0, NpcState.PASSIVE, true);
        npcMap.put("ASSISTANT", blackSmithAssistant);
        blackSmithAssistant.getInventory().add(Item.itemMap.get("dagger"));
        blackSmithAssistant.getInventory().add(Item.itemMap.get("sword"));
        blackSmithAssistant.getInventory().add(Item.itemMap.get("gratesword"));
        blackSmithAssistant.getInventory().add(Item.itemMap.get("grateaxe"));
        blackSmithAssistant.getInventory().add(Item.itemMap.get("leatherarmor"));
        blackSmithAssistant.getInventory().add(Item.itemMap.get("chainmail"));
        blackSmithAssistant.getInventory().add(Item.itemMap.get("fullplate"));
        Npc alchemist = new Npc("The Alchemist", 10000000,0, Room.getRoomPointerFromName("alchemist"), 0, NpcState.PASSIVE, true);
        npcMap.put("ALCHEMIST", alchemist);
        for (int i = 0; i < dices.rd6(); i++) {
            alchemist.getInventory().add(Item.itemMap.get("manap"));
        }
        for (int i = 0; i < dices.rd6(); i++) {
            alchemist.getInventory().add(Item.itemMap.get("healingp"));
        }
        for (int i = 0; i < dices.rd4(); i++) {
            alchemist.getInventory().add(Item.itemMap.get("tpp"));
        }
        Npc tavernKeeper = new Npc("The Tavern Keeper", 10000000,0, Room.getRoomPointerFromName("tavern"), 0, NpcState.PASSIVE, true);
        npcMap.put("TAVERNKEEPER", tavernKeeper);
        for (int i = 0; i < dices.rd6(); i++) {
            tavernKeeper.getInventory().add(Item.itemMap.get("chicken"));
        }
        Npc baker = new Npc("The Baker", 10000000,0, Room.getRoomPointerFromName("bakery"), 0, NpcState.PASSIVE, true);
        npcMap.put("BAKER", baker);
        for (int i = 0; i < dices.rd6(); i++) {
            baker.getInventory().add(Item.itemMap.get("cupcake"));
        }
        for (int i = 0; i < dices.rd8(); i++) {
            baker.getInventory().add(Item.itemMap.get("bread"));
        }

        king.setDescription("The King is a fat man with broad shoulders and a well-groomed beard. His eyes are tired and his face looks pale A crown rests on his head and a purple coat on his shoulders");
        king.lines.add("Please, go now");
        king.lines.add("Go i said");
        king.lines.add("Cof... Cof... ");
        king.lines.add("Why are you still here?!");

        kingsGuard.setDescription("The King's guard stand as still as statues as talla as a tree in his shining black armor and sharp silver sword at his sides and a grave on his back. His fixed, stern gazes command authority, provokes in you a feeling of respect and at the same time a slight sense of fear? Every movement is calculated to the smallest of details, every inch of his equipment cared for with discipline. You know that nothing escapes unnoticed under the King's guard watchful gaze.");
        kingsGuard.lines.add(kingsGuard.getWithColor("..."));
        kingsGuard.lines.add(kingsGuard.getWithColor("<He looks at you silently, you feel unconformable>"));

        Guard.setDescription("The guard stand as still as statues in his shining armor and sharp weapons at his sides. His fixed, stern gazes command respect, provokes in you a feeling of safety... or perhaps a slight sense of oppression? Every gesture is measured, every detail of his equipment cared for with discipline. You know that nothing escapes unnoticed under his watchful gaze.");
        Guard.lines.add(Guard.getWithColor("Be safe citizen") );
        Guard.lines.add(Guard.getWithColor("Hello!"));
        Guard.lines.add(Guard.getWithColor("Hi"));
        Guard.lines.add(Guard.getWithColor("You better not try anything funny"));
        Guard.lines.add(Guard.getWithColor("Do you need something citizen?"));



        cleric.setDescription("The temple cleric is a wise-looking man with a light, untidy beard, now almost entirely gray. Grayish hair falls softly over his shoulders. He wears a black robe, different from the other disciples, decorated on his chest by the sacred symbol of the gods. He is kneeling in front of the statue, praying under his breath.");
        cleric.lines.add("<in a soft voice>"+cleric.getWithColor("greetings"));
        cleric.lines.add("<in a soft voice>"+cleric.getWithColor("How can i assist you") );
        cleric.lines.add("<in a soft voice>"+cleric.getWithColor("Do you need any help?") );
        cleric.lines.add("<in a soft voice>"+cleric.getWithColor("Do you need any the blessing of the gods?") );

        tavernKeeper.setDescription("The tavern keeper is a strongly built orc, her black hairs are put up in a bun, she is dressed in a white shirt, long sleeves rolled up to the elbow, black leather pants covering her lower body She occasionally looks at the patrons in the room to check what they are up to");
        tavernKeeper.lines.add(tavernKeeper.getWithColor("Hello sweetie!") );
        tavernKeeper.lines.add(tavernKeeper.getWithColor("Today's meal is the Chicken leg sweetie!") );
        tavernKeeper.lines.add("<looking at the other patrons> " + tavernKeeper.getWithColor("HEY SHITHEAD DON'T YOU DARE DO THAT!"));
        tavernKeeper.lines.add("<She seem to be focused on cleaning a Mug>"+ tavernKeeper.getWithColor(" Do tell sweetie!") );

        blackSmithAssistant.setDescription("The BlackSmith assistant is a thin tall man, probably around 20 years old, he has a long ponytail dripping behind his head, his ears long and pointy are covered in little julery pieces");
        blackSmithAssistant.lines.add(blackSmithAssistant.getWithColor("Hello there sir, how can i help you?") );
        blackSmithAssistant.lines.add(blackSmithAssistant.getWithColor("Has anything caught your eye sir?") );
        blackSmithAssistant.lines.add(blackSmithAssistant.getWithColor("If you find anything interesting, just tell me sir?") );

        baker.setDescription("The Baker has a manly, confident aura. His beard, thick and carefully trimmed, frames a focused face. He wears a simple, tight-fitting white shirt and an pink apron stained with cream and flour. He is immersed in his work, his gaze fixed on the cupcake... until, out of the corner of his eye, he notices you. In an instant, the serious expression melts into something completely different.");
        baker.lines.add(baker.getWithColor("Let me make your day as sweet as sugar."));
        baker.lines.add(baker.getWithColor("Sugar, would you like to take a bite of one of my little sweets?"));
        baker.lines.add(baker.getWithColor("Aren't you just a little cupcake? What can I do for you?"));
        baker.lines.add(baker.getWithColor("Your wish is my command. Please tell me how I can satisfy your hunger."));
        baker.lines.add(baker.getWithColor("Welcome, welcome!"));

        alchemist.setDescription("The alchemist is a small, skinny man with spiky red hair shooting upward. He wears round glasses with lenses as thick as a finger, and his eyebrows are nearly nonexistent, burned away by numerous explosions. He’s dressed in a black work suit and thick gloves.");
        alchemist.lines.add("<His voice squeaks and cracks>"+alchemist.getWithColor("HElLo TheRe") );
        alchemist.lines.add("<His voice squeaks and cracks>"+alchemist.getWithColor("ARE YoU HerE To BUY or To AdMirE MY BeAuTyFulL FaCe"+"<He then moves his eyebrows up and down>"));
        alchemist.lines.add("<His voice squeaks and cracks>"+alchemist.getWithColor("hI TheRE RaTBraIN") );
        alchemist.lines.add("<His voice squeaks and cracks>"+alchemist.getWithColor("HHMMm Do yOU ThINk ThaT If A GOblIn WEre tO ExpLodE, WoLD HE Go Up OR WiDe") );


    }
    public Npc(String name, int maxHp, int attackDamage, Room currentroom, int xpOnDeath, NpcState stato, boolean canInteract) {
        super(name, maxHp, attackDamage, currentroom, xpOnDeath);
        this.state = stato;
        this.canInteract = canInteract;
        this.asignColor();
    }

    public void asignColor (){
        if(state == NpcState.PASSIVE){this.setEntityColor(colorG);}if(state == NpcState.NEUTRAL){this.setEntityColor(colorY);}}


    public void speak(String line){
        System.out.println(this.getWithColor(this.getName() + ": " + line));
    }

    public NpcState getState() {
        return state;
    }

    public void setState(NpcState state) {
        this.state = state;
    }

    public boolean isCanInteract() {
        return canInteract;
    }

    public void setCanInteract(boolean canInteract) {
        this.canInteract = canInteract;
    }

    public static Map<String, Npc> getNpcMap() {
        return npcMap;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRandomLine() {
        return this.lines.get(dices.roll(this.lines.size()-1));
    }

    public void setLines(ArrayList<String> lines) {
        lines = lines;
    }
}
