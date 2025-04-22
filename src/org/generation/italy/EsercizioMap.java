package org.generation.italy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class EsercizioMap {
    public static Map<String, Integer> inventory = new HashMap<>();
    public static void main (String[] args){

        inventory.put("Mela", 50);
        inventory.put("Banana", 120);
        inventory.put("Arancia", 80);
        inventory.put("Kiwi", 150);

       // stampaInventario(inventory);

        aggiornainventario(inventory,"Banana", 100);

        stampaInventario(inventory);

        stampaConFiltro(inventory, quantita -> quantita >= 100);

    }
    public static void stampaInventario(Map<String, Integer> inventory) {
        inventory.forEach((prodotto, quantita) -> {
            System.out.println(prodotto + ": " + quantita);
        });
    }

    public static void aggiornainventario(Map<String, Integer> inventory,String prodotto, int nuovaQuantita){
        if(inventory.containsKey(prodotto)){
            inventory.put(prodotto, nuovaQuantita);
            System.out.println(prodotto + ": " + nuovaQuantita);
        } else{
            System.out.println("il prodotto" + prodotto + "non esiste nell inventario");
        }
    }

    public static void stampaConFiltro(Map<String, Integer>  inventory, Predicate<Integer> condizone){
        inventory.entrySet().stream().
                filter(entry -> condizone.test(entry.getValue())).
                forEach(entry -> System.out.println("Gli elementi nell'inventario magigori della condizione " + entry.getKey() + ":" + entry.getValue() ));
    }
}