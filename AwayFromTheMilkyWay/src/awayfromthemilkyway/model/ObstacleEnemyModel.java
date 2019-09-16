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
public class ObstacleEnemyModel extends Circle {
    
    private boolean collision;
    private int spaceshipLife;
  
    public ObstacleEnemyModel(double centerX, double centerY, double radius){
        
        super(centerX, centerY, radius);
        
    }//end constructor
    
    //getCenterX
    
    //getCenterY
    
    public int deadEnemyCollision(){
        
        if(collision)
             spaceshipLife = 0;
        
        return spaceshipLife; 
    
    }//end method deadEnemyCollision
    
    
}
