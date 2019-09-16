/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

/**
 *
 * @author giorg
 */
public class LevelDataPane extends GridPane {
    
    private final static int BUTTON_WIDTH = 200;
    private final static int BUTTON_HEIGHT = 25;
    
    private final Label playerNameDec ;
    private final Label playerBouncesNumberDec;
    private final Label numberOfLevelDec;
    private final Label desiredBouncesDec;
    private final Label launchPowerDec;
    
    
    private final Label playerName;
    private final Label playerBouncesNumber;
    private final Label numberOfLevel;
    private final Label desiredBounces;
    
    private final ProgressBar launchPower;
    private final Button options;
    
    public LevelDataPane(){
        super();
        this.playerNameDec = new Label("Giocatore: ");
        this.playerBouncesNumberDec = new Label("Rimbalzi effettuati: ");
        this.desiredBouncesDec = new Label("Rimbalzi richiesti: ");
        this.numberOfLevelDec = new Label("Livello numero: ");
        this.launchPowerDec = new Label("Potenza del lancio: ");
        
        this.launchPower = new ProgressBar();
        this.launchPower.setProgress(0);
        
        this.playerName = new Label(/*da implementare una volta scritto il CONTROLLER FOR VIEW*/);
        this.numberOfLevel = new Label(/*da implementare una volta scritto il CONTROLLER FOR VIEW*/);
        this.playerBouncesNumber = new Label(/*da implementare una volta scritto il CONTROLLER FOR VIEW*/);
        this.desiredBounces = new Label(/*da implementare una volta scritto il CONTROLLER FOR VIEW*/);
        
        this.options = new Button("OPZIONI");
        
        options.setOnAction((ActionEvent ae) -> {
            View.getInstance().openOptionsWindow();
            
            
        this.add(playerNameDec,0,0);
        this.add(playerName,1,0);
        
        this.add(launchPowerDec,0,1);
        this.add(launchPower,1,1);
        
        this.add(desiredBouncesDec,2,0);
        this.add(desiredBounces,3,0);
        
        this.add(playerBouncesNumberDec,4,1);
        this.add(playerBouncesNumber,5,1);
        
        this.add(numberOfLevelDec,6,0);
        this.add(numberOfLevel,7,0);
        
        this.add(options,6,1);
        });
    
        
        
        
    }//end constructor of the class
    
    
    
    
    
    
}//end class LevelDataPane
