package org.generation.italy.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Examples {
    public static void main(String[] args){
        ArrayList ar = new ArrayList<>();
        ar.add("Pippo");
        ar.add(new Random());
        ar.add(Integer.valueOf(3)); //L'array list fa il "BOXING" in automatico cambia da dato primitvo a oggetto.
        ArrayList<String> ss = new ArrayList<>();
        ss.add("Pippo");
        f1(ss);
        String z = ss.get(0);

        for(String x : ss){
            System.out.println(x);
        }
    }

    public static void f1(ArrayList a){
        a.add(new Random());
    }
}
