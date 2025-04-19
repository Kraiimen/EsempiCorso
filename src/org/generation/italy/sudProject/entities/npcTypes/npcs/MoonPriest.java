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
            player.setXp(player.getXp()-player.getMaxXp());
            player.setPlayerLevel(player.getPlayerLevel() + 1);
            player.setMaxXp(player.getMaxXp()+player.STARTING_MAX_XP);
            if(player.getPlayerLevel()%5==0){
                boolean loop = true;
                do{
                    //aumenta statistiche
                    player.showStats();
                    System.out.println("Scegli la statistica da aumentare:");
                    switch(console.readLine().toUpperCase()){
                        case "STRENGTH":
                            //controllo se ha raggiunto il cap di 20 e aumento
                            if(player.getStrength() != MAX_ATTRIBUTE_P_VALUE-1){
                                player.setStrength(player.getStrength()+1);
                                loop = false;
                            }
                            break;
                        case "DEXTERITY":
                            if(player.getStrength() != MAX_ATTRIBUTE_P_VALUE-1){
                                player.setStrength(player.getStrength()+1);
                                loop = false;
                            }
                            break;
                        case "CONSTITUTION":
                            if(player.getStrength() != MAX_ATTRIBUTE_P_VALUE-1){
                                player.setStrength(player.getStrength()+1);
                                loop = false;
                            }
                            break;
                        case "INTELLIGENCE":
                            if(player.getStrength() != MAX_ATTRIBUTE_P_VALUE-1){
                                player.setStrength(player.getStrength()+1);
                                loop = false;
                            }
                            break;
                        case "WISDOM":
                            if(player.getStrength() != MAX_ATTRIBUTE_P_VALUE-1){
                                player.setStrength(player.getStrength()+1);
                                loop = false;
                            }
                            break;
                        case "CHARISMA":
                            if(player.getStrength() != MAX_ATTRIBUTE_P_VALUE-1){
                                player.setStrength(player.getStrength()+1);
                                loop = false;
                            }
                            break;
                        default:
                            System.out.println("Nome statistica errato, riprova");
                            break;
                    }
                }while(loop);
            }
        }else{
            System.out.println("Non puoi ancora salire di livello");
        }
    }
}
