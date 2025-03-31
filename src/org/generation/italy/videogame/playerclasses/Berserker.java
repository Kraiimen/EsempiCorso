package org.generation.italy.videogame.playerclasses;

import org.generation.italy.videogame.models.Entity;
import org.generation.italy.videogame.models.Player;

import java.util.Random;

public class Berserker extends Player {

    // COSTRUTTORE
    public Berserker(String name, int maxHP, int hpValue, String playerName){
        super(name, maxHP, hpValue, playerName);
    }

    // Se va berserker aumenta il danno
    public void goBerserk(){
        if(isBerserkPossible()){
            if(getDamage() > 0 && getDamage() <= getMAX_BASE_DAMAGE_POSSIBLE()){
                setDamage(getDamage() * 3);
            }
            else{
                setDamage(getDamage() * 2);
            }
        }
    }

    // Il berserker ha una possibilità su 10 di andare berserk
    public boolean isBerserkPossible(){
        Random random = new Random();
        return random.nextDouble(1) <= 0.1;
    }

    @Override
    public void attackEntity(Entity entityToAttack){
        setAttackDamage(); // Danno random
        goBerserk(); // Se il berserker va berserk sovrascrivi il danno
        System.out.println(getName() + " is attacking " + entityToAttack.getName() + "!");
        System.out.println(getName() + " inflicted " + getDamage() + " to " + entityToAttack.getName() + "!");
        entityToAttack.takeDamage(getDamage()); // Diminuiamo gli HP dell'entità attaccata
    }
}
