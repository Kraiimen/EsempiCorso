package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Enemies.Guards;

import java.util.Map;

public class Armory extends Room{

    Enemies enemy = new Guards("Caio", 50, 50, 20, 10);

    public Armory(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Un luogo dove le armi vengono forgiate, vendute e comprate... ma anche trovate ");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" ");
    }
    public Enemies getEnemy() {
        return enemy;
    }
    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Ruba (St), Compra (B), Info Abilità (I), Esci di qui (E)");
    }
}
