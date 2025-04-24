package VideoGame.Inventario;

public class  Pozioni extends Oggetti {
    private int recuperoVita;
    private int recuperoMana;
    private String purificazione;

    public Pozioni(String nome, String descrizione, int quantita, int costo, String purificazione) {
        super(nome, descrizione, quantita, costo);

    }
}



