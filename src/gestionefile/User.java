/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionefile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author utente
 */
public class User implements Serializable {

    private String file;
    private String name;
    private String pass;

    public User(String file, String name, String pass) {
        this.file = file;
        this.name = name;
        this.pass = pass;
    }

    public void serializzazione() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(name + ";" + pass);
            System.out.println("Serializzazione=" + out);
        }
    }

    public void deserializzazione() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            try {
                Object userDeserializzato = in.readObject();
                System.out.println("Deserializzazione=" + userDeserializzato);
            } catch (ClassNotFoundException ex) {
                System.err.println("Problema nella deserializzazione");
            }
        }
    }
}
