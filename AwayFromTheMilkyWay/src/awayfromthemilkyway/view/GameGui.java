/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class GameGui extends Stage {
    
    
    private Universe universe = null;
    private AnchorPane layout;
    
    
    public GameGui(){
        super();
        universe = new Universe();
        
        layout = new AnchorPane();
        layout.getChildren().add(universe);
        
        
        Scene gameScene = new Scene(layout,1280,720);
        
        
        
        
        
        
        this.setScene(gameScene);
        this.setTitle("Away From The Milky Way - Java Edition");
        this.setResizable(false);//impedisce all'utente di resizare la finestra
    }//end contructor GameGui
    
    
    public Universe getUniverse(){
        return this.universe;
    }//end method getUniverse
    
}// end class GameGui
