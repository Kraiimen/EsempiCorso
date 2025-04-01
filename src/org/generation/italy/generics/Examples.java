package org.generation.italy.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Examples {
    public static void main(String[] args) {
        ArrayList ar = new ArrayList();
        ar.add("Pippo");
        ar.add(new Random());
        ar.add(Integer.valueOf(3));
        ArrayList<String> ss = new ArrayList<>();
        ss.add("Pippo");
        String z = ss.get(0);
        for(String x : ss) {
            System.out.println(x);
        }
        Pair<String, Integer> psi = new Pair<>("Pippo", 12); //posso decidere che come prima variabile in <> ci va bollean, char, Styring, int ecc ecc
        System.out.println(psi.getSecond());
        String p = psi.getFirst();
        Pair<ArrayList<Integer>, HashMap<String, ArrayList<Integer>>> pairComplicated = new Pair<>(null, null); //le HashMap sono delle coppie chiave-valore, hanno solo le Stringhe e gli Integer
        NumberPair<Double, Integer> pdi = new NumberPair<>(3.14, 20);
    }

    public static void f1(ArrayList ar) {

    }

}

