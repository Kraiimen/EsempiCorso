package org.generation.italy.bankproject.generics;

public class Pair<T,U> {
    private T first;
    private U second;
    public Pair(T first, U second){
        this.first = first;
        this.second = second;
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
