package sud.engine.mechanics;

import sud.Die;
import sud.actors.Actor;
import sud.actors.npcs.Cat;
import sud.actors.npcs.Guard;
import sud.actors.npcs.Npc;
import sud.environment.WorldMap;
import sud.environment.rooms.Room;

import java.util.List;

public class SpawnManager {

    public static List<Actor> generateEcosystem(){
        List<Room> map = WorldMap.getWorldMap();
        for(Room r : map){

        }
        return null;
    }

    public static List<Actor> defaultTempleResidents(){
        //Actor prete = new Npc("prete");
        return null;//List.of(prete);
    }
    public static List<Actor> defaultBakeryResidents(){
        //Actor panettiere = new Npc("panettiere");
        return null;//List.of(panettiere);
    }
    public static List<Actor> defaultArmoryResidents(){
        //Actor armaiolo = new Npc("armaiolo");
        return null;//List.of(armaiolo);
    }

    public static void updatePopulation() {
        List<Room> map = WorldMap.getWorldMap();
        for(Room r : map){
            if(Die.D8.roll() == Die.D8.getValue()){
                //Actor a = switch(Die.D4.roll()){
                //    case 1 -> new Cat("gatto");
                //    case 2 -> new Cat("gatto");
                //    case 3 -> new Cat("gatto");
                //    case 4 -> new Guard("guardia");
                //    default -> null;    //non succederà mai
                //};
                //r.enter(a);
            }
        }
    }
}
