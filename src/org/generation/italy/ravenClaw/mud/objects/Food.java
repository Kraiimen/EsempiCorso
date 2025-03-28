package org.generation.italy.ravenClaw.mud.objects;

public class Food extends Item{


    public Food (String name, int value,int weight){
        super(name, value,weight);
        this.setType(ItemType.FOOD);
    }
}
