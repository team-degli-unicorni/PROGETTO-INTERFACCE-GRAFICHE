/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.utils;

import java.net.URL;
import javafx.scene.image.Image;

/**
 *
 * @author giorg
 */
public class Resources {
    
    public enum planets{
        
        pianetaTerra("/resources/images/earth.png");
        
        private Image image = null;
   
        
        planets(String fileSrc){
            URL imgSrc = this.getClass().getResource(fileSrc);
            image = new Image(imgSrc.toString());
        }
        
        public Image getImage(){
            return this.image;
        }//end getImage method
    }//end enum planet
    public enum otherImages{
     
        nightsky("/resources/images/nightsky.jpg"),
        spaceship("/resources/images/spaceship.png"),
        exitmilkyway("/resources/images/exitmilkyway.jpg"),
        icon("/resources/images/icon.jpg");
        
        private Image image = null;
        
        otherImages(String fileSrc){
            URL imgSrc = this.getClass().getResource(fileSrc);
            image = new Image(imgSrc.toString());
        }//end otherImages enum
        
        public Image getImage(){
            return this.image;
        }//end getImage
    
    }//end enum otherImages
        
      
    
    }// end class Resources
    

