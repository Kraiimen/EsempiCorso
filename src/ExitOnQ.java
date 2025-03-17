import java.io.Console;
// il programma finche ti chiede continuamente di inserire un numero o se volessi terminare inserisci la string q
// Quando inserisci la stringa q il programma termina stampando il valore massimo
// Se l utente dicesse q come prima risposta il programma terminerà stampando la string "non hai inserito nessun numero"


// stiamo dichiarando la classe che è pubblica (visibile a tutti) e rinominata FindBigger
public class ExitOnQ {

// stiamo dichiarando un metodo (Main) che viene avviato automaticamente all'inzio del p
    public static void main (String[] args){

    // variabiale c di tipo Console , e gli sto dando come valore l'oggetto di tipo console
        Console c = System.console();
        int max = 0;
        String input = ""; //stringa Vuota
        boolean numeroInserito = false;

        do{ 
            System.out.println("Inserisci un numero");
            input = c.readLine(); // il programma comincia a leggere quello che verra scritto nella console inseriamo es."10"
            
            if(!(input.equals("q"))){ // questa condzione legge prima quella nella parentesi se è q, se non è vea legge il ! e va nell if di sotto!
                int n = Integer.parseInt(input); //conversione della stringa in numero int 
                if(n > max){ 
                    max = n;
                }
                numeroInserito = true;
            }

        } while(!input.equals("q"));
        if(numeroInserito == false){
            System.out.println("Non hai inserito nessun numero"); 
        }else {
            System.out.print(max); 
        }

    

    } 


}
        
