package edoardo.projectMud.player;

import edoardo.projectMud.Coin;
import edoardo.projectMud.DungeonManager;
import edoardo.projectMud.Entity;
import edoardo.projectMud.Genre;
import edoardo.projectMud.npc.Succube;

import java.io.Console;

public class Paladin extends Player{
    private boolean isVirgin = true;
    private int corruptBonus = 10;

    public Paladin(String name, Genre genre) {
        super(name, genre);
        setClassTipology("Paladin");
        setAttributes();





    }

    @Override
    public void randomEVent() {
        Coin resultCoinToss = coinToss();
        String other;
        if(resultCoinToss == Coin.TAILS){
            other = "woman";
        }else {
            other = "man";
        }
        System.out.printf("You meet a very sensual dark-looking %s who invites you to come closer.\n", other);
        System.out.println("Do you approach?\n \u001B[31m \nYES - NO \u001B[0m ");

        Console c = System.console();
        String choice = c.readLine();
        if (choice.equalsIgnoreCase("YES")){
            System.out.println("\"Do you want to attack?\\n \\u001B[31m \\nYES - NO \\u001B[0m \"");
            choice = c.readLine();
            if (choice.equalsIgnoreCase("YES")){
                DungeonManager.battleCycle(this, new Succube());
            } else if(choice.equalsIgnoreCase("NO")){
                isVirgin = false;
                System.out.println("You continue to approach, but you faint");
                System.out.println("You find yourself in a bed, you perceived a new power in yourself");
                System.out.println("but you have lost something that cannot be regained");
                System.out.println("And is this new power lasting or not?");
            }
        } else {
            System.out.println("You run away");
        }


    }

    @Override
    public void attack(Entity a) {
        int bonusAttack = getRandom().nextInt();
        int weaponBonus = 0;
        if (getWeapon() != null){
            weaponBonus = getWeapon().getBonusPhysicalAttack();
        }
        int attack = getStrength()+bonusAttack+weaponBonus;
        if (isVirgin){
            int VIRGIN_BONUS = 5;
            attack += VIRGIN_BONUS;
        } else {
            attack += corruptBonus;
            corruptBonus--;
        }
        a.setHp(getHp()-attack);
        System.out.println("the " + getClassTipology() + " " + getName() + " inflicts " + attack + " damage");
        System.out.println(a.getName() + "remaining hp: " + getName() );
    }
    @Override
    public void setAttributes(){
        setMaxHp(randomizeHealth());
        setHp(getMaxHp());
        int randomizedStrength = randomizeStrength();
        int randomizedIntelligence = randomizeIntelligence();
        int randomizedAgility = randomizeAgility();
        int randomizeStamina = randomizeStamina();
        showStats(getHp(), randomizedStrength, randomizedIntelligence, randomizedAgility, randomizeStamina);
        int pointsUserCanLocate = 3;
        assignUserChoicePoints(pointsUserCanLocate);




    }
    private int randomizeStrength(){
        int strengthClassBonus = 8;
        int startStrengthMax = 13;
        return getRandom().nextInt(startStrengthMax-strengthClassBonus +1) + strengthClassBonus;
    }

    private int randomizeHealth(){
        int hpClassBonus = 100;
        int startMaxHp =150;
        return getRandom().nextInt(startMaxHp-hpClassBonus +1) + hpClassBonus;
    }
    private int randomizeAgility(){
        int agilityClassBonus = 5;
        int startAgilityMax = 10;
        return getRandom().nextInt(startAgilityMax-agilityClassBonus +1) + agilityClassBonus;
    }
    private  int randomizeIntelligence(){
        int intelligenceClassBonus = 5;
        int startIntelligenceMax = 10;
        return getRandom().nextInt(startIntelligenceMax-intelligenceClassBonus +1) + intelligenceClassBonus;
    }
    private int randomizeStamina(){
        int staminaClassBonus = 8;
        int starStaminaMax = 13;
        return getRandom().nextInt(starStaminaMax-staminaClassBonus+1)+staminaClassBonus;
    }
}
