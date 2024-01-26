package gestionefile;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giorgio Nucciarelli
 * @version 12/01/23
 */

public class Scrittore implements Runnable{

    String nomeFile;
    
    public Scrittore(String nomeFile){
        this.nomeFile = nomeFile;
    }
     public Scrittore(String nomeFile,String user,String psw){
        this.nomeFile = nomeFile;
        this.user = user;
        this.psw = psw;
    }
    
    @Override
    public void run() {
        scrivi();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi(){
        
        try ( BufferedWriter br=null; BufferedWriter br = new BufferedWriter(
                new FileWriter(nomeFile))){
            //1) apro il file
            //2) scrivo nel buffer
            br.write("File in output");
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }       
        }
      public void scriviPsw(String user, String psw){
        
        
        try ( BufferedWriter br=null; BufferedWriter br = new BufferedWriter(
                new FileWriter(nomeFile))){
            //2) scrivo nel buffer
            br.write(user + ";" + psw);
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }



  