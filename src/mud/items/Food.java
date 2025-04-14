package mud.items;

import mud.Answer;

import static mud.GameMap.console;

public class Food extends Item{
    private int hpGiven;

    public Food(String name, int hpGiven) {
        super(name);
        this.hpGiven = hpGiven;
    }
    public String checkFood() {
        String ans = null;
        System.out.println("Do you want to eat this?");
        do {
            System.out.println("Answer Y or N: ");
            ans = console.readLine().toUpperCase();
        } while (!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
        if (ans.equals(Answer.Y.toString())) {
            return "Y";
        }
        return "";
    }

    public int getHpGiven() {
        return hpGiven;
    }
    public void setHpGiven(int hpGiven) {
        this.hpGiven = hpGiven;
    }
}
