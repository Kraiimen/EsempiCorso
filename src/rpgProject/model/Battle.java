package rpgProject.model;

import java.util.ArrayList;

public class Battle {
    private ArrayList<Fighter> turnOrder;

    public Battle(){
        turnOrder = new ArrayList<>();
    }
    public void addCombatTurn(Fighter target){
        turnOrder.add(target);
    }
    public void startFight() {
        for (Fighter target : turnOrder) {
            target.turnManage();
        }
    }
    public static void test(){
        System.out.println("test");
    }
}

