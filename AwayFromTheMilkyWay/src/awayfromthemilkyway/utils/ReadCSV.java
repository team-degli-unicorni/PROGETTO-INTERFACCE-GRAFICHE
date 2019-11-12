/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 *
 * @author giorg
 */


//Una LinkedList è una lista implementata mediante una rappresentazione doppiamente collegata. 
//(È una implementazione parziale dell'interfaccia java.util.List.) Ciascun elemento della lista 
//è gestito mediante un oggetto Entry, che referenzia l'elemento della lista, nonché riferimenti
//(agli Entry associati) agli elementi predecessore e successore. L'inserimento (cancellazione) 
//di un elemento nella (dalla) lista comporta l'inserimento (cancellazione) di un oggetto Entry che lo rappresenta.
public class ReadCSV {//il metodo getRows serve a leggere la stringa filename e ritorna una linked list
    public static LinkedList<String[]> getRows(String fileName, String charset) throws FileNotFoundException, IOException 
    {
        LinkedList<String[]> lstRows = null;//inizializzo la lista 1stRows

        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(//creo un bufer di lettura
                new InputStreamReader(//creo un reader di lettura che leggerà il "filename" messo all'interno dell'inputStream
                    new FileInputStream(fileName), charset));

            lstRows = new LinkedList<String[]>();//assegno alla lista chiamata 1stRows una nuova lista di stringhe
            String s = null;//inizializzo la stringa s

            while ((s = buffRead.readLine()) != null)//quando s che è uguale al contenuto del buffer, è a sua volta diverso da null
                if (!s.isEmpty() && s.contains(";")) //e se s contiene il ";" e  
                    lstRows.add(s.trim().split(";"));//allora si aggiunge il contenuto del buffer alla linked list
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            if (buffRead != null)
                buffRead.close();
        }

        return lstRows;
    }
}
