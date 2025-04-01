package org.generation.italy.interfaces;

public interface Animal {
    void breathe();
    void eat();
    double getWeight(); //METODO ASTRATTO
    //IL SEGUENTE METODO IMPLEMENTA IL DESIGN PATTERN TEMPLATE
    default void euthanize(){//METODO DEFAULT, metodo concreto che ne chiama uno astratto
        System.out.println("Lo faccio fuori col gas o con una puttanata di programmazione");
        double w = getWeight();//POTEVO CHIAMARE getWeight anche senza dichiarare la variabile
            if(w < 10){
                System.out.println("Ti seppellisco");
            } else {
                System.out.println("Ti do fuoco");
            }


    }
}
