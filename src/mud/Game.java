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

import static mud.GameUtil.*;

public class Game {
    public static void main(String[] args){
        //prove di gioco, la struttura narrativa principale poi sarà in GameMap

        MagicMap mappa = new MagicMap();
        NPCMap npcs = new NPCMap();
        MonsterMap monsters = new MonsterMap();
        GameMap story = new GameMap();
        story.start();


    }
}
