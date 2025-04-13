package sud.entity.classes;
import java.util.Random;

import sud.entity.Entity;
import sud.entity.Player;
import sud.dices;

public class Fighter extends Player {
    private String playerName;
    private int hpDiceFaces;



    public Fighter(String name,String color, String playerName) {
        super(name, 10, color, "fighter");
        this.playerName = playerName;
        this.hpDiceFaces = 10;
    }

    public void increseHp(){
        this.setHealthPoints(this.getConMod()+dices.roll(hpDiceFaces));
    }
    @Override
    public void attack (Entity attacked) {
        int damage = 0;
        int roll = dices.rd20();
        if (roll == 20) {
            damage = this.getEquipedWeapon().rollDamage() * 2;
        } else if (roll == 1) {
            System.out.printf(this.getEntityColor() + "<Your attack was soo weak %s uses the opportunity and attacks you>" + resetColor, attacked.getName());
            attacked.attack(this);
            return;
        } else if (doesAttackRollHit(attacked, roll)) {
            damage = this.getEquipedWeapon().rollDamage()+ this.getStrMod();
            System.out.printf(this.getEntityColor() + "<%s is attacking %s with the the %s for %d damage>\n " + resetColor, this.getName(), attacked.getName(),this.getEquipedWeapon().getName(), damage);
            attacked.hurt(damage );
        }
        if (attacked.getHealthPoints()<1) {
            System.out.println(this.getEntityColor() + attacked.getName() + " <has died by that hit>\n " + resetColor);
            System.out.printf("<You gain %d Xp>",attacked.getXpOnDeath());
            this.setXp(this.getXp()+attacked.getXpOnDeath());
        }
    }

    @Override
    public boolean levelUp(){

        if(this.getXp() <50){
            System.out.println("<You don't have enough xp to level up>");
            return false;
        }else if (this.getXp() >= 50) {
            if (this.getLevel() < 2) {
                this.setLevel(2);
                this.sleep();
                return true;
            }else {
                System.out.println("<You don't have enough xp to level up>");

            }
            return false;
        } else if (this.getXp() >= 100) {
            if (this.getLevel() < 3) {
                this.setLevel(3);
                this.sleep();
                return true;

            }else {
                System.out.println("<You don't have enough xp to level up>");

            }
            return false;
        } else if (this.getXp() >= 200) {
            if (this.getLevel() < 4) {
                this.setLevel(4);
                this.sleep();
                return true;

            }else {
                System.out.println("<You don't have enough xp to level up>");

            }
            return false;
        } else if (this.getXp() >= 400) {
            if (this.getLevel() < 5) {
                this.setLevel(5);
                this.sleep();
                return true;

            }else {
                System.out.println("<You don't have enough xp to level up>");
            }
            return false;
        }
        increseHp();
        return false;

    }

}
