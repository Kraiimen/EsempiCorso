package sud.actors.npcs;

import sud.Die;
import sud.actors.Actor;
import sud.environment.rooms.Room;

public class Npc extends Actor {
    private boolean isInteractable;


    public Npc(String name) {
        super(name);
    }
    public Npc(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(name, strength, dexterity, constitution, intelligence, wisdom, charisma);
    }
    public Npc(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Room spawnPoint) {
        super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, spawnPoint);
    }

    public boolean CanInteract() {
        return isInteractable;
    }

    public void setIsInteractable(boolean canInteract) {
        this.isInteractable = canInteract;
    }

    @Override
    public Die getConstitutionDice() {
        return null;
    }
}
