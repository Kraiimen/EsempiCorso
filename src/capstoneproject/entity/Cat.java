package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Cat extends Npc{
    private static final int MAX_HEALTH = 20;
    private static final int MAX_DAMAGE = 10;


    public Cat(String name, Room currentRoom) {
        super(name, MAX_HEALTH, MAX_DAMAGE, currentRoom);

    }

    @Override
    protected void inizialateStatsNpc() {
        this.strength = 1;
        this.intelligence = 5;
        this.agility = 10;
        this.stamina = 1;
    }

    @Override
    public void attack(Entity target) {
        int damage = strength;
        if(isRage){
                System.out.println(getName() +"Attacca il player. Danno: " + damage);
        }
        target.takeDamage(damage);
    }
}



