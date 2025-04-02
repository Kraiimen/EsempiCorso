package org.generation.italy.bankProject.generics;

public class NumberPair<T extends Number,U extends Number>{
    private T first;
    private U second;

    public NumberPair(T first, U second) {
        this.first = first;
        this.second = second;
    }


    public double getSum() {
        return first.doubleValue() + second.doubleValue();
    }
    public T getFirst(){
        return first;
    }
    public U getSecond(){
        return second;
    }
    public void setSecond(U second){
        this.second = second;
    }
}
