package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Enemies.Guards;
import org.generation.italy.edenGame.entity.Enemies.Monster;

import java.util.Map;
import java.util.Random;

public class CityDoor extends Room{

    Enemies enemy = new Guards("Sempro", 50, 50, 20, 10);
    Enemies enemy2 = new Monster("ASHULA", 50, 50, 15, 50);

    public CityDoor(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Questa è la grande porta della città di Eden, da qui in poi regna l'oscuro... ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" ");
    }


    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Esci di qui (E)");
    }

    public Enemies getEnemy() {
        Random dice = new Random();
        int chanceOfMonster = dice.nextInt(2);
        if (chanceOfMonster == 0) {
            return enemy;
        } else {
            return enemy2;
        }
    }
}
