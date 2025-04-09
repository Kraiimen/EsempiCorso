package org.generation.italy.edenGame.item;

public abstract class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract void use();

//    public void buy(Item i, int prezzo){
//        arrayoggeti.add(i);
//       money -= prezzo;
//    }
//
//    public void pick(Item i){
//        arrayoggeti.add(i);
//    }

}
