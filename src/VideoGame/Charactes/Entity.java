package VideoGame.Charactes;

public class Entity {
    private String nome;
    private int forza;
    private int destrezza;
    private int costituzione;
    private int intelligenza;
    private int saggezza;
    private int carisma;
    private int puntiVita;
    public String messaggio;
    public String quest;


    public Entity(String nome, int fo, int dest, int cos, int inte, int sag, int car, int vita){
        this.nome = nome;
        this.forza = fo;
        this.destrezza = dest;
        this.costituzione = cos;
        this.intelligenza = inte;
        this.saggezza = sag;
        this.carisma = car;
        this.puntiVita = vita;
    }


    boolean possoAttaccare;
    public boolean possoAttaccare(Entity target){
        return target.getPuntiVita() > 0;
    }
    public void parla(){
        System.out.println(nome + " dice " + messaggio);
    }
    public void quest(){
        System.out.println(nome + " nuova quest " + quest);
    }



    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getForza(){
        return forza;
    }
    public void setForza(int f){
        this.forza = f;
    }
    public int getDestrezza(){
        return destrezza;
    }
    public void setDestrezza(int d){
        this.destrezza = d;
    }
    public int getCostituzione() {
        return costituzione;
    }
    public void setCostituzione(int c){
        this.costituzione = c;
    }
    public int getIntelligenza(){
        return intelligenza;
    }
    public void setIntelligenza(int i){
        this.intelligenza = i;
    }
    public int getSaggezza(){
        return saggezza;
    }
    public void setSaggezza(int s){
        this.saggezza = s;
    }
    public int getCarisma(){
        return carisma;
    }
    public void setCarisma(int c){
        this.carisma = c;
    }
    public int getPuntiVita(){
        return puntiVita;
    }
    public int setPuntiVita(int p){
        this.puntiVita = p;
        return p;
    }


}
