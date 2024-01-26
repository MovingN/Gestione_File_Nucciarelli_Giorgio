package gestionefile;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Giorgio Nucciarelli
 * @version 12/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner m = new Scanner(System.in); 
        File inFile = new File("output.csv");
        File outFile = new File("copia.csv");
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        System.out.println("Scelga il suo username");
        String username = m.nextLine();
        System.out.println("Crei una password");
        String passkey = m.nextLine();
        lettore.start();
        
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv",username,passkey);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        scrittore.scriviPsw();
        FileInputStream inputStream = new FileInputStream(inFile);
        FileOutputStream outputStream = new FileOutputStream(outFile);
        byte[] buffer = new byte[1024];
        int bytesLetti;
        while ((bytesLetti = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesLetti);
        }
        inputStream.close();
        outputStream.close();
    }
    
}
