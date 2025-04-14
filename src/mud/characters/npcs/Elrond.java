package mud.characters.npcs;

import mud.items.Item;
import mud.items.Weapon;
import mud.rooms.MagicMap;

import static mud.GameUtil.*;

public class Elrond extends Elf {
    private boolean isQuestOpen;

    public Elrond() {
        super("Elrond", "There will soon be a time when us elves will return home...", MagicMap.getRooms().get(1), new Weapon("Sting the Short Sword", 2));
        isQuestOpen = true;
        setHasQuest(true);
    }

    @Override
    public void greet(){
        if(doesHaveQuest()) {
            printElrondQuestFirstMessage();
        } else if(isQuestOpen){
            System.out.println(BLUE + "How's the quest going, dear Adventurer? Remember, the faith of our realm lays in your brave hands..." + RESET);
            delay(500);
        } else {
            System.out.println(getName() + " says : " + BLUE + getGreetMessage() + RESET);
            delay(500);
        }

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
        delay(1000);
        setHasQuest(false);
        NPCMap.getNpcs().get(1).setHasQuest(true);
        Item weaponGiven = getInventory().get("Sting the Short Sword");
        getInventory().remove(weaponGiven);
        player.pickItem(weaponGiven);
        delay(800);
        System.out.printf(BLUE + "It's an elvish short sword, it will be a good weapon to start training to defeat monsters.%n" +
                "See you soon!%n" + RESET);
        delay(500);
    }
}
