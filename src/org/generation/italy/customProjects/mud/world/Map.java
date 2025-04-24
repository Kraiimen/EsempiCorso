package org.generation.italy.customProjects.mud.world;

import org.generation.italy.customProjects.mud.entities.Wizard;

import java.util.Random;

public class Map {
    private Place templeSquare = new Place("Temple Square", ", l'anima della città");
    private Place templeRoom = new Place("Temple Room", ", sede dei sacerdoti della città...");
    private Place marketSquare = new Place("Market Square", ", sede del mercato, centro economico della città");
    private Place theBakery = new Place("The Bakery", ", profumo di pane a tutte le ore");
    private Place theArmory = new Place("The Armory", ", posto ideale se hai bisogno di attrezzatura");
    private Place garden1 = new Place("Garden", ", parte iniziale dei giardini, con la magnifica Fontana dei 4 Cani");
    private Place garden2 = new Place("Garden", ", parte centrale dei giardini, caratterizzata dal lungo viale tra gli alberi e i fiori");
    private Place garden3 = new Place("Garden", ", parte finale dei giardini, luogo di ritrovo dei gattini");
    private Place cityDoor = new Place("City Door", ", i cancelli della città, luogo tendenzialmente pieno di guardie e persone ed animali provenienti dall'esterno");
    private Place woods1 = new Place("Woods", ", le mura ella città non ti proteggono più dalle creature esterne");
    private Place woods2 = new Place("Woods", ", nel pieno dei boschi, la quantità di creature sconosciute qui è notevole");
    private Place woods3 = new Place("Woods", ", parte più selvaggia dei boschi, solo gli avventurieri hanno il coraggio di passare da queste parti, alla ricerca delle creature più misteriose");


    public Map() {
        buildMap();

    }

    private void buildMap() {
        templeSquare.setExit(Direction.SOUTH, marketSquare);
        templeSquare.setExit(Direction.EAST, templeRoom);
        templeRoom.setExit(Direction.WEST, templeSquare);
        marketSquare.setExit(Direction.NORTH, templeSquare);
        marketSquare.setExit(Direction.EAST, theBakery);
        marketSquare.setExit(Direction.SOUTH, garden1);
        marketSquare.setExit(Direction.WEST, theArmory);
        theArmory.setExit(Direction.EAST, marketSquare);
        garden1.setExit(Direction.NORTH, marketSquare);
        garden1.setExit(Direction.SOUTH, garden2);
        garden2.setExit(Direction.NORTH, garden1);
        garden2.setExit(Direction.SOUTH, garden3);
        garden3.setExit(Direction.NORTH, garden2);
        garden3.setExit(Direction.SOUTH, cityDoor);
        cityDoor.setExit(Direction.NORTH, garden3);
        cityDoor.setExit(Direction.SOUTH, woods1);
        woods1.setExit(Direction.NORTH, cityDoor);
        woods1.setExit(Direction.SOUTH, woods2);
        woods2.setExit(Direction.NORTH, woods1);
        woods2.setExit(Direction.SOUTH, woods3);
        woods3.setExit(Direction.NORTH, woods2);
    }

    public void putEntities() {
        Random entityType = new Random();
        Random entityNum = new Random();
    }
}
