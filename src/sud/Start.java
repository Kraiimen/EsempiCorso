package sud;

import sud.entity.Entity;

import java.io.Console;


public class Start {
    public static void main(String[] args){

        try{
            Game.start();
            while (true){

                Game.interactMenu();
            }
        }catch (GameClosingExeption e){
            System.out.println(Entity.colorR+"THE GAME IS NOW CLOSING");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
