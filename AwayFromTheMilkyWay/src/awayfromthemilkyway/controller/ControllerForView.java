/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.controller;

import awayfromthemilkyway.model.Model;
import awayfromthemilkyway.view.View;
import javafx.animation.AnimationTimer;

/**
 *
 * @author giorg
 */
public class ControllerForView implements IControllerForView {
    
    
    private static ControllerForView instance = null;
    
    
    
    
        
    
    //methods to make view and model in comunication
    
    @Override
    public double getXStartPosition(){
        return Model.getInstance().getSpaceShipXStartPosition();
    }//end method getXStartPosition
    
    @Override
    public double getYStartPosition(){
        return Model.getInstance().getSpaceShipYStartPosition();
    }//end method getYStartPosition
    
    @Override
    public String getPlayerName(){
        return Model.getInstance().getPlayerName();
    }//end method getPlayerName
    
    @Override
    public String getPlayerRebounces(){
        return Model.getInstance().getPlayerRebounces();    
    }//end method getPlayerRebounces
    
    @Override
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
    
    @Override
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
                    if(!Model.getInstance().isSpaceshipOutOfScenaryLimits()){//se l'astronave non è fuori dai limiti si entrerà in questo if
                       
                        if(Model.getInstance().isHurtingAPlanet()){//rimbalzo se  l'astronave urta un pianeta
                            double newAngle = Math.atan2(moveYComponent * -1,moveXComponent) - Math.PI;// link per info su coord polari https://library.weschool.com/lezione/sistema-di-coordinate-polari-spirale-di-archimede-geometria-analitica-13404.html
                            //Resources.SoundEffects.BOUNCE.play();
                            
                            this.stop(); 
                            ControllerForView.getInstance().shootSpaceship(newAngle,speed/2,
                                    Model.getInstance().getSpaceshipXPosition(),
                                    Model.getInstance().getSpaceshipYPosition());//non so perchè ma qui sottrae alla posizione di partenza una costante BOUNCING(penso per la gravità)
                                    this.checkWin();
                            
                      
                        }else{//se ad esempio l'astronave incaglia contro un ostacolo  contro la via lattea
                            this.stop();
                            //metodo che mostra al giocaotre che ha perso
                        }
                    
                    } else {//se l'astronave esce dai bordi
                        this.stop();
                    }
            }//end method handle
             
            private boolean checkWin(){
                return Model.getInstance().isLevelWin();
            }
           
                    
            
        }.start();//end animation timer
    }//end method shootSpaceship
    
    
    
    
    
    
    
    
    @Override
    public void moveSpaceShip(double moveX,double moveY){//non so a cosa serva questo metodo
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
