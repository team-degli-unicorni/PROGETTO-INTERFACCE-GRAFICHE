/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;


import awayfromthemilkyway.utils.Resources;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author giorg
 */
public class Universe extends Pane {
    private final ImageView galaxy;
    
    private Circle spaceship;
    private Circle planetEarth;
    private Circle planetJupiter;
    
    
    public Universe(){
        super();
        this.galaxy = new ImageView();
    }//end constructor of the class
    
    public void setGalaxyConfiguration(){//servirà a  configurare la galssia con tutti i suoi elementi quando il gioco comincia
        //Resources.SoundEffects.musica.play(); quando avrò la traccia musicale metterò il suo nome al posto di musica
        spaceship = new Circle(Configuration);
        
        planetEarth = new Circle();
        planetEarth.setFill(new ImagePattern(Resources.planets.pianetaTerra.getImage()));
        
        planetJupiter = new Circle();
        
        
        
        
    }//end method setGalaxyConfiguration
    
    
    
}// end class Universe
