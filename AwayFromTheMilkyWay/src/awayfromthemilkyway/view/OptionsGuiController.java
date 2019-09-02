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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class OptionsGuiController implements Initializable {

    @FXML private ChoiceBox temaMusicale;
    @FXML private Button backToMenu;
    @FXML private Button istruzioni;
    @FXML private Slider Musica;
    @FXML private Slider EffettiSonori;
    @FXML private Slider Luminosità;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        temaMusicale.getItems().add("prima canzone");
        temaMusicale.getItems().add("seconda canzone");
        temaMusicale.getItems().add("terza canzone");
        temaMusicale.getItems().add("quarta canzone");
        temaMusicale.setValue("prima canzone");
    } 
    
    public void backToMenuButtonClicked(){
         View.getInstance().openMenuWindow();
    }//end method backToMenuButtonClicked
    
    public void istruzioniButtonCliked(){
         View.getInstance().openInstructionsWindow();
    }// end method istruzioniButtonCliked
    
}
