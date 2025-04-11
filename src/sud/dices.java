package sud;

import java.util.Random;

public class dices {
    static private Random d4 = new Random();
    static private Random d6 = new Random();
    static private Random d8 = new Random();
    static private Random d10 = new Random();
    static private Random d12 = new Random();
    static private Random d20 = new Random();
    static private Random d100 = new Random();

    static public int rd100 (){return d100.nextInt(100)+1;}
    static public int rd20 (){return d20.nextInt(20)+1;}
    static public int rd12 (){return d12.nextInt(12)+1;}
    static public int rd10 (){return d10.nextInt(10)+1;}
    static public int rd8 (){return d8.nextInt(8)+1;}
    static public int rd6 (){return d6.nextInt(6)+1;}
    static public int rd4 (){return d4.nextInt(4)+1;}

    static public int roll (int faces){
        Random dice = new Random();
        return dice.nextInt(faces)+1;
    }
}
