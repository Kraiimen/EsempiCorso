package org.generation.italy.fantasyGame.objects;

public class Food extends GameObject{
    private int hpValue;

    public Food(String name, int weight, int value, int hpValue){
        super(name, weight, value);
        this.hpValue=hpValue;
    }
}
