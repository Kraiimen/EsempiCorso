package org.generation.italy.sudProject.entities.npcTypes.npcs;

import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.entities.npcTypes.CanNotBeAttackedNpc;
import org.generation.italy.sudProject.map.Room;

public class MoonPriest extends CanNotBeAttackedNpc {


    // /--CONSTRUCTORS--/
    public MoonPriest(String npcName, Room npcPosition, int indexNpcPosition) {
        super(npcName, 0, 5, WISDOM_INDEX, 20,
                25, 25, 2, npcPosition, indexNpcPosition, 1, 400);
    }
    // /--METHODS--/
    public void levelUpPlayer(Player player){
        if(player.xpOverCap()){
            player.setPlayerLevel(player.getPlayerLevel() + 1);
        }else{
            System.out.println("Non puoi ancora salire di livello");
        }
    }
}
