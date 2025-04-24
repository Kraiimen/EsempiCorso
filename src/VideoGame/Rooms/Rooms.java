package VideoGame.Rooms;

import java.util.HashMap;

public class Rooms {
    private String nome;
    private String nord;
    private String est;
    private String ovest;
    private String sud;
    private HashMap<String, Rooms> collegamenti;


    public Rooms(String no, String nor, String e, String o, String s){
        this.nome = o;
        this.nord = nor;
        this.est = e;
        this.ovest = o;
        this.sud = s;
        this.collegamenti = collegamenti;

    }


    public String getNord() {
        return nord;
    }
    public String getEst() {
        return est;
    }
    public String getOvest() {
        return ovest;
    }
    public String getSud() {
        return sud;
    }
    public String getNome() {
        return nome;
    }
    public void setNord(String nord) {
        this.nord = nord;
    }
    public void setEst(String est) {
        this.est = est;
    }
    public void setOvest(String ovest) {
        this.ovest = ovest;
    }
    public void setSud(String sud) {
        this.sud = sud;
    }
    public void setNome(String name) {
        this.nome = nome;
    }
}
