package org.generation.italy.mud.codebreaker.zones;

import org.generation.italy.mud.codebreaker.entities.Entity;
import org.generation.italy.mud.codebreaker.entities.InteractiveEntity;
import org.generation.italy.mud.codebreaker.entities.Mob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zone {
    private String name;
    private String description;
    private List<Entity> npcs = new ArrayList<>();
    private List<Mob> mob = new ArrayList<>();
    private boolean event;

    private Map<Navigate, Zone> navigateNearZones = new HashMap<>();

    public Zone(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setNearZones(Navigate direction, Zone zone) {
        navigateNearZones.put(direction,zone);
    }



    public Zone getNearZone(Navigate direction){
        return navigateNearZones.get(direction);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Entity> getNpcs(){
        return npcs;
    }

//    public void setNpcList(List<Entity> npcs){
//        this.npcs = npcs;
//    }
    public void setNpcs(Entity npc){
        this.npcs.add(npc);
    }
    public void setMob(Mob mob){
        this.mob.add(mob);
    }

    public Mob getMob(){
        if(mob.isEmpty()){
            return null;
        }
        return mob.getFirst();
    }

    public List<Mob> getMobs(){
        return mob;
    }
    public void setEvent(boolean event){
        this.event = event;
    }
    public boolean getEvent(){
        return this.event;
    }


 }





//
//
//    public static void setCharacters(List<Entity> characters) {
//        this.characters = characters;


