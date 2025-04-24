package VideoGame.Inventario;

public class Oggetti {
    private String nome;
    private String descrizione;
    private int quantita;
    private int costo;


    public Oggetti(String nome, String descrizione, int quantita, int costo){
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.costo = costo;
    }
    public String toString(){
        return nome + "." + descrizione + " " + quantita + " quantita " + costo + " gold ";
    }




    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione(){
        return descrizione;
    }
    public void setDescrizione( String descrizione){
         this.descrizione = descrizione;
    }
    public int getQuantita(){
        return quantita;
    }
    public void setQuantita(int quantita){
        this.quantita = quantita;
    }
    public int getCosto(){
        return costo;
    }
    public void setCosto(int costo){
        this.costo = costo;
}
}
