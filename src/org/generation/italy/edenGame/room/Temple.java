package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Cat;
import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.npc.HighPriest;
import org.generation.italy.edenGame.entity.npc.Npc;

import java.util.Map;

public class Temple extends Room{

    Npc highPriest = new HighPriest("Sacerdote ✝✝", 1, 1, 0, 0);
    Enemies enemy = new Cat("fufù 🐱", 10, 10, 1, 1);

    public Temple(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("🕯️Qui il sacerdote potrà farti riposare 😴💤 Puoi anche chiedergli una benedizione per la tua Esperienza🕯️");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }

    @Override
    public Npc getNpc() {
        return highPriest;
    }

    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Riposa (R), Prega (P), Info Abilità (I), Esci da qua (E)");
    }

    @Override
    public Enemies getEnemy() {
        return enemy;
    }



}
