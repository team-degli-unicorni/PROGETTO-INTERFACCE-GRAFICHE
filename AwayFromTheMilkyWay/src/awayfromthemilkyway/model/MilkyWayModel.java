/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.model;

import javafx.scene.shape.Circle;

/**
 *
 * @author Stefania
 */
public class MilkyWayModel extends Circle {
    
     private boolean win;
    
     public MilkyWayModel(double centerX, double centerY, double radius){
        
        super(centerX, centerY, radius);
        
    }//end constructor
    
    //getCenterX
    
    //getCenterY
    
     public boolean getCenter(){
        return win;
    
    }//end method getCenter
}
