package mud.characters.npcs;

import mud.characters.Entity;
import mud.items.Item;
import mud.rooms.MagicMap;
import mud.rooms.Room;

import static mud.GameUtil.*;
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
        getActualRoom().getPresentEntities().remove(this.getName());
        setActualRoom(startingRoom);
        getInventory().put(item.getName(), item);
        hasQuest = true;
    }

    @Override
    public void greet(){
        if(hasQuest){
            System.out.println("PRESS ENTER TO CONTINUE READING.");
            delay(800);
            System.out.printf("%s says :" + BLUE + " Dear %s, I've been waiting for you!%n", getName(), player.getName());
            System.out.println("I heard songs about you heroic accomplishments from other realms and you're exactly what this city needs right now.");
            continueTheMessage();
            System.out.println("There's an evil dragon in the deep of the woods who's guiding all his monstrous followers nearer and nearer to our village.");
            continueTheMessage();
            System.out.println("His name is Smaug and all his power lays in a magic Ring he always carries in his clutch.");
            continueTheMessage();
            System.out.println("Defeat him and bring me his ring to destroy, and the heart of this city will be light and free once again.");
            continueTheMessage();
            System.out.printf("Find my beloved daughter Arwen, she will give you advice for your mission. And...%n" +
                    "Here! Take this...%n" + RESET);
            delay(1000);
            hasQuest = false;
            Item weaponGiven = getInventory().get("Sting the Short Sword");
            getInventory().remove(weaponGiven);
            player.pickItem(weaponGiven);
            delay(800);
            System.out.printf(BLUE + "It's an elvish short sword, it will be a good weapon to start training to defeat monsters.%n" +
                    "See you soon!%n" + RESET);
            continueTheMessage();
        } else{
            System.out.println(getName() + " says : " + BLUE + greetMessage + RESET);
            delay(500);
        }
    }
}
