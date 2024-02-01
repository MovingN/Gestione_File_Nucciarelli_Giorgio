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
        
        scrittore.scriviPsw(username, passkey);
         try ( DataInputStream in = new
            BufferedInputStream(new FileInputStream(inFile))) { //legge 
            while(true){
                String b;
                b=in.readUTF();
                System.out.print(b);
                System.out.print("\n\r");
         }
         }catch (EOFException  ex) {
            System.err.println("Errore in!");
        }
       try (DataOutputStream out =
              new DataOutputStream(
                 new BufferedOutputStream(
                    new FileOutputStream(outFile)))) {
           // non so come fare copiare il file utilizzando il dataOutputStream
           out.flush();
        }
          catch (EOFException  e) {
            System.err.println("Errore out!");
        }
    }
}
    
    

