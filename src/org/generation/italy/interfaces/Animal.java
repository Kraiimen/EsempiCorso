package org.generation.italy.interfaces;

public interface Animal {

    //METODI ASTRATTI
    void breathe();
    void eat();
    double getWeight();

    // Il seguente metodo implementa il design pattern template

    default void euthanize(){
        System.out.println("Faccio fuori l animaletto col gas,o con una puttanta di programmazione");
        double w = getWeight();
        if(w < 10){
            System.out.println(" Ti seppelisco nel giardino");
        }else {
            System.out.println("Facciamo un bel falò");
        }
    }
}
