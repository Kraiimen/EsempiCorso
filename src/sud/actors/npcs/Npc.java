package sud.actors.npcs;

import sud.Die;
import sud.actors.Actor;
import sud.environment.rooms.Room;

public class Npc /*extends Actor*/ {
    //private boolean isInteractable;

    private Actor body;

    public Npc(Actor a) {
        body = a;
    }

    //costruttore ipotetico con reflection... poi mi sono reso conto che non c'è nessun motivo di usare reflection...
    //public Npc(String name, Class<? extends Actor> a) {
    //    try {
    //        body = a.getDeclaredConstructor(String.class).newInstance(name);
    //    } catch (Exception e) {
    //        e.printStackTrace(); // or handle it as needed
    //    }
    //}
    //public Npc(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
    //    super(name, strength, dexterity, constitution, intelligence, wisdom, charisma);
    //}
    //public Npc(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Room spawnPoint) {
    //    super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, spawnPoint);
    //}

    //public boolean CanInteract() {
    //    return isInteractable;
    //}

    //public void setIsInteractable(boolean canInteract) {
    //    this.isInteractable = canInteract;
    //}

    public Die getConstitutionDice() {
        return null;
    }
}
