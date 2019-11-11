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
public class ReadCSV {
    public static LinkedList<String[]> getRows(String fileName, String charset) throws FileNotFoundException, IOException 
    {
        LinkedList<String[]> lstRows = null;

        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(fileName), charset));

            lstRows = new LinkedList<String[]>();
            String s = null;

            while ((s = buffRead.readLine()) != null)
                if (!s.isEmpty() && s.contains(";"))
                    lstRows.add(s.trim().split(";"));
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
