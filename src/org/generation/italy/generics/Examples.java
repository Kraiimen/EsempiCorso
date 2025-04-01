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
        String s = (String)ar.get(0);
        ArrayList<String> ss = new ArrayList<>();
        ss.add("Pippo");
        String z = ss.get(0);
        for(String x: ss) {
            System.out.println(x);
        }
        Pair<String,Integer> psi = new Pair<>("Pippo" , 12);
        System.out.println(psi.getSecond());
        String p = psi.getFirst();
        Pair<Integer,String> pis = new Pair<>(12, "Pippo");
        Integer it = pis.getFirst();
        Pair< ArrayList<Integer>, HashMap<String,ArrayList<Integer>>> pairComplicated = new Pair<>(null, null);
        NumberPair<Double,Integer> pdi = new NumberPair<>(3.14, 20);
        //NumberPair<String,Integer> pwrong = new NumberPair<>("Pippo", 20);

    }
    public static void f1(ArrayList ar) {
        ar.add(new Random());
    }
}
