package sud.rooms;

import sud.dices;
import sud.items.*;
import sud.entity.*;
import java.util.*;


import static sud.items.Item.itemMap;

public class Room {
    private String name;
    private Room nordPath, sudPath, westPath, eastPath;
    private boolean hasItems, hasNPC, hasGuards, hasCritters, hasMOBS;
    private Map<String,Item> itemsInRoom;
    private Map<String,Entity>NPCInRoom;
    private Map<String,Mob> MOBSInRoom;
    private static Map<String, Room> roomMap = new HashMap();
    private String description;

    static {
        Room debugroom = new Room("debroom");
        roomMap.put("DEBROOM", debugroom);
        Room castle = new Room("castle");
        roomMap.put("CASTLE", castle);
        Room prison = new Room("prison");
        roomMap.put("PRISON", prison);
        Room temple = new Room("temple");
        roomMap.put("TEMPLE", temple);
        Room templeSq = new Room("templeSquare");
        roomMap.put("TEMPLESQ", templeSq);
        Room tavern = new Room("tavern");
        roomMap.put("TAVERN", tavern);
        Room market = new Room("market");
        roomMap.put("MARKET", market);
        Room forge = new Room("forge");
        roomMap.put("FORGE", forge);
        Room bakery = new Room("bakery");
        roomMap.put("BAKERY", bakery);
        Room alchemist = new Room("alchemist");
        roomMap.put("ALCHEMIST", alchemist);
        Room fieldsN = new Room("fieldsN");
        roomMap.put("FIELDSN", fieldsN);
        Room fieldsS = new Room("fieldsS");
        roomMap.put("FIELDSS", fieldsS);
        Room forest = new Room("forest");
        roomMap.put("FOREST", forest);
        Room bossRoom = new Room("bossRoom");
        roomMap.put("BOSSROOM", bossRoom);

        //castle
        {
            castle.setPaths(debugroom, templeSq, prison, debugroom);
            castle.setRoomProperties(false, true, true, false, false);
            castle.getNPCInRoom().put(Npc.getNpcMap().get("KING").getName().toUpperCase(), Npc.getNpcMap().get("KING"));
            castle.getNPCInRoom().put(Npc.getNpcMap().get("KINGSGUARD").getName().toUpperCase(), Npc.getNpcMap().get("KINGSGUARD"));
            if(dices.rd100()>75){
                castle.getItemsInRoom().put(Item.itemMap.get("coins").getName().toUpperCase(),Item.itemMap.get("coins"));
                castle.hasItems = true;
                if(dices.rd100()>75){
                    castle.getItemsInRoom().put(Item.itemMap.get("coins").getName().toUpperCase(),Item.itemMap.get("coins"));
                }
            }
            if(dices.rd100()>90){
                castle.getItemsInRoom().put(Item.itemMap.get("wine").getName().toUpperCase(),Item.itemMap.get("wine"));
                castle.hasItems = true;
            }
        }
        //prison
        {
            prison.setPaths(debugroom, debugroom, debugroom, castle);
            prison.setRoomProperties(false, true, false, false, false);
        }
        //temple square
        {
            templeSq.setPaths(castle, market, tavern, temple);
            templeSq.setRoomProperties(false, false, false, false, false);
            if (dices.rd100() > 25) {
                templeSq.getItemsInRoom().put(Item.itemMap.get("bread").getName().toUpperCase(), Item.itemMap.get("bread"));
                templeSq.hasItems = true;
                if (dices.rd100() > 50) {
                    templeSq.getItemsInRoom().put(Item.itemMap.get("bread").getName().toUpperCase(), Item.itemMap.get("bread"));
                }
            }
            if (dices.rd100() > 25) {
                templeSq.getItemsInRoom().put(Item.itemMap.get("apple").getName().toUpperCase(), Item.itemMap.get("apple"));
                templeSq.hasItems = true;
            }
            if (dices.rd100() > 75) {
                templeSq.getItemsInRoom().put(Item.itemMap.get("coins").getName().toUpperCase(), Item.itemMap.get("coins"));
                templeSq.hasItems = true;
            }
        }
        //tavern
        {
            tavern.setPaths(debugroom, debugroom, debugroom,templeSq);
            tavern.setRoomProperties(false, true, false, false, false);
            tavern.getNPCInRoom().put(Npc.getNpcMap().get("TAVERNKEEPER").getName().toUpperCase(), Npc.getNpcMap().get("TAVERNKEEPER"));
            tavern.getItemsInRoom().put(Item.itemMap.get("gratesword").getName().toUpperCase(), Item.itemMap.get("gratesword"));
            if (dices.rd100() > 95) {
                tavern.getItemsInRoom().put(Item.itemMap.get("dagger").getName().toUpperCase(), Item.itemMap.get("dagger"));
                tavern.hasItems = true;
            }
        }
        //temple
        {
            temple.setPaths(debugroom, debugroom, templeSq, debugroom);
            temple.setRoomProperties(false, true, false, false, false);
            temple.getNPCInRoom().put(Npc.getNpcMap().get("CLERIC").getName().toUpperCase(), Npc.getNpcMap().get("CLERIC"));
            if (dices.rd100() > 50) {
                temple.getItemsInRoom().put(Item.itemMap.get("bread").getName().toUpperCase(), Item.itemMap.get("bread"));
                temple.hasItems = true;
                if (dices.rd100() > 75) {
                    temple.getItemsInRoom().put(Item.itemMap.get("bread").getName().toUpperCase(), Item.itemMap.get("bread"));
                }
            }
            if (dices.rd100() > 75) {
                temple.getItemsInRoom().put(Item.itemMap.get("coins").getName().toUpperCase(), Item.itemMap.get("coins"));
                temple.hasItems = true;
            }
            if (dices.rd100() > 90) {
                temple.getItemsInRoom().put(Item.itemMap.get("cheapwine").getName().toUpperCase(), Item.itemMap.get("cheapwine"));
                temple.hasItems = true;
            }
        }
        //market
        {
            market.setPaths(templeSq, fieldsN, forge, bakery);
            market.setRoomProperties(false, true, false, false, false);

            if (dices.rd100() > 25) {
                market.getItemsInRoom().put(Item.itemMap.get("bread").getName().toUpperCase(), Item.itemMap.get("bread"));
                market.hasItems = true;
                if (dices.rd100() > 50) {
                    market.getItemsInRoom().put(Item.itemMap.get("bread").getName().toUpperCase(), Item.itemMap.get("bread"));
                    if (dices.rd100() > 75) {
                        market.getItemsInRoom().put(Item.itemMap.get("bread").getName().toUpperCase(), Item.itemMap.get("bread"));
                    }
                }
            }
            if (dices.rd100() > 75) {
                market.getItemsInRoom().put(Item.itemMap.get("coins").getName().toUpperCase(), Item.itemMap.get("coins"));
                market.hasItems = true;
                if (dices.rd100() > 75) {
                    market.getItemsInRoom().put(Item.itemMap.get("coins").getName().toUpperCase(), Item.itemMap.get("coins"));
                }
            }
        }
        //bakery
        {
        bakery.setPaths(debugroom, debugroom, market, debugroom);
        bakery.setRoomProperties(false, true, false, false, false);
        bakery.getNPCInRoom().put(Npc.getNpcMap().get("BAKER").getName().toUpperCase(), Npc.getNpcMap().get("BAKER"));
        if (dices.rd100() > 75) {
            bakery.getItemsInRoom().put(Item.itemMap.get("cupcake").getName().toUpperCase(), Item.itemMap.get("cupcake"));
            bakery.hasItems = true;
            if (dices.rd100() > 75) {
                bakery.getItemsInRoom().put(Item.itemMap.get("cupcake").getName().toUpperCase(), Item.itemMap.get("cupcake"));
                if (dices.rd100() > 75) {
                    bakery.getItemsInRoom().put(Item.itemMap.get("cupcake").getName().toUpperCase(), Item.itemMap.get("cupcake"));
                }
            }
        }
    }
        //forge
        {
            forge.setPaths(debugroom, alchemist, debugroom, market);
            forge.setRoomProperties(false, true, false, false, false);
            forge.getNPCInRoom().put(Npc.getNpcMap().get("ASSISTANT").getName().toUpperCase(), Npc.getNpcMap().get("ASSISTANT"));
            if (dices.rd100() > 95) {
                forge.getItemsInRoom().put(Item.itemMap.get("chainmail").getName().toUpperCase(), Item.itemMap.get("chainmail"));
                forge.hasItems = true;
            }
        }
        // alchemist
        {
            alchemist.setPaths(forge, debugroom, debugroom, debugroom);
            alchemist.setRoomProperties(false, true, true, false, false);
            alchemist.getNPCInRoom().put(Npc.getNpcMap().get("ALCHEMIST").getName().toUpperCase(), Npc.getNpcMap().get("ALCHEMIST"));
            if (dices.rd100() > 50) {
                alchemist.getItemsInRoom().put(Item.itemMap.get("healingp").getName().toUpperCase(), Item.itemMap.get("healingp"));
                alchemist.hasItems = true;
            }
            if (dices.rd100() > 90) {
                alchemist.getItemsInRoom().put(Item.itemMap.get("tpp").getName().toUpperCase(), Item.itemMap.get("tpp"));
                alchemist.hasItems = true;
            }
        }
        //fields N
        {
            fieldsN.setPaths(market, fieldsS, debugroom, debugroom);
            fieldsN.setRoomProperties(true, false, false, true, false);
            fieldsN.getMOBSInRoom().put("CRITTER1", Mob.getMobMap().get("CRITTER"));
            fieldsN.getMOBSInRoom().put("CRITTER2", Mob.getMobMap().get("CRITTER"));
            fieldsN.getMOBSInRoom().put("CRITTER3", Mob.getMobMap().get("CRITTER"));
            fieldsN.getMOBSInRoom().put("CRITTER4", Mob.getMobMap().get("CRITTER"));
            fieldsN.getMOBSInRoom().put("CRITTER5", Mob.getMobMap().get("CRITTER"));
        }
        //fields S
        {
            fieldsS.setPaths(fieldsN, forest, debugroom, debugroom);
            fieldsS.setRoomProperties(true, false, false, false, true);
            fieldsS.getMOBSInRoom().put("GOBLIN1", Mob.getMobMap().get("GOBLIN"));
            fieldsS.getMOBSInRoom().put("GOBLIN2", Mob.getMobMap().get("GOBLIN"));
            fieldsS.getMOBSInRoom().put("GOBLIN3", Mob.getMobMap().get("GOBLIN"));
            fieldsS.getMOBSInRoom().put("GOBLIN4", Mob.getMobMap().get("GOBLIN"));
            fieldsS.getMOBSInRoom().put("GOBLIN5", Mob.getMobMap().get("GOBLIN"));
        }
        //forest
        {
            forest.setPaths(fieldsS, debugroom, debugroom, bossRoom);
            forest.setRoomProperties(true, false, false, false, true);
            forest.getMOBSInRoom().put("BUGBEAR1", Mob.getMobMap().get("BUGBEAR"));
            forest.getMOBSInRoom().put("BUGBEAR2", Mob.getMobMap().get("BUGBEAR"));
            forest.getMOBSInRoom().put("ORGRE3", Mob.getMobMap().get("OGRE"));
            forest.getMOBSInRoom().put("ORGRE4", Mob.getMobMap().get("OGRE"));
        }
        //boss Room
        {
            bossRoom.setPaths(debugroom, debugroom, forest, debugroom);
            bossRoom.setRoomProperties(true, false, false, false, true);
            bossRoom.getMOBSInRoom().put(Mob.getMobMap().get("BOSS").getName().toUpperCase(), Mob.getMobMap().get("BOSS"));
        }
        // descrizioni delle stanze
        {
            castle.setDescription("""
                An enormous throne room opens up before you: white marble walls, a long red carpet stretching from the door all the way to the throne.
                Four proud guards stand tall to your right as you enter, and another four have just arrived from a shift change to your left.
                The walls are covered in tapestries and paintings—you can easily see that the largest tapestry depicts the current king.
                At the far end of the room, a staircase with about 6-7 steps leads up to a luxurious throne made of gold and inlaid with mother-of-pearl.
                On the throne sits a humanoid figure—a fat man with broad shoulders and a well-groomed beard. A crown rests on his head. He is the king.""");

            prison.setDescription("""
                As you descend the stairs, you find yourself in a damp space lit only by torches. The air is stale and thick with dust.
                At the bottom of the stairs, you see a wooden door. A guard is sitting at a nearby table.
                As you pass, he writes your name in the logbook. The prison door is open and leads into a hallway.
                You can already see a row of cells with iron bars as thick as broom handles.
                The cells are filthy, the stench of urine hangs in the air, and the faces inside are far from friendly.""");

            templeSq.setDescription("""
                The temple square is full of people. You see children playing hopscotch, guards patrolling, and old ladies feeding pigeons.
                To the north, the drawbridge leads to the castle entrance, where three guards stand watch. You can almost glimpse the throne room in the distance.
                To the south is the grand city market, with its stalls and emporiums. You can already hear the clamor of merchants shouting about "the deal of a lifetime" from that direction.
                To the east stands the great temple of the gods, proudly made of the world’s finest marble. There you might find help from the priests, known for their healing and empowering abilities.""");

            tavern.setDescription("""
                Upon entering the tavern, you're overwhelmed by the sharp scent of alcohol. The main room is bustling with life and laughter.
                In front of the counter are several round tables, some full, some empty. The walls are covered with scratches, hunting trophies, and posters.
                On the wall to the right of the entrance is a notice board pinned with paper sheets listing various quests.
                The tavern keeper turns at the sound of the bell fixed above the door, glances at you briefly, then resumes chatting with a customer.
                You spot a small crowd gathered, watching what appears to be a deadly duel between two cockroaches.""");

            temple.setDescription("""
                The massive archway of the temple door opens into a marble hall, with rows of mahogany benches.
                At the far end of the room, opposite the entrance, stands a statue of a deity.
                A serene melody flows from a series of ivory pipes placed around the hall, and the air is filled with the strong scent of incense.
                Monks and clerics are scattered across the rooms, but in the main hall, only one man in a black robe can be seen praying on his knees.""");

            bakery.setDescription("""
                As you step through the bakery door, you're wrapped in the warm scent of vanilla and butter.
                On light wooden shelves, various pastries and flatbreads are displayed.
                In the corner to the right of the entrance, there's a lounge area with a couch and chairs around a coffee table—the idea of sitting down for a nice cup of tea is quite tempting.
                On the counter in front of you, a selection of adorable pastries decorated with cream and seasonal fruit immediately catches your eye.
                Behind the counter, a large, masculine man with a well-groomed beard and strong arms delicately handles a piping bag, drawing cat ears on a vanilla cupcake.""");

            market.setDescription("""
                As you approach the market, the merchants' voices and shouts grow louder.
                Shops surround the plaza where the city market stands. Stalls are arranged in the usual double-circle layout, with food vendors in the center and others around them.
                Sellers try to lure you in with promises of great bargains, often with excessive enthusiasm.
                To the south, you see the massive battlements that protect the city from the dangers of the forest.
                To the east and west, various shops such as the alchemist and the forge await.""");

            forge.setDescription("""
                The forge is divided into two areas: an enclosed room for buying and selling, and an open area facing the square for forging weapons.
                In the open-air section, you see a woman in a tank top and apron hammering a sword on her anvil.
                Inside the shop, you notice that the wall to your right and the one at the back are densely covered with weapons and shields for sale.
                Reading the prices, you quickly realize that most of them are far beyond your means.
                Behind a dark wooden counter to the left of the entrance, a thin man with long hair is polishing a sword.""");

            alchemist.setDescription("""
                Entering the alchemist's emporium, you're immediately blinded by a flash of light.
                A fairly young man has just caused a pouch of alchemical ingredients to explode and is now covered in purple dust.
                Behind him, the back wall is packed to the brim with shelves filled with scrolls, vials, alchemical tools, and all sorts of knickknacks.
                The room is a labyrinth of tables and display cases filled with alchemical goods and strange brews.""");

            fieldsN.setDescription("""
                Just beyond the city gates, leaving behind the hustle of the town, you're welcomed by the calm expanse of the countryside.
                Small farms of light wood and brick are dotted across the cultivated fields, immersed in greenery.
                Farmers work at a steady pace, guiding oxen along the furrows of fertile soil.
                The air smells of sun and freshly turned earth. Further south, a quiet river winds between two cultivated banks,
                joined by a stone bridge that looks centuries old. In the distance, you can see the thick forest.""");

            fieldsS.setDescription("""
                As you cross the stone bridge, the fields begin to change.
                The grass grows taller, the paths become uncertain, and the landscape loses its human order.
                The river splits into gentle streams, as if inviting you away from the safety of the walls.
                Further south, the forest grows closer—thick, silent, and known for its hostility.
                It’s no place for careless travelers.""");

            forest.setDescription("""
                You venture into the forest. The light and safety of the fields quickly vanish with every step.
                You feel hostile gazes from behind tree branches, and hear hisses and rustles from unknown creatures among the ferns.
                Hostile beings—stronger and more primal than any you've faced before—roam these woods.
                Your sense of direction fades among the brambles and dense bushes that make the paths hard to navigate.
                Everything is disorienting, except for one certainty: the way back home. You can still see the windmills and farms in the distance,
                but go any deeper, and even that lifeline may vanish.""");

            bossRoom.setDescription("""
                You arrive in a clearing. The air is dry and the forest is eerily silent.
                The sounds of birds and animals have vanished completely. The wind howls through the trees.
                Something is wrong. It's calm—too calm.""");
        }
    }

    public Room(String name, Room nordPath, Room sudPath, Room westPath, Room eastPath,
                boolean hasItems, boolean hasNPC, boolean hasGuards, boolean hasCritters, boolean hasMOBS,
                Map<String,Item> itemsInRoom, Map<String,Mob> MOBSInRoom, Map<String,Entity> NPCInRoom, String description) {
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
        this.NPCInRoom = NPCInRoom;
        this.description = description;
    }

    public Room(String name) {
        this.name = name;
        this.itemsInRoom = new HashMap<>();
        this.MOBSInRoom = new HashMap<>();
        this.NPCInRoom = new HashMap<>();
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

    public void RandomizeGuards(Room room){
        int roll =dices.rd100();
        switch (room.getName().toUpperCase()){

            case "TEMPLESQUARE","MARKET"->{
                if(!room.isHasGuards()){
                    if(roll>25){
                        room.getNPCInRoom().put(Npc.getNpcMap().get("GUARD").getName().toUpperCase(), Npc.getNpcMap().get("GUARD"));
                        room.setHasGuards(true);
                        room.setHasNPC(true);
                    }
                }else{
                    if(roll>75){
                        room.getNPCInRoom().remove("THE GUARD");
                        if(room.getNPCInRoom().isEmpty()){
                            room.setHasNPC(false);
                            room.setHasGuards(false);
                        }
                    }

                }

            }
            case "TEMPLE"->{
                if(!room.isHasGuards()){
                    if(dices.rd100()>90){
                        room.getNPCInRoom().put(Npc.getNpcMap().get("GUARD").getName().toUpperCase(), Npc.getNpcMap().get("GUARD"));
                        room.setHasGuards(true);
                    }
                }else{
                    if(dices.rd100()>50){
                        room.getNPCInRoom().remove("GUARD");
                    }

                }

            }
        }
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
    public Room getSudPath() {
        return sudPath;
    }
    public Room getWestPath() {
        return westPath;
    }
    public Room getEastPath() {
        return eastPath;
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

    public Map<String, Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public void setItemsInRoom(Map<String, Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

    public Map<String, Mob> getMOBSInRoom() {
        return MOBSInRoom;
    }

    public void setMOBSInRoom(Map<String, Mob> MOBSInRoom) {
        this.MOBSInRoom = MOBSInRoom;
    }



    public static Map<String, Room> getRoomMap() {
        return roomMap;
    }

    public static void setRoomMap(Map<String, Room> roomMap) {
        Room.roomMap = roomMap;
    }

    public Map<String, Entity> getNPCInRoom() {
        return NPCInRoom;
    }

    public void setNPCInRoom(Map<String, Entity> NPCInRoom) {
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

    public void setHasNPC(boolean hasNPC) {
        this.hasNPC = hasNPC;
    }
}
