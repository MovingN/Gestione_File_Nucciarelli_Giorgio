package gestionefile;
import java.io.*;
import java.io.IOException;

/**
 *
 * @author Giorgio Nucciarelli
 * @ 01/02/24
 */

public class Lettore extends Thread{
    String nomeFile;
    
    public Lettore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    /**
     * Legge il file senza tener conto del tipo di file
     * e lo mostra in output
     * @throws java.io.IOException
     */
    public void leggi() throws IOException{        
            //1) apro il file
            //2) leggo carattere per carattere e lo stampo 
             try (DataInputStream in = new
            BufferedInputStream(new FileInputStream(nomeFile))) { //legge 
            while(true){
                String b;
                b=in.readUTF();
                System.out.print(b);
                System.out.print("\n\r");
            }
             } catch (EOFException  ex) {
            System.err.println("Errore in!");
        }
}
}
