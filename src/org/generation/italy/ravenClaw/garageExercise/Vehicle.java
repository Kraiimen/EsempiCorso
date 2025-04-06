package org.generation.italy.ravenClaw.garageExercise;

public interface Vehicle {


   default void startEngine(){
        System.out.println("The engine starts");
   }

   default void turnOffEngine(){
       System.out.println("The engine shuts off");
   }
}
