package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Guards extends Npc{
    public Guards(String name, int maxHealth, int maxDamage, Room currentRoom) {
        super(name, maxHealth, maxDamage, currentRoom);
    }

    @Override
    protected void inizialateStatsNpc() {
        this.strength = 10;
        this.intelligence = 10;
        this.agility = 10;
        this.stamina = 10;
    }

    @Override
    public void attack(Entity target) {
        int damage = strength + intelligence + agility + stamina;
        System.out.println(getName() +"Attacca il player. Danno: " + damage);
        target.takeDamage(damage);
    }
}
