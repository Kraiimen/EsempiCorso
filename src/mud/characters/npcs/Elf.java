package mud.characters.npcs;

import mud.characters.Entity;
import mud.items.Item;
import mud.rooms.MagicMap;
import mud.rooms.Room;

import static mud.GameUtil.player;
import static mud.characters.fightable.Character.dice;

public class Elf extends Entity {
    private String greetMessage;
    private boolean hasQuest;
    public static final int ELF_POSSIBLE_ROOM = 8;

    public Elf(String name, String greetMessage) {
        super(name);
        this.greetMessage = greetMessage;
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(ELF_POSSIBLE_ROOM)));
    }
    public Elf(String name, String greetMessage, Room startingRoom, Item item) {
        this(name, greetMessage);
        setActualRoom(startingRoom);
        getInventory().put(item.getName(), item);
        hasQuest = true;
    }

    @Override
    public void greet(){
        if(hasQuest){
            System.out.println("TESTO DELLA QUEST");
            System.out.println("DEVI FARE BLABLABLA");
            hasQuest = false;
            Item weaponGiven = getInventory().get("Sting the Short Sword");
            getInventory().remove(weaponGiven);
            player.pickItem(weaponGiven);
        } else{
            System.out.println(getName() + " says : " + greetMessage);
        }
        //TODO TESTO DELLA QUEST

    }
}
