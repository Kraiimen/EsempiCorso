package mud;

import mud.characters.Entity;
import mud.characters.fightable.Character;
import mud.characters.fightable.Thief;
import mud.characters.fightable.Wizard;
import mud.characters.npcs.NPCMap;
import mud.rooms.MagicMap;
import mud.rooms.Room;

import java.util.List;

public class Game {
    public static void main(String[] args){
        System.out.println("Inizia il gioco");
        Wizard boh = new Wizard("Marco");
        Thief boh2 = new Thief("Giorgio");
        MagicMap mappa = new MagicMap();
        NPCMap npcs = new NPCMap();
        List<Room> rooms = mappa.getRooms();
        System.out.println(boh2.getActualRoom().getName());
        System.out.println("Sei in " + rooms.getFirst().getName());
        boh.changeRoom(CardinalPoints.SOUTH);
        boh.changeRoom(CardinalPoints.EAST);
        boh.getActualRoom().getPresentEntities().getFirst().greet();






    }
}
