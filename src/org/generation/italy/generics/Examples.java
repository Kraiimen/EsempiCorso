package org.generation.italy.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Examples {
    public static void main(String[] args) {
        ArrayList ar = new ArrayList<>();//Tratta solo gli oggetti
        ar.add("Pippo");
        ar.add(new Random());
        ar.add(Integer.valueOf(3));//BOXING Conversione da int a Integer (o Double, altra classe wrapper)
        String s = (String) ar.get(0); //Downcast
        //RUNTIME: include tutto ciò che è necessario affinché il codice Java compilato, possa essere interpretato ed eseguito dalla JVM
        ArrayList<String> ss = new ArrayList<>();
        ss.add("Pluto");
        String z = ss.get(0);
        for (String x : ss) {
            System.out.println(x);
        }
        Pair<String, Integer> psi = new Pair<>("Pippo", 12);
        System.out.println(psi.getSecond());
        String p = psi.getFirst();
        Pair<Integer, String> ps = new Pair<>(12, "Pippo");
        Integer it = ps.getFirst();
        Pair< ArrayList<Integer>, HashMap <String, ArrayList <Integer> > > pairComplicated = new Pair<>(null, null);//HashMap: strutture dati o dizionari.
        NumberPair<Double, Integer> pdi = new NumberPair<>(3.14, 20);
    }

    public static void f1(Arraylist ar) {
        ar.add(new Random());


    }
}
