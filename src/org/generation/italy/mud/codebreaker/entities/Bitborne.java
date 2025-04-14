package org.generation.italy.mud.codebreaker.entities;

import org.generation.italy.mud.codebreaker.inventory.Inventory;

import java.util.Scanner;

public class Bitborne extends InteractiveEntity{
    private String className;
    private Inventory inventory = new Inventory();
    private int totalxp;
    private int currentxp;
    private int xpToLevelUp;
    private int level;

    public Bitborne(String className, int stamina, int strenght, int agility, int intelligence) {
        super(stamina, strenght, agility, intelligence);
        this.className = className;
        this.level = 1;
        setAttack(strenght * 3);
        setDefend(stamina * 2);
        setMaxHp(stamina * 10);
        setCurrentHealth(getMaxHp());
    }

    public void setClassName(String className){
        this.className = className;
    }

    public int getXpMissingToLevelUp(){
        return xpToLevelUp - currentxp;
    }

    public void xpToLevelUpRequired(){
        this.xpToLevelUp = 20 + (level - 1) * 50;
    }

    public void rest(){
        try {
            setCurrentHealth(getCurrentHealth() + (int) (0.2 * getMaxHp()));
            if (getCurrentHealth() > getMaxHp()) {
                setCurrentHealth(getMaxHp());
            }
            System.out.println("Thread in sleep mode... Rigenerazione hp in corso...");
            Thread.sleep(1000);
            printHpBar();
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println("Qualcosa è andato storto durante la rigenerazione hp");
        }
    }

    public void checkLevelUp(Mob mob) {
        currentXpSystem(mob);
        if (currentxp > xpToLevelUp) {
            level++;
            System.out.println("Hai raggiunto il livello: " + level);
            xpToLevelUpRequired();
            levelUpStatsIncrease();
            if (currentxp - xpToLevelUp > 0) {
                currentxp -= xpToLevelUp;
            } else {
                currentxp = 0;
            }
        }
    }

        public void levelUpStatsIncrease () {
            System.out.println("Hai livellato! hai 3 punti stat da distribuire");
            Scanner scanner = new Scanner(System.in);
            int pointsCounter = 0;
            String choice = "";
            do {
                System.out.println("Scegli una stat da aumentare (1-Stamina, 2-Strength, 3-Agility, 4-Intelligence)");
                choice = scanner.nextLine();
                switch (choice.toLowerCase()) {
                    case "1":
                    case "stamina":
                        setStamina(getStamina() + 1);
                        pointsCounter++;
                        setMaxHp(getStamina() * 15);
                        System.out.println(printHpBar());
                        break;
                    case "2":
                    case "strength":
                        setStrength(getStrength() + 1);
                        pointsCounter++;
                        setAttack(getStrength() * 5);
                        System.out.println("Forza:" + getStrength() + " Attacco:" + getAttack());
                        break;
                    case "3":
                    case "agility":
                        setAgility(getAgility() + 1);
                        pointsCounter++;
                        System.out.println("Agilità:" + getAgility());
                        break;
                    case "4":
                    case "intelligence":
                        setIntelligence(getIntelligence() + 1);
                        pointsCounter++;
                        System.out.println("Intelligenza:" + getIntelligence());
                        break;
                    default:
                        System.out.println("Scelta non valida, riprova");
                }
                System.out.println("Punti distribuiti: " + pointsCounter + "/3");
            } while (pointsCounter < 3);
            System.out.println("Distribuzione punti completata");
        }



    public void currentXpSystem(Mob defeatedEnemyXp){
        currentxp += defeatedEnemyXp.getXp();
    }
    public void losingXp(){
        currentxp -= (int) (xpToLevelUp * 0.15);
        if(currentxp < 0){
            currentxp = 0;
        }
    }
    public void showStats(){
        System.out.println();
        System.out.println("----------SCHEDA STATS----------");
        System.out.println(printHpBar());
        System.out.println("Attacco:" + getAttack() + "    Difesa:" + getDefend() + "    Agilità:" + getAgility() + "    Stamina:" + getStamina() + "    Forza:" +getStrength() + "    Intelligenza:" + getIntelligence());
        System.out.println("Livello attuale:" + level + "    Esperienza attuale:" + currentxp + "/" + xpToLevelUp );




    }





}