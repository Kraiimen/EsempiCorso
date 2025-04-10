package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Paladin extends Player {

    private boolean isVirgin;

    public Paladin(int maxHealt, int maxDamage, String playerName, Room currentRoom) {
        super(maxHealt, maxDamage, playerName,currentRoom);


    }

    @Override
    protected void initializeStats() {
        this.strength = 5 + this.random.nextInt(21);
        this.intelligence =  this.random.nextInt(21);
        this.agility = this.random.nextInt(21);
        this.stamina = this.random.nextInt(21);

    }

    @Override
    public void attack(Entity target) {
        int damage = strength + intelligence + agility + stamina;
        isVirgin = this.random.nextInt(100) < 25;
        if(isVirgin){
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
