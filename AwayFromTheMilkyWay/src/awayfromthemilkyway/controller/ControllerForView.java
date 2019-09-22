/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.controller;

import awayfromthemilkyway.view.View;
import javafx.animation.AnimationTimer;

/**
 *
 * @author giorg
 */
public class ControllerForView implements IControllerForView {
        
    
    //methods to make view and model in comunication
    
    
    public double getXStartPosition(){
        return Model.getInstance().getSpaceShipXStartPosition();
    }//end method getXStartPosition
    
    public double getYStartPosition(){
        return Model.getInstance().getSpaceShipYStartPosition();
    }//end method getYStartPosition
    
    public String getPlayerName(){
        return Model.getInstance().getPlayerName();
    }//end method getPlayerName
    
    public String getPlayerRebounces(){
        return Model.getInstance().getPlayerRebounces();    
    }//end method getPlayerRebounces
    
    public int getPlayerLevel(){
        return Model.getInstance().getPlayerLevel();
    }//end method getPlayerLevel
    
    
    //logic of the game
    
    private void setSpaceshipPositionToShoot(double xPosition,double yPosition)
    {
        View.getInstance().updateSpaceshipCenter(xPosition, yPosition);
        Model.getInstance().updateSpaceshipCenter(xPosition, yPosition);
        Model.getInstance().updateXSpaceshipCoordinate(0);//suppongo che quest siano coordinate relative per regolarsi
        Model.getInstance().updateYSpaceshipCoordinate(0);
        View.getInstance().updateSpaceshipPositionX(0);
        View.getInstance().updateSpaceshipPositionY(0);
    }
    
    public void shootSpaceship(double angle,double speed,double initialXStarshipPosition,double initialYStarshipPosition){
        setSpaceshipPositionToShoot(initialXStarshipPosition,initialYStarshipPosition);
        new AnimationTimer(){
            double speedX = Math.cos(angle)*speed;
            double speedY = Math.sin(angle)*speed;
            int timeTranslation = 0;
            
            @Override
            public void handle(long now){
                double moveXComponent = speedX * (timeTranslation);//da rivedere
                double moveYComponent = -speedY * (timeTranslation) + (0.1 * Math.pow(timeTranslation, 2)) / 2;//da rivedere
                timeTranslation++;
                    if(!Model.getInstance().isSpaceshipOutOfScenaryLimits){//se l'astronave non è fuori dai limiti si entrerà in questo if
                       
                        if(Model.getInstance().isHurtingAPlanet){//metodo del rimbalzo se  l'astronave urta un pianeta
                            double newAngle = Math.atan2(moveYComponent * -1,moveXComponent) - Math.PI;
                        }//end if
                    
                
                
            }//end method handle
        }//end animation timer
    }//end method shootSpaceship
    
    public void moveSpaceShip(double moveX,double moveY){
        Model.getInstance().updateXSpaceshipCoordinate(moveX);
        Model.getInstance().updateYSpaceshipCoordinate(moveY);
        View.getInstance().updateSpaceshipPositionX(moveX);
        View.getInstance().updateSpaceshipPositionY(moveY);
    }
    
    
    
    //methods to set up the instance
    
    private ControllerForView()
    {
        //this.disablePlayerControl = false;
    }//end constructor
    
    public static IControllerForView getInstance() {
	if (instance == null)
            instance = new ControllerForView();
	return instance;
    }
}//end class ControllerForView
