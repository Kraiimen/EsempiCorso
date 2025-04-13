package org.generation.italy.mud.codebreaker.zones;

import org.generation.italy.mud.codebreaker.entities.Entity;
import org.generation.italy.mud.codebreaker.entities.Mob;

import java.util.*;
import java.util.stream.Collectors;

public class Zone {
    private String name;
    private String description;
    private List<Entity> npcs = new ArrayList<>();
    private List<Mob> aggressiveMobs = new ArrayList<>();
    private List<Mob> passiveMobs = new ArrayList<>();
    private boolean event;

    private Map<Navigate, Zone> navigateNearZones = new HashMap<>();

    public Zone(String name, String description) {
        this.name = name;
        this.description = description;
    }





    public void setAggroMobSpawnChanceType(Mob type, int numMaxMobs, int spawnChance){
        Random random = new Random();
        for(int i = 1; i < numMaxMobs; i++){
            int hundredpercent = random.nextInt(1, 101);
            if(spawnChance >= hundredpercent){
                if(aggressiveMobs.size() < 4) {
                    Mob newMob = new Mob(type.getCharacterName(), type.getAgility(), type.getStamina(), type.getStrength(), type.getIntelligence(),type.getXp(),false);
                    aggressiveMobs.add(newMob);
                }
            }
        }
    }
    public void setPassiveMobSpawnChanceType(Mob type, int numMaxMobs, int spawnChance){
        Random random = new Random();
        for(int i = 1; i < numMaxMobs; i++){
            int hundredpercent = random.nextInt(1, 101);
            if(spawnChance >= hundredpercent){
                Mob newMob = new Mob(type.getCharacterName(),type.getAgility(), type.getStamina(),type.getStrength(),type.getIntelligence(),type.getXp(), false);
                if(passiveMobs.size() < 4) {
                    passiveMobs.add(newMob);
                }
            }
        }
    }

    public void setGuardsMechanics(){
        Random dice = new Random();
        boolean exist = passiveMobs.stream().anyMatch
                (mob -> getName().equalsIgnoreCase("PointerGuard"));
        if(!exist){
            setPassiveMobSpawnChanceType(new Mob("PointerGuard",10,10,10,10,15,false),2,30);
        }
        if(exist && dice.nextInt(1,101) <= 60){

            Optional<Mob> mobToRemove = passiveMobs.stream()
                    .filter(mob -> mob.getCharacterName().equalsIgnoreCase("PointerGuard")).findFirst();

            mobToRemove.ifPresent(mob -> passiveMobs.remove(mob));
        }


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

    public void setAggressiveMob(Mob mob){
        this.aggressiveMobs.add(mob);
    }

    public List<Mob> getAggressiveMobs(){
        return aggressiveMobs;
    }

    public Mob getAggressiveMob(){
        if(aggressiveMobs.isEmpty()){
            return null;
        }
        return aggressiveMobs.getFirst();
    }

    public void setPassiveMob(Mob mob){
        this.passiveMobs.add(mob);
    }
    public List<Mob> getPassiveMobs(){
        return passiveMobs;
    }
    public Mob getPassiveMob(){
        if(passiveMobs.isEmpty()){
            return null;
        }
        return passiveMobs.getFirst();
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


