package VideoGame.Inventario;

public class Armature extends Oggetti {
    private int difesaFisica;
    private int difesaMagica;
    private int vitaExtra;
    private int manaExtra;
    private int tenacia;

    public Armature(String nome, String descrizione, int quantita, int costo) {
        super(nome, descrizione, quantita, costo);
    }
}
