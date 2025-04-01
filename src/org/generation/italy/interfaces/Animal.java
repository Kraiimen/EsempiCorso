package org.generation.italy.interfaces;

public interface Animal {
    void breathe(); // abstract è sottinteso
    void eat();
    double getWeight(); // Il getWeight astratto mi obbliga a implementare nelle classi che lo implementano questo metodo, e di conseguenza una variabile weight

    // Il seguente metodo implementa il design pattern template
    default void euthanize() { // Metodo di default
        System.out.println("Faccio fuori l'animaletto col gas, o con una puttanata di programmazione");
        double w = getWeight(); // Potevo anche direttamente chiamare il metodo
        if (w < 10) {
            System.out.println("Ti seppellisco nel giardino");
        }
        else {
            System.out.println("Facciamo un bel falò");
        }
    }


}
