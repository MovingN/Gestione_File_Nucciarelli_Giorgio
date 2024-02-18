package gestionefile;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Giorgio Nucciarelli
 * @version 01/02/24
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner m = new Scanner(System.in);
        File inFile = new File("output.csv");
        File outFile = new File("copia.csv");
        File use = new File("user.ser");
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        System.out.println("Scelga il suo username");
        String username = m.nextLine();
        System.out.println("Crei una password");
        String passkey = m.nextLine();
        lettore.start();

        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username, passkey);
        Thread threadScrittore = new Thread(scrittore);
        scrittore.scriviPsw(username, passkey);
        threadScrittore.start();
        try (DataInputStream in = new DataInputStream(new FileInputStream(inFile)); DataOutputStream out = new DataOutputStream(new FileOutputStream(outFile))) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();//dalla riga 35 alla 45 abbiamo la copia del file da output.csv a copia.csv
        } catch (EOFException e) {
            System.err.println("Errore in copia del file!");
        }
        
        // Punto 4 Serializzazione
        User user= new User ("user.ser",username, passkey);
        user.serializzazione();
        user.deserializzazione();
        
    }
}
