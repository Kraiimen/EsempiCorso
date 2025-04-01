package org.generation.italy.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Examples {
    public static void main(String[] args) {
        ArrayList ar = new ArrayList(); // Array list non generics, contiene Objects
        ar.add("Pippo");
        ar.add(new Random());
        ar.add(3); // Boxing, conversione automatica da Object a integer, equivale a Integer.valueOf(3);
        //String s = ar.get(0); // Non puoi farlo almeno che non casti, perché Java non si fida
        String s = (String)ar.get(0); // cast esplicito
        ArrayList<String> ss = new ArrayList<>();
        ss.add("Pippo");
        String z = ss.get(0);
        for(String x : ss) {
            System.out.println(x);
        }

        Pair<String, Integer> psi = new Pair<>("Pippo", 12);
        System.out.println(psi.getSecond());
        String p = psi.getFirst();
        Pair<Integer, String> pis = new Pair<>(1239, "Pippo");
        Integer it = pis.getFirst();
        Pair<ArrayList<Integer>, HashMap<String, ArrayList<Integer>>> pairComplicated = new Pair<>(null, null); // Per complicare
    }

    public static void f1(ArrayList ar) {
        ar.add(new Random());
    }
}
