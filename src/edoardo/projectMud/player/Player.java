package edoardo.projectMud.player;

import edoardo.projectMud.Directions;
import edoardo.projectMud.Entity;
import edoardo.projectMud.Genre;
import edoardo.projectMud.npc.Merchant;

import java.io.Console;
import java.util.ArrayList;

public abstract class  Player extends Entity {
    private int intelligence;
    private int agility;
    private int stamina;
    private int exp;
    private int expToReachToLevel = 100;
    private int lv = 1;
    static private final ArrayList<Directions> backLogDirections = new ArrayList<>();


    public Player(String name, Genre genre) {
        super(name, genre);
    }
    public void showStats(){
        String RESET = "\u001B[0m";
        String RED_TEXT = "\u001B[31m";
        String GREEN_TEXT = "\u001B[32m";
        String YELLOW_TEXT = "\u001B[33m";
        String BLUE_TEXT = "\u001B[34m";
        String MAGENTA_TEXT = "\u001B[35m";

        System.out.printf("""
                Stats:
                
                %s
                
                   Lv: %d exp to level up: %d
                   %s Hp: %d%s
                1- %s Strength: %d%s
                2- %s Intelligence: %d%s
                3- %s Agility: %d%s
                4- %s Stamina: %d%s
                
                
                """,this,lv, expToReachToLevel - exp,MAGENTA_TEXT, getHp(), RESET, RED_TEXT, getStrength(), RESET, BLUE_TEXT, intelligence, RESET
                ,   GREEN_TEXT, agility , RESET,YELLOW_TEXT, stamina, RESET  );
    }

    public void showStats(int hp, int strength, int intelligence, int agility, int stamina){
        String RESET = "\u001B[0m";
        String RED_TEXT = "\u001B[31m";
        String GREEN_TEXT = "\u001B[32m";
        String YELLOW_TEXT = "\u001B[33m";
        String BLUE_TEXT = "\u001B[34m";
        String MAGENTA_TEXT = "\u001B[35m";

        System.out.printf("""
                Randomize Stats
                
                %s
                
                    Lv: %d
                 - %s Hp: %d%s
                1- %s Strength: %d%s
                2- %s Intelligence: %d%s
                3- %s Agility: %d%s
                4- %s Stamina: %d%s
                
                
                """,this,lv, MAGENTA_TEXT, hp, RESET, RED_TEXT, strength, RESET, BLUE_TEXT, intelligence, RESET
                ,   GREEN_TEXT, agility , RESET,YELLOW_TEXT, stamina, RESET  );
    }
    public void assignUserChoicePoints(int pointsToSpend){
        System.out.println("You have " + pointsToSpend + " points to spend, select the number of the stat you want to boost:");
        Console console = System.console();
        for (int i = 0; i < pointsToSpend; i++) {
            String userChoice = console.readLine();
            switch (userChoice){
                case "1" -> setStrength(getStrength()+1);
                case "2" -> intelligence ++;

                case "3" -> agility ++;
                case "4" -> stamina++;
                default -> {
                    System.out.println("Invalid input");
                    i--;
                    continue;
                }

            }
            System.out.println("Point assigned");
        }
    }
    //public void talk();
    public abstract void setAttributes();

    public void buy(Merchant m){
    }
    public abstract void randomEVent();
    private void lvUp(){
        lv++;
        boostPoints();
    }
    private void boostPoints(){
        intelligence++;
        stamina++;
        setStrength(getStrength()+1);
        agility++;
        System.out.println("LEVEL UP\nYour stats increased by one");

    }
    public void setExp(int exp) {
        if(exp >= expToReachToLevel){
            this.exp = exp - expToReachToLevel;
            expToReachToLevel*=2;
            lvUp();
            showStats();
            assignUserChoicePoints(1);
            return;
        }
        this.exp = exp;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getExp() {
        return exp;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static ArrayList<Directions> getBackLogDirections() {
        return backLogDirections;
    }

    public static void updateBackLogDirections(Directions dir) {
        backLogDirections.add(dir);
    }
}
