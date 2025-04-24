package mud.characters.npcs;

import mud.characters.Entity;
import mud.items.Item;
import mud.rooms.MagicMap;
import mud.rooms.Room;

import static mud.GameUtil.*;
import static mud.characters.fightable.Character.dice;

public class Elf extends Entity {
    public static final int ELF_POSSIBLE_ROOM = 8;
    boolean isQuestOpen;

    public Elf(String name, String greetMessage) {
        super(name);
        setGreetMessage(greetMessage);
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(ELF_POSSIBLE_ROOM)));
    }
    public Elf(String name, String greetMessage, Room startingRoom, Item item, boolean hasQuest) {
        this(name, greetMessage);
        getActualRoom().getPresentEntities().remove(this.getName());
        setActualRoom(startingRoom);
        getInventory().put(item.getName(), item);
        setHasQuest(hasQuest);
    }

    @Override
    public void greet(){
        if(doesHaveQuest()) {
            if(getName().equals("Arwen")){
                printArwenInstructions();
            } else if(getName().equals("Elrond")){
                printElrondQuestFirstMessage();
            }
        }else if(isQuestOpen) {
            System.out.println(BLUE + "How's the quest going, dear Adventurer? Remember, the faith of our realm lays in your brave hands..." + RESET);
            delay(500);
        } else {
            System.out.println(getName() + " says : " + BLUE + getGreetMessage() + RESET);
            delay(500);
        }

    }
    public void printArwenInstructions(){
        System.out.println("PRESS ENTER TO CONTINUE READING.");
        delay(300);
        System.out.printf("%s says :" + BLUE + " %s the brave! My father told me about your mission!%n", getName(), player.getName());
        System.out.print("Let me give you a few advice to accomplish it :");
        continueTheMessage();
        System.out.print("You can fight with small monsters to get stronger before trying to defeat monsters such as ghosts or dragons");
        continueTheMessage();
        System.out.print("We wouldn't want to lose our hero so soon! Cats are a perfect enemy to start fighting with!");
        continueTheMessage();
        System.out.print("Of course I know they're cute, but don't worry, they're magical cats and they reappear as soon as you've killed them");
        continueTheMessage();
        System.out.print("Yet it's still illegal to kill them, so I would check if there are guards around before doing it if I were you...");
        continueTheMessage();
        System.out.print("The guards are always moving in the city, so be sure to take a look around even if you think that there's nobody!");
        continueTheMessage();
        System.out.print("Once you've trained with a few cats, you can search for goblins here in the gardens without worrying about the guards!");
        continueTheMessage();
        System.out.println("If you ever feel lost, don't worry... Take this" + RESET);
        delay(500);
        setHasQuest(false);
        Item map = getInventory().get("Map");
        getInventory().remove(map.getName());
        player.pickItem(map);
        delay(500);
        System.out.printf(BLUE + "It's a map of our realm! Check you inventory to use it.%nWhen you stroll around here you can also search and pick other magical items that will increase you ability in fighting.%n" +
                "See you soon!%n" + RESET);
        delay(500);
    }
    public void printElrondQuestFirstMessage(){

        System.out.println("PRESS ENTER TO CONTINUE READING.");
        delay(300);
        System.out.printf("%s says :" + BLUE + " Dear %s, I've been waiting for you!%n", getName(), player.getName());
        System.out.print("I heard songs about you heroic accomplishments from other realms and you're exactly what this city needs right now.");
        continueTheMessage();
        System.out.print("There's an evil dragon in the deep of the woods who's guiding all his monstrous followers nearer and nearer to our village.");
        continueTheMessage();
        System.out.print("His name is Smaug and all his power lays in a magic Ring he always carries in his clutch.");
        continueTheMessage();
        System.out.print("Defeat him and bring me his ring to destroy, and the heart of this city will be light and free once again.");
        continueTheMessage();
        System.out.printf("Go to the Magic Garden and find my beloved daughter Arwen, she will give you advice for your mission. And...%n" +
                "Here! Take this...%n" + RESET);
        delay(500);
        setHasQuest(false);
        isQuestOpen = true;
        NPCMap.getNpcs().get(1).setHasQuest(true);
        Item weaponGiven = getInventory().get("Short sword");
        getInventory().remove(weaponGiven);
        player.pickItem(weaponGiven);
        delay(500);
        System.out.printf(BLUE + "It's an elvish short sword, it will be a good weapon to start training to defeat monsters.%n" +
                "See you soon!%n" + RESET);
        delay(500);
    }

}
