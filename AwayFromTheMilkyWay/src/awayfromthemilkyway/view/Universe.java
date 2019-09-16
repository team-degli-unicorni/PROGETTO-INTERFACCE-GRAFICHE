/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;


import awayfromthemilkyway.utils.Configuration;
import awayfromthemilkyway.utils.Resources;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public class Universe extends Group {
    private final ImageView galaxyImg;
    
    private Circle spaceship;
    private Circle planetEarth;
    private Circle exitMilkyWay;
    
    
    public Universe(){
        super();
        this.galaxyImg = new ImageView();
    }//end constructor of the class
    
    public void setGalaxyConfiguration(){//servirà a  configurare la galssia con tutti i suoi elementi quando il gioco comincia PROBLEMA:questo apparirà ad ogni singolo inizio di gioco ma noi non abbiamo elementi fissi da mantenere ad ogni inizio di gioco in quanto ogni voolta gli elementi cambiano di posizione...come fare?
        //Resources.SoundEffects.musica.play(); quando avrò la traccia musicale metterò il suo nome al posto di musica
        spaceship = new Circle(Configuration.getInstance().getStartPositionSpaceshipX(),//CONSTATATO CHE IL PROBLEMA STA NEI METODI CHE DEVONO LEGGERE DAI FILE DI TESTO
                               Configuration.getInstance().getStartPositionSpaceshipY(),
                               Configuration.getInstance().getSpaceshipRadius());
           
       
        spaceship.setFill(new ImagePattern(Resources.otherImages.spaceship.getImage()));//IL PROBLEMA NON è NEI METODI CHE CARICANO LE IMMAGINI
        
        planetEarth = new Circle(Configuration.getInstance().getEarthPositionX(),
                                 Configuration.getInstance().getEarthPositionY(),
                                 Configuration.getInstance().getEarthRadius()  );
          
        planetEarth.setFill(new ImagePattern(Resources.planets.pianetaTerra.getImage()));
        
        /*exitMilkyWay = new Circle(Configuration.getInstance().getExitMilkyWayPositionX(),
                                  Configuration.getInstance().getExitMilkyWayPositionY(),
                                  Configuration.getInstance().getExitMilkyWayRadius());
        exitMilkyWay.setFill(new ImagePattern(Resources.otherImages.exitmilkyway.getImage()));*/
        
       
        
        galaxyImg.setImage(Resources.otherImages.nightsky.getImage());
        
        this.getChildren().add(galaxyImg);
        this.getChildren().add(planetEarth);
        this.getChildren().add(spaceship);
           
    }//end method setGalaxyConfiguration
    
    
    public Circle getSpaceship(){
        return this.spaceship;
    }//end method getSpaceship
    
    public Circle getExitMilkyWay(){
        return this.exitMilkyWay;
    }//end method getExitMilkyWay
    
}// end class Universe
