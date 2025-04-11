package capstoneproject.rooms;

public class Armour extends Item{
    private int defence;

    public Armour(String name, String description, double weight, int cost, int defence) {
        super(name, description, weight, cost);
    }

    Armour chainMail = new Armour("Cotta di Maglia", "Armatura leggera ma resistente, perfetta per agilità", 5.0, 100, 15);
    Armour helmet = new Armour("Elmo", "Un elmo robusto che protegge la testa", 1.5, 30, 5);
    Armour plateArmor = new Armour("Piastra di Ferro", "Armatura pesante che offre grande protezione", 20.0, 250, 50);

    public int getDefence(){
        return defence;
    }

}
