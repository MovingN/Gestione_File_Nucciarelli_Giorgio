package gestionefile;

import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giorgio Nucciarelli
 * @ 01/02/24
 */
public class Lettore extends Thread {

    String nomeFile;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    /**
     * Legge il file senza tener conto del tipo di file e lo mostra in output
     *
     */
    @Override
    public void run() {
        try {
            leggi();
        } catch (IOException ex) {
            System.err.println("Errore con il run Lettore");
        }
    }

    public void leggi() throws IOException {
        StringBuilder testo = new StringBuilder();//Serve a concatenare i carattei che sono stati letti
        try (DataInputStream in = new DataInputStream(new FileInputStream(nomeFile))) {
            int lettura;
            while ((lettura = in.read()) != -1) {//legge 
                testo.append((char) lettura);//Converte da int a char e mette ogni singolo carattere uno dopo l'altro 
            }
        } catch (EOFException ex) {
            System.err.println("Errore con il leggi Lettore");
        }
    }
}
