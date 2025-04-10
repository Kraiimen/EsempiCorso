package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Cat extends Npc{

    public Cat(String charName, int maxHP, Room currentRoom) {
        super(charName, maxHP, 3, currentRoom, false, "Cat");
        getMessages().add("Please spare me");
    }

    public void showGratitude(){
        System.out.println("Thank you, kind being. Not many of your kind are this nice to small creatures like me. When the Cat Revolution will come, we will remember your kindness.");
    }


}
