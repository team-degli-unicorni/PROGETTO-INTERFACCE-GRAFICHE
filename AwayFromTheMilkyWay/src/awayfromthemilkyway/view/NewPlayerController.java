/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author giorg
 */
public class NewPlayerController implements Initializable {

    @FXML private TextField playerName;
    @FXML private Button confirmData;
    @FXML private Button back;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void confirmButtonClicked(){
    
        String name = this.playerName.getText();
        try
        {
            if(!name.equals(""))
            {
                ControllerForView.getInstance().createNewGameProfile(name);
                View.getInstance().openLoadProfileWindow();
            }
            
        }catch(IOException ioe)
        {
            Alert abortMessage = new Alert(Alert.AlertType.ERROR);
            abortMessage.setTitle("Errore Irreversibile");
            abortMessage.setHeaderText("Si Ã¨ verificato un errore!");
            abortMessage.setContentText("Impossibile settare il file dei salvataggi! Il programma verrÃ  arrestato.");
            abortMessage.showAndWait();
            System.exit(1);
        }
        
    }//end method confirmButtonClicked
    
    public void backToMenuButtonClicked(){
        View.getInstance().openOptionsWindow();
    }
}
