package org.generation.italy.bankproject.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Examples {
    public static void main(String[] args){
        ArrayList ar = new ArrayList();
        ar.add("pippo");
        ar.add(new Random());
        ar.add(5);
       String s = (String)ar.get(0);
       ArrayList<String> ss = new ArrayList<>();
       f1(ss);
       Pair<String,Integer> psi = new Pair<>("Pippo",12);
       System.out.println(psi.getSecond());
       Pair<Integer,String> pis = new Pair<>(5,"Ciao");
       Pair<ArrayList<Integer>, HashMap<String,Integer>> pairComplicated = new Pair<>(null,null);
       Pair<Double,Integer> numbers = new Pair<>(3.14,12);
    }
    public static void f1(ArrayList ar){

    }
}
