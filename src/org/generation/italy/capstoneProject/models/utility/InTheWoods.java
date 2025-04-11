package org.generation.italy.capstoneProject.models.utility;

import org.generation.italy.capstoneProject.models.npc.monsters.Monster;
import org.generation.italy.capstoneProject.models.npc.monsters.normal.*;

import java.util.Random;
import java.util.List;

public class InTheWoods {

    private static final List<Monster> MONSTERS = List.of(
            new Skeleton(),
            new Slime(),
            new Ghoul(),
            new Vampire(),
            new Harpy()
    );

    public static Monster generateRandomMonster() {
        Random random = new Random();
        return MONSTERS.get(random.nextInt(MONSTERS.size()));
    }
}

