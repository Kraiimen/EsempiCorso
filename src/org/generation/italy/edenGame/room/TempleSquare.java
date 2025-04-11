package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Cat;
import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Enemies.Guards;

import java.util.Map;

public class TempleSquare extends Room{

    Enemies enemy = new Cat("giacomino", 10, 10, 1, 1);

    public TempleSquare(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Una piazza sacra, al centro della cittadella, pieno di persone e di storie ");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" ");
    }


    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Cerca (C), Esci da qua (E)");
    }

    public Enemies getEnemy() {
        return enemy;

    }
}
