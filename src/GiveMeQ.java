import java.io.Console;
public class GiveMeQ {
    public static void main (String[] args){
        //  il programma parte chiedendo un numero, poi te ne chiede un altro o Q per chiudere, continua così al infinito, 
        // se premi Q, ti saluta e ti dice il numero più grande che tu gli abbia dato
        int Maxnum=0;
        int NumeroInt;
        String numero= "";
        while(!numero.equals("Q")){
            System.out.println("Dammi un numero");
            Console console = System.console();
            numero = console.readLine();
            if(!numero.equals("Q")){
            NumeroInt = Integer.parseInt(numero);
                if(NumeroInt > Maxnum){
                    Maxnum = NumeroInt;
                }
            }else{
                System.out.println("Ok abbiamo terminato, il numero più alto che mi hai dato è: " + Maxnum);
            }
        }

    }
}
