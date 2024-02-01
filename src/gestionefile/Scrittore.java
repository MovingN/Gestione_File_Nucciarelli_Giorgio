package gestionefile;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giorgio Nucciarelli
 * @version 01/02/24
 */

public class Scrittore implements Runnable{

    String nomeFile;
    String user;
    String psw;
    
    public Scrittore(String nomeFile){
        this.nomeFile = nomeFile;
    }
     public Scrittore(String nomeFile , String us , String psw){
        this.nomeFile = nomeFile;
        this.user = user;
        this.psw = psw;
    }
    
    @Override
    public void run() {
        scrivi();
    }
    /**
     * 
     */
    public void scrivi(){
        
        try  (DataOutputStream out =
              new DataOutputStream(
                 new BufferedOutputStream(
                    new FileOutputStream(nomeFile)))) {
            //1) apro il file
            //2) scrivo nel buffer
            out.writeUTF("File in output");
            out.writeUTF("\n\r");
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }       
        }
      public void scriviPsw(String user, String psw){
        
        try ( DataOutputStream out1 =
              new DataOutputStream(
                 new BufferedOutputStream(
                    new FileOutputStream(nomeFile)))){
            //2) scrivo nel buffer
            out1.writeUTF(user + ";" + psw);
            out1.writeUTF("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            out1.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }



  