package VideoGame.Charactes;

import VideoGame.Inventario.Oggetti;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Entity {

    private int esperienza = 0;
    private int puntiAbilita = 0;
    private int[] soglieLivello = {100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200};
    private int livello = 1;
    private ArrayList<Oggetti> inventario = new ArrayList<>();

    public Player(String nome, int fo, int dest, int cos, int inte, int sag, int car, int vita) {
        super(nome, fo, dest, cos, inte, sag, car, vita);

    }

    public void guadagnaEsperienza(int esperienza) {
        this.esperienza += esperienza;
        for (int i = livello - 1; i < soglieLivello.length; i++) {
            if (this.esperienza >= soglieLivello[i]) {
                this.esperienza -= soglieLivello[i];
                livello++;
                livelli();
                System.out.println(getNome() + " ha raggiunto il livello " + livello + "!");
            } else {
                break; // appena non raggiunge la soglia, esce
            }

        }
    }

    public int dannoSubito(int puntiVita) {
        Random dice = new Random();
        puntiVita = puntiVita - dice.nextInt(1, 4);
        return setPuntiVita(puntiVita);
    }

    public int recuperovita(int puntiVita) {
        Random dice = new Random();
        puntiVita = puntiVita + 3;
        return setPuntiVita(puntiVita);
    }

    public void livelli() {
        puntiAbilita++;
        System.out.println(getNome() + " nuovo livello raggiunto , hai sbloccato un punto abilita");

    }
    public void aggiungiOggetto(Oggetti o) {
        inventario.add(o);
    }
    public void rimuoviOggetto(Oggetti o) {
        inventario.remove(o);
    }
    public void mostraInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Il tuo inventario è vuoto.");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                Oggetti o = inventario.get(i);
                System.out.println(o.toString());
            }
        }
    }

    public int getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(int esperienza) {
        this.esperienza = esperienza;
    }

}

