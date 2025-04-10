package mud;

import java.io.Console;
import mud.characters.fightable.Character;
import mud.characters.fightable.PlayerCharacter;

public class GameMap {
    public static Console console = System.console();

    public void checkForCombat(Character char1, Character char2){
        if(char1.getStamina() >= char2.getStamina()){
            combat(char1, char2);
        } else {
            System.out.println("You don't have enough stamina to fight this monster! Go train some more.");
        }
    }

    public void combat(Character char1, Character char2){
        while (char1.checkIfAlive() && char2.checkIfAlive()){
            char1.attack(char2);
            if(!char2.checkIfAlive()){
                break;
            }
            char2.attack(char1);
        }
        if(char1.checkIfAlive() && char1 instanceof PlayerCharacter player){
            player.addKillsCounter();
        } else {
            //TODO
//            askForRespawn();
        }
    }
}
