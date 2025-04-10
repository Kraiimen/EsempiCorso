package mud;

import mud.characters.Entity;
import mud.characters.fightable.Thief;
import mud.characters.fightable.Wizard;
import mud.characters.fightable.monsters.Cat;
import mud.characters.fightable.monsters.MonsterMap;
import mud.characters.npcs.NPCMap;
import mud.rooms.MagicMap;
import mud.rooms.Room;

import java.util.List;

public class Game {
    public static void main(String[] args){
        //prove di gioco, la struttura narrativa principale poi sarà in GameMap
        System.out.println("Inizia il gioco");
        Wizard boh = new Wizard("Marco");
        Thief boh2 = new Thief("Giorgio");

        MagicMap mappa = new MagicMap();
        NPCMap npcs = new NPCMap();
        MonsterMap monsters = new MonsterMap();
        GameMap story = new GameMap();

        List<Room> rooms = MagicMap.getRooms();
        System.out.println(boh2.getActualRoom().getName());
        System.out.println("Sei in " + rooms.getFirst().getName());
        boh.changeRoom(CardinalPoints.SOUTH);
        boh.changeRoom(CardinalPoints.EAST);
        List<Entity> cats = boh.getActualRoom().getPresentEntities().stream().filter(entity -> entity instanceof Cat cat).toList();
        if(!cats.isEmpty()){
            if(cats.getFirst() instanceof Cat cat){
                story.combat(boh,cat);
            }
        }







    }
}
