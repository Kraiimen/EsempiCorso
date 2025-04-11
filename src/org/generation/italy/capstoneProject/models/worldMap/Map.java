package org.generation.italy.capstoneProject.models.worldMap;

public class Map {

    public Room templeSquare;
    public Room marketSquare;
    public Room ilTempio;
    public Room armory;
    public Room bakery;
    public Room gardens;
    public Room cityGate;
    public Room wood1;
    public Room wood2;
    public Room antroOscuro;
    public Room alberoFine;

    public Map() {
        this.templeSquare = new Room("Temple Square");
        marketSquare = new Room("Market Square");
        ilTempio = new Room("Il Tempio");
        armory = new Room("Armory");
        bakery = new Room("Bakery");
        gardens = new Room("Gardens");
        cityGate = new Room("City gate");
        wood1 = new Room("Wood 1");
        wood2 = new Room("Wood 2");
        antroOscuro = new Room("Antro Oscuro");
        alberoFine = new Room("Albero della Fine");

        // Collegamenti tra le stanze
        templeSquare.setSouth(marketSquare);
        templeSquare.setEast(ilTempio);

        marketSquare.setNorth(templeSquare);
        marketSquare.setEast(bakery);
        marketSquare.setWest(armory);
        marketSquare.setSouth(gardens);

        gardens.setNorth(marketSquare);
        gardens.setSouth(cityGate);

        cityGate.setNorth(gardens);
        cityGate.setSouth(wood1);

        wood1.setNorth(cityGate);
        wood1.setSouth(wood2);

        wood2.setNorth(wood1);
        wood2.setSouth(antroOscuro);

        antroOscuro.setNorth(wood2);
        antroOscuro.setSouth(alberoFine);

        alberoFine.setNorth(antroOscuro);
    }

}
