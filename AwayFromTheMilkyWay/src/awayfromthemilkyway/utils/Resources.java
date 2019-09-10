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
        
        pianetaTerra("/resources/images/pianetaTerra.jpg");
        
        private Image image = null;
        
        planets(String fileSrc){
            URL imgSrc = this.getClass().getResource(fileSrc);
            image = new Image(imgSrc.toString());
        }
        
        public Image getImage(){
            return this.image;
        }
        
      
    
    }// end enum planets
    
}
