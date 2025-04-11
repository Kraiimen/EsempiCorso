package capstoneproject.rooms;


import capstoneproject.Directions;
import capstoneproject.entity.Cat;
import capstoneproject.entity.Npc;

import java.util.*;

public class Room {
    protected String name;
    private String description;
    protected Map<Directions, Room> exits;
    protected ArrayList<Npc> npcList;

    public Room(String name, String description){
        this.name=name;
        this.description = description;
        this.exits = new HashMap<>();
        this.npcList = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void addExit(Directions dir , Room exit){
        exits.put(dir, exit);

        // Aggiungi l'uscita inversa solo se non è già presente
        // Evita di aggiungere nuovamente l'uscita inversa
        if (!exit.exits.containsValue(this)) {
            exit.addExit(dir.getOpposite(), this);
        }
    }

    public Optional<Room> getExitAt (Directions dir){
        Room destination = exits.get(dir);
        if(destination == null){
            return Optional.empty();
        }
        return Optional.of(destination);
    }

    public void addToNpcList(Npc npc){
        npcList.add(npc);
    }

    public void printNpcInCurrentRoom() {
        if (!npcList.isEmpty()) {
            System.out.println("Gli npc in questa stanza sono: ");
            for (int i = 0; i < npcList.size(); i++) {
                System.out.println((i + 1) + " " + npcList.get(i));
            }
        } else{
            System.out.println("La stanza è vuota");
        }
    }
    public List<Npc> getNpcList(){
        return npcList;
    }

}
