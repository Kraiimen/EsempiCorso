package sud.engine.mechanics;

import sud.Die;
import sud.actors.Actor;
import sud.environment.CardinalDirection;
import sud.environment.rooms.Room;

import java.util.List;

public class MovementHandler {
    public static void moveCharacter(Actor a, CardinalDirection direction){
        Room prevPosition = a.getPosition();
        Room newPosition = prevPosition.getRoomByDirection(direction);
        if(newPosition == null){
            return;
        }
        a.move(newPosition);
        prevPosition.leave(a);
        newPosition.enter(a);
    }

    public static void moveCharacters(List<Actor> residents){
        for(Actor a : residents){
            if(Die.D6.roll() == 6){//!a.isInFight() (i residenti della stanza in cui mi trovo si spostano solo se non in combattimento)
                moveCharacter(a, CardinalDirection.NORTH);//TODO da creare un getRandomDirection()
            }
        }
    }
}
