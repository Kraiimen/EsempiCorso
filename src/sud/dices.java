package sud;

import java.util.Random;

public class dices {
    static private Random d4 = new Random(4);
    static private Random d6 = new Random(6);
    static private Random d8 = new Random(8);
    static private Random d10 = new Random(10);
    static private Random d12 = new Random(12);
    static private Random d20 = new Random(20);
    static private Random d100 = new Random(100);

    static public int rd100 (){return d100.nextInt()+1;}
    static public int rd20 (){return d20.nextInt()+1;}
    static public int rd12 (){return d12.nextInt()+1;}
    static public int rd10 (){return d10.nextInt()+1;}
    static public int rd8 (){return d8.nextInt()+1;}
    static public int rd6 (){return d6.nextInt()+1;}
    static public int rd4 (){return d4.nextInt()+1;}

    static public int roll (int faces){
        Random dice = new Random();
        return dice.nextInt(faces)+1;
    }

    static public Random getd4 (){
        return new Random(4);
    }
    static public Random getd6 (){
        return new Random(6);
    }
    static public Random getd8 (){
        return new Random(8);
    }
    static public Random getd10 (){
        return new Random(10);
    }
    static public Random getd12 (){
        return new Random(12);
    }
    static public Random getd20 (){
        return new Random(20);
    }
}
