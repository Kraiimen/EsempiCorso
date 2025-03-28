package org.generation.italy.fantasyGame.entity.player;

import org.generation.italy.fantasyGame.entity.Entity;
import org.generation.italy.fantasyGame.entity.Npc;

import java.util.ArrayList;

public class Wizard extends MagicalPlayer{
    private int intelligence;
    private static final int BASE_XP = 10;
    private static final int BASE_MANA = 10;


    public Wizard(String name, int maxHp, String namePlayer){
        super(name, maxHp, 5, namePlayer, BASE_XP, BASE_MANA);
        intelligence = 10;
    }
    public void fireAttack(){
        System.out.println("Lancia palla di fuoco");
    }
    public void runAway(){
        System.out.println("Run Away");
    }

    public void manageAttackNpc(Npc npc){
        while(getHealthPoints() > 20){
            attack(npc);
            if(npc.isDead()){
                intelligence++;
                break;
            }
        }
        if(getHealthPoints() < 20){
            runAway();
        }
    }
    public void playWithDuck(Duck d){
        d.swim();
        d.quack();

    }
    public void playWithRubberDuck(RubberDuck d){
        d.swim();
        d.quack();
        d.listenToBug();
    }
    public static void main (String[] args){
        Wizard w = new Wizard("Merlino", 100,"Stefano");
        Duck x = new RubberDuck();
        x.swim();
        Duck z = new Duck();
        z.swim();
        RubberDuck f = new RubberDuck();
        f.swim();
        //Duck x1 = new Wizard("Merlino", 100,"Stefano");
        w.playWithDuck(x);
        RubberDuck rb = new RubberDuck();
        w.playWithDuck((Duck)rb); // Upcast si va verso la Superclass , invece il Downcast va verso una sottoclasse denominato unsafe
        //x = (Duck)rb;
        rb = (RubberDuck) x;
        //x = (Duck)w;
    }
}

class Duck{
    public void swim(){
        System.out.println("Sto nuotando");
    }
    public void quack(){
        System.out.println("Quak Quak");
    }
}
class RubberDuck extends Duck {
    public void swim(){
        System.out.println("Sto galleggiando");
    }
    public void quack(){
        System.out.println("Squeak Squeak");
    }
    public void listenToBug() {
        System.out.println("Ascoltami mentre ");
    }
}

class SuperDuck extends RubberDuck {
    public void swim() {
        System.out.println("Sto volando");
    }

    public void quack() {
        System.out.println("Squeak Squeak");
    }
}