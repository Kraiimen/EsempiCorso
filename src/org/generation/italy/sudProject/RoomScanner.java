package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.npcTypes.npcs.Baker;
import org.generation.italy.sudProject.entities.npcTypes.npcs.Blacksmith;
import org.generation.italy.sudProject.entities.npcTypes.npcs.MoonPriest;
import org.generation.italy.sudProject.map.Room;

import java.util.ArrayList;
import java.util.List;

import static org.generation.italy.sudProject.map.Room.*;

public class RoomScanner {
    private static List<Controls> controls = new ArrayList<>();
    public static List<Controls> fightControls = new ArrayList<>(List.of(Controls.ATTACK, Controls.ESCAPE));
    public static StringBuilder sb = new StringBuilder();

    public static List<Controls> scan(Room room){
        sb = null;
        controls.clear();
        controls.add(Controls.QUIT);
        controls.add(Controls.EQUIP);
        controls.add(Controls.UNEQUIP);
        controls.add(Controls.EAT);
        if(!room.getRoomEntities().get(CAT_INDEX).isEmpty() ||
                !room.getRoomEntities().get(GUARD_INDEX).isEmpty() ||
                !room.getRoomEntities().get(CULTIST_INDEX).isEmpty() ||
                !room.getRoomEntities().get(UNDEAD_CAT_INDEX).isEmpty() ||
                !room.getRoomEntities().get(BOSS_INDEX).isEmpty()){
            controls.add(Controls.ATTACK);
        }
        if(room.isWayOut()){
            controls.add(Controls.MOVE);
        }
        if(room.getRoomEntities().get(CORPSE_INDEX) != null){
            controls.add(Controls.PICK_FROM_CORPSE);
        }
        if(room.getRoomObjects() != null){
            controls.add(Controls.PICK_UP);
        }
        if(room.getRoomEntities().get(ROOM_MAIN_NPC_INDEX).getFirst() instanceof MoonPriest){
            controls.add(Controls.REST);
            controls.add(Controls.LEVEL_UP);
        }
        if(room.getRoomEntities().get(ROOM_MAIN_NPC_INDEX).getFirst() instanceof Baker ||
                room.getRoomEntities().get(ROOM_MAIN_NPC_INDEX).getFirst() instanceof Blacksmith){
            controls.add(Controls.BUY);
        }
        for(Controls c : controls){
            sb.append(c.getValue());
        }
        return controls;
    }

    public static StringBuilder getSb() {
        return sb;
    }

    public static List<Controls> getFightControls() {
        return fightControls;
    }
}
