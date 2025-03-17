import java.io.Console;
public class GiveMeQ {
    public static void main (String[] args){
        /* 
        il programma parte chiedendo un numero, poi te ne chiede un altro o Q per chiudere, continua così al infinito, 
        se premi Q, ti saluta e ti dice il numero più grande che tu gli abbia dato 
        */
        int Maxnum=0;
        int NumeroInt; // la variabile in cui verrà messo il numero dopo essere stato parseato
        String numero= ""; // la varibile in cui verrà preso il valore RAW della console
        Console console = System.console();
        while(!numero.equals("Q")){ // finchè il giocatore non inserirsce Q
            numero = console.readLine("Dammi un numero o dammi Q: "); // leggo il valore dalla console, nella prossima riga controllo se è Q
            if(!numero.equals("Q")){
            NumeroInt = Integer.parseInt(numero);
                if(NumeroInt > Maxnum){
                    Maxnum = NumeroInt;
                }
            }else if(numero.equals("Q")){
                System.out.println("Ok abbiamo terminato, il numero più alto che mi hai dato è: " + Maxnum);
            }
        }

    }
}
