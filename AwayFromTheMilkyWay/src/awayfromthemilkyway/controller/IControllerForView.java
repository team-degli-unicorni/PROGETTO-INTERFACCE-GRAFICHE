/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.controller;

/**
 *
 * @author giorg
 */
public interface IControllerForView {
    
    public double getXStartPosition();
    public double getYStartPosition();
    public String getPlayerName();
    public String getPlayerRebounces();
    public int getPlayerLevel();
    public void shootSpaceship(double angle,double speed,double initialXStarshipPosition,double initialYStarshipPosition);
    public void moveSpaceShip(double moveX,double moveY);
  
    
    
    
    
}
