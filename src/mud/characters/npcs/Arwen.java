package mud.characters.npcs;

import mud.items.Food;
import mud.items.IntelligenceItem;
import mud.items.Item;
import mud.items.Map;
import mud.rooms.MagicMap;

import static mud.GameUtil.*;
import static mud.GameUtil.delay;

public class Arwen extends Elf{
    public Arwen() {
        super("Arwen", "I'm willing to give up my immortal life, just to live a mortal life with you...",
                MagicMap.getRooms().get(5), new Map("Map"));
    }

    @Override
    public void greet(){
        if(doesHaveQuest()) {
            printArwenInstructions();
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
        System.out.print("Once you've trained with a few cats, you can search for goblins here in the gardens without worrying about the guards!");
        continueTheMessage();
        System.out.println("If you ever feel lost, don't worry... Take this" + RESET);
        delay(1000);
        setHasQuest(false);
        Item map = getInventory().get("Map");
        getInventory().remove(map);
        player.pickItem(map);
        delay(800);
        System.out.printf(BLUE + "It's a map of our realm! Check you inventory to use it. When you stroll around here you can also search and pick other magical items that will increase you ability in fighting." +
                "See you soon!%n" + RESET);
        delay(500);
    }
}

