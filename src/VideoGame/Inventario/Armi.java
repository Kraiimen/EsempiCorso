package VideoGame.Inventario;

public class Armi extends Oggetti {
    private int danno;
    private int velocitaAttacco;

    public Armi(String nome, String descrizione, int quantita, int costo) {
        super(nome, descrizione, quantita, costo);
    }
}
