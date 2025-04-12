package mud;

import java.io.Console;

import static mud.GameUtil.*;

public class GameMap {
    public static Console console = System.console();
    public void start(){
        try{
            createNewPlayer();
            while(true){
                try{
                    askWhatToDoWithoutMenu();
                }catch(EndOfGameException e){
                    break;
                }
                randomizeTheGuards();
            }
        } catch (EndOfGameException e) {
            System.out.println("End of Game");
        }

    }
}
