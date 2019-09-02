/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 **/
 
public class MenuGuiController implements Initializable {
    
    @FXML private Button nuovaPartita;
    @FXML private Button caricaPartita;
    @FXML private Button opzioniPartita;
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void nuovaPartitaButtonClicked(){
         
        View.getInstance().openGameWindow();
    }//end class nuovaPartitaButtonClicked
     
    public void caricaPartitaButtonClicked(){
        
        //View.getInstance().openOptionsWindow();
    
    }//end class caricaPartitaButtonClicked

    public void opzioniPartitaButtonClicked(){
        
        View.getInstance().openOptionsWindow();
    }
}//end class MenuGuiController
