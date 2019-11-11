/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class GameGui extends Stage {
    
    private LevelDataPane levelPane;
   
    private Universe universe = null;
    private BorderPane layout;
    
    
    public GameGui(){
        super();
        universe = new Universe();
        levelPane = new LevelDataPane();
        levelPane.setPrefSize(1200,200);
        levelPane.setMinSize(1200, 50);
        
        
        layout = new BorderPane();
        layout.setCenter(universe);
        layout.setBottom(levelPane);
        layout.setLeft(null);
        layout.setRight(null);
        layout.setTop(null);
        
        
        Scene gameScene = new Scene(layout,1280,800);
        
        
        
        
        
        
        this.setScene(gameScene);
        this.setTitle("Away From The Milky Way - Java Edition");
        this.setResizable(false);//impedisce all'utente di resizare la finestra
    }//end contructor GameGui
    
    
    public Universe getUniverse(){
        return this.universe;
    }//end method getUniverse
    
}// end class GameGui
