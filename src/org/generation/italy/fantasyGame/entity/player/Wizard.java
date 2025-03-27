package org.generation.italy.fantasyGame.entity.player;

public class Wizard extends Player{
    private int intelligence;


    public Wizard(String name, int maxHp, String namePlayer){
        super(name, maxHp, 5, namePlayer);
        intelligence = 10;
    }
    public void fireAttack(){
        System.out.println("Lancia palla di fuoco");
    }
    public void runAway(){
        System.out.println("Run Away");
    }

    public void manageAttackNpc(int hP){
        while(getHealthPoints() > 20){
            fireAttack();
            if(hP == 0){
                intelligence++;
                break;
            }
        }
        if(getHealthPoints() < 20){
            runAway();
        }
    }
}
