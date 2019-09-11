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
public class ObstacleCollisionModel extends Circle {
    
    private boolean collision;
  
    public ObstacleCollisionModel(double centerX, double centerY, double radius){
        
        super(centerX, centerY, radius);
        
    }//end constructor
    
    //getCenterX
    
    //getCenterY
    
    public boolean getCollision(){
        return collision;
    
    }//end method getCollision
    
}
