package gestionefile;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Giorgio Nucciarelli
 * @ 12/01/23
 */

public class Lettore extends Thread{
    String nomeFile;
    
    public Lettore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    /**
     * Legge il file senza tener conto del tipo di file
     * e lo mostra in output
     */
    public void leggi(){
        int i; 
        
            //1) apro il file
            //2) leggo carattere per carattere e lo stampo 
             try (BufferedInputStream in =
              new BufferedInputStream(
                 new FileInputStream(nomeFile))) {
            int b; 
                 while ((b=in.read()) != -1)
                System.out.print(b);//Sistemare e fare la conversione da int a string
            
            System.out.print("\n\r");
        } catch (IOException ex) {
            System.err.println("Errore in lettura!");
        }
    }
    

    @Override
    public void run(){
        leggi();
    }
}
