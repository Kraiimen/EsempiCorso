package sud.entity.classes;

import sud.dices;
import sud.entity.Entity;
import sud.entity.Player;

public class Rogue extends Player {
    private String playerName;
    private int hpDiceFaces;

    public Rogue(String name, String color,String playerName) {
        super(name, 8, color, "rogue");
        this.playerName = playerName;
        this.hpDiceFaces = 8;
    }

    public void increseHp(){
        this.setHealthPoints(this.getConMod()+ dices.roll(hpDiceFaces));
    }

    @Override
    public void attack (Entity attacked) {
        int damage = 0;
        int roll = dices.rd20();
        if (roll == 20) {
            damage = this.getEquipedWeapon().rollDamage() * 2;
        } else if (roll == 1) {
            System.out.printf(this.getEntityColor() + "Your attack was soo weak %s uses the opportunity and attacks you" + resetColor, attacked.getName());
            attacked.attack(this);
            return;
        } else if (doesAttackRollHit(attacked, roll)) {
            damage = this.getEquipedWeapon().rollDamage();
        }

        System.out.printf(this.getEntityColor() + "%s is attacking %s for %d damage\n " + resetColor, this.getName(), attacked.getName(), damage);
        attacked.hurt(damage + this.getDexMod());
        if (this.getEquipedArmor().getName().equalsIgnoreCase("Leather armor")){
            if(dices.rd100()>=75){
                System.out.printf(this.getEntityColor() + "%s manages to take %s by surprise and deal a second sneak attack for %d damage\n " + resetColor, this.getName(), attacked.getName(), damage);
                attacked.hurt(this.getDexMod()*4);
            }
        }
        if(this.getEquipedArmor().getName().equalsIgnoreCase("Chain mail")){
            if(dices.rd100()>=90){
                System.out.printf(this.getEntityColor() + "%s manages to take %s by surprise and deal a second sneak attack for %d damage\n " + resetColor, this.getName(), attacked.getName(), damage);
                attacked.hurt(this.getDexMod()*4);
            }
        }
        if (attacked.isDead()) {
            System.out.println(this.getEntityColor() + attacked.getName() + " has died by that hit\n " + resetColor);
        }
    }

    @Override
    public void levelUp(){
        if (this.getXp() >= 50) {
            if (this.getLevel() < 2) {
                this.setLevel(2);
            }
        } else if (this.getXp() >= 100) {
            if (this.getLevel() < 3) {
                this.setLevel(3);
            }
        } else if (this.getXp() >= 200) {
            if (this.getLevel() < 4) {
                this.setLevel(4);
            }
        } else if (this.getXp() >= 400) {
            if (this.getLevel() < 5) {
                this.setLevel(5);
            }
        }
        increseHp();
    }
}
