package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Wizard extends Player {

    private boolean isBeardLong;

    public Wizard(String name, int maxHealth, int maxDamage, Room currentRoom) {
        super(name, maxHealth, maxDamage, currentRoom);


    }

    @Override
    protected void initializeStats() {
        this.strength = this.random.nextInt(21);
        this.intelligence = 5 + this.random.nextInt(21);
        this.agility = this.random.nextInt(21);
        this.stamina = this.random.nextInt(21);
    }

    @Override
    public void attack(Entity target) {
        int damage = strength + intelligence + agility + stamina;
        isBeardLong = this.random.nextInt(100) < 25;
        if(isBeardLong){
            damage *= 2;
            System.out.println(playerName + "Attacco critico al nemico. Danno: " + damage);
        }else{
            System.out.println(playerName +"Attacco il nemico. Danno: " + damage);
        }
        target.takeDamage(damage);
    }


    @Override
    void openInventory() {

    }

}
