package mud;

import java.io.Console;
import mud.characters.fightable.Character;
import mud.characters.fightable.PlayerCharacter;

import static mud.GameUtil.*;

public class GameMap {
    public static Console console = System.console();
    public void start(){
        createNewPlayer();
        while(true){
            askIfWantToMove();
            checkForMonsters();
            randomizeTheGuards();
        }
    }
}
