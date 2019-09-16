/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author giorg
 */
public class Configuration {
    //STATIC FIELDS
    private static Configuration configuration = null;

    //INSTANCE FIELDS
    private Properties properties;
    
    private Configuration() {//serve a leggere i file di testo dei livelli 
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(
                new InputStreamReader(
                    this.getClass().getResourceAsStream("/resources/configuration/Level1.txt"),"ISO-8859-1"));
            
            this.properties = new Properties();
            this.properties.load(buffRead);
        }
        catch(FileNotFoundException fnfe) {//penso che qui questi catch degli errori non servono perchè assegnamo noi il file che deve essere letto(level 1),quindi siamo sicuri che cisia
            
           /* JOptionPane.showMessageDialog(null,
                        "Configuration file not found, the program will be closed.",
                        "Serious ERROR",
                        JOptionPane.ERROR_MESSAGE);
            System.exit(-1);*/

        }
        catch(IOException ioe) {
            
           /* JOptionPane.showMessageDialog(null,
                        "Unable to read the configuration file, the program will be closed.",
                        "Serious ERROR",
                        JOptionPane.ERROR_MESSAGE);
            System.exit(-1);*/

        }
        finally {
            try {
                if (buffRead != null)
                    buffRead.close();
            }
            catch(IOException ioe) {
            }
        } // end finally
    } // end constructor
    
     public void changeConfigurationFile(String path)//serve a leggere le proprietà dei livelli successivi all'1
    {
        
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(
                new InputStreamReader(
                    this.getClass().getResourceAsStream(path),"ISO-8859-1"));
            
            this.properties = new Properties();
            this.properties.load(buffRead);
        }
        catch(FileNotFoundException fnfe) {
            
            JOptionPane.showMessageDialog(null,
                        "Configuration file not found, the program will be closed. "+this.getConfigurationFileFullPath(path),
                        "Serious ERROR",
                        JOptionPane.ERROR_MESSAGE);
            System.exit(-1);

        }
        catch(IOException ioe) {
            
            JOptionPane.showMessageDialog(null,
                        "Unable to read the configuration file, the program will be closed.",
                        "Serious ERROR",
                        JOptionPane.ERROR_MESSAGE);
            System.exit(-1);

        }
        finally {
            try {
                if (buffRead != null)
                    buffRead.close();
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
        } // end finally
        
    }//end method changeConfigurationFile
     private String getConfigurationFileFullPath(String path) {
        String fileName = Configuration.class.getResource(path).toString();
        
        if (fileName.contains("//"))
            fileName = fileName.substring("file:/".length()); //Windows version - in pratica attraverso questo metodo prendo una substring che parte da dopo file:/, in quanto il metodo substring vuole come parametro un int, e il . lenght restituisce un int pari alla lunghezza della  stringa su cui è invocato
        else if (fileName.contains("/"))
            fileName = fileName.substring("file:/".length()); //Linux version
        fileName = fileName.replaceAll("%20", " ");// replaceAll sostituisce la scrittura 20% con uno spazio vuoto,debo ancora capire a che seerve
        return fileName;
    }//end getCongfigurationFileFullPath

    //INSTANCE
    public double getStartPositionSpaceshipX(){
        return Double.parseDouble(this.properties.getProperty("StartPositionSpaceshipX"));//parse double serve a trasformare la stringa che otteniamo dentro le parentsei in un double
    }//end method getStartPositionSpaceshipX
    
    
    public double getStartPositionSpaceshipY(){
        return Double.parseDouble(this.properties.getProperty("StartPositionSpaceshipY"));
    }//end method getStartPositionSpaceshipY
    
    
    public double getSpaceshipRadius(){
        return Double.parseDouble(this.properties.getProperty("SpaceshipRadius"));
    }//end method getStarshipRadius
    
     
    public double getEarthPositionX(){
        return Double.parseDouble(this.properties.getProperty("EarthPositionX"));
    }//end method getEarthPositionX
    
      
    public double getEarthPositionY(){
        return Double.parseDouble(this.properties.getProperty("EarthPositionY"));
    }//end method getEarthPositionY
    
       
    public double getEarthRadius(){
        return Double.parseDouble(this.properties.getProperty("EarthRadius"));
    }//end method getEarthRadius
    
    
    public double getExitMilkyWayPositionX(){
        return Double.parseDouble(this.properties.getProperty("ExitMilkyWayPositionX"));
    }//end method getEarthPositionX
    
    
    public double getExitMilkyWayPositionY(){
        return Double.parseDouble(this.properties.getProperty("ExitMilkyWayPositionY"));
    }//end method getEarthPositionX
    
    
    public double getExitMilkyWayRadius(){
        return Double.parseDouble(this.properties.getProperty("ExitMilkyWayRadius"));
    }//end method getEarthPositionX
       
       
    //STATIC 
     public static Configuration getInstance() {
        if (configuration == null)
            configuration = new Configuration();
        return configuration;
    }
}//end class
