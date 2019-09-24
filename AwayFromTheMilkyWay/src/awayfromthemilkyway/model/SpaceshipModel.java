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
public class SpaceshipModel extends Circle {
    
    private int spaceshipLife;
    private boolean collision;
    private int nBounces = 0;
    private double speed;
    
    public SpaceshipModel(double centerX, double centerY, double radius, int spaceshipLife) {
        
        super(centerX, centerY, radius);
        this.spaceshipLife = spaceshipLife;
        
    }//end constructor
    
    //getCenterX
    
    //getCenterY

    public int deadEnemyCollision() {
        
        if(collision)
             spaceshipLife = 0;
        
        return spaceshipLife; 
    
    }//end method deadEnemyCollision
    
     public boolean getCollision() {
        return collision;
    
    }//end method getCollision
     
    public int counterCollision() {
        
        if(this.getCollision())
            nBounces = nBounces + 1;
        
        return nBounces;
        
    }//end method counterCollision
    
    public int deadBounces(int desiredBounces) { 
        
        if(nBounces<desiredBounces)
             spaceshipLife = 0;
        
        return spaceshipLife; 
    
    }//end method deadBounces
    
    public int deadSpeed() {
        
        if(speed==0.0)          
            spaceshipLife = 0;
        
        return spaceshipLife;  
    
    }//end method deadSpeed
    
    public int deadPosition() {
        
        if(this.getCenterX()+ this.getRadius()>1200.0 || this.getCenterY()+ this.getRadius()>800.0) 
            spaceshipLife = 0;
        
        return spaceshipLife;
    
    }//end method deadPosition ma riscritto anche sul model, valutare quale scegliere
}
