package org.generation.italy.generics;
//posso fare una classe generics ed estendere solo un fattore ad una classe, ed il secondo ad un altra
public class NumberPair<T extends Number, U extends Number> {
    private T first;
    private U second;
    public NumberPair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {return first;}

    public U getSecond() {return second;}
    public void setSecond(U second) {this.second = second;}
}


