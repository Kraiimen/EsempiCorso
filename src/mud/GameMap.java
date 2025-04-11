package mud;

import java.io.Console;

import static mud.GameUtil.*;

public class GameMap {
    public static Console console = System.console();
    public void start(){
        createNewPlayer();
        while(true){
            try {
                askWhatToDo();
            } catch (EndOfGameException e) {
                break;
            }
            randomizeTheGuards();
        }
    }
}
