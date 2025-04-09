package sud.entity;

import sud.rooms.Room;

public class Npc extends Entity{
    private NpcState stato;
    private boolean canInteract;
    static {
        Npc debugNPC = new Npc("deb",100000,0,Room.getRoomPointerFromName("debugroom"),0,NpcState.PASSIVE,false);
        debugNPC.asignColor();
    }
    public Npc(String name, int maxHp, int attackDamage, Room currentroom, int xpOnDeath, NpcState stato, boolean canInteract) {
        super(name, maxHp, attackDamage, currentroom, xpOnDeath);
        this.stato = stato;
        this.canInteract = canInteract;
    }

    public void asignColor (){
        if(stato == NpcState.PASSIVE){this.setEntityColor(colorG);}if(stato == NpcState.NEUTRAL){this.setEntityColor(colorY);}if (stato == NpcState.AGGRESSIVE){this.setEntityColor(colorR);}
    }

    public NpcState getStato() {
        return stato;
    }

    public void setStato(NpcState stato) {
        this.stato = stato;
    }

    public boolean isCanInteract() {
        return canInteract;
    }

    public void setCanInteract(boolean canInteract) {
        this.canInteract = canInteract;
    }
}
