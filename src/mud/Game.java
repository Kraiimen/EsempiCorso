package mud;

import mud.characters.Entity;
import mud.characters.fightable.Character;
import mud.characters.fightable.Wizard;
import mud.rooms.MagicMap;
import mud.rooms.Room;

import java.util.List;

public class Game {
    public static void main(String[] args){
        System.out.println("Inizia il gioco");
        Wizard boh = new Wizard("Marco");
        MagicMap mappa = new MagicMap();
        List<Room> rooms = mappa.getRooms();
        rooms.getFirst().beInRoom(boh);
        System.out.println("Sei in " + rooms.getFirst().getName());
        boh.getActualRoom().changeRoomPlayer(CardinalPoints.NORTH, boh);
    }
}
