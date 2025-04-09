package capstoneproject.entity;

import capstoneproject.Room;

public class Player extends Entity {
    private int exp;
    private Room currentRoom;

    public Player(String name, Room startingRoom) {
        super(name);
        this.currentRoom = startingRoom;
    }

    public void moveNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            currentRoom.describe();
        } else {
            System.out.println("There is no room to the north");
        }
    }

    public void moveSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            currentRoom.describe();
        } else {
            System.out.println("There is no room to the south");
        }
    }

    public void moveEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            currentRoom.describe();
        } else {
            System.out.println("There is no room to the east");
        }
    }

    public void moveWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            currentRoom.describe();
        } else {
            System.out.println("There is no room to the west");
        }
    }
    @Override
    public void printStats(){  // Override di print stat in charachter per stamapre tutte le statistiche
        super.printStats();
        System.out.println("You are in the room" + currentRoom.getName());
    }

    public void HealInTemple(){ //Funzione per ricaricarsi nel temple
        System.out.println("Healing in Temple");
        this.heal(5);
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
