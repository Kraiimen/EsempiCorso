package org.generation.italy.concessionaria;
import java.util.ArrayList;

public class Concessionaria {

        private ArrayList<Veicolo> veicoli;

        public Concessionaria() {
            veicoli = new ArrayList<>();
        }

        public void aggiungiVeicolo(Veicolo veicolo) {
            veicoli.add(veicolo);
            System.out.println(veicolo + " è stato aggiunto alla concessionaria.");
        }

        public int getNumeroVeicoli() {
            return veicoli.size();
        }

        public void stampaVeicoli() {
            for (Veicolo v : veicoli) {
                System.out.println(v);
            }
        }
}
