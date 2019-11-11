/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.controller;

import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author giorg
 */
public interface IControllerForView {
    
    public double getXStartPosition();
    public double getYStartPosition();
    public String getPlayerName();
    public int getPlayerRebounces();
    public int getPlayerLevel();
    public void shootSpaceship(double angle,double speed,double initialXStarshipPosition,double initialYStarshipPosition);
    public void moveSpaceShip(double moveX,double moveY);
    public void createNewGameProfile(String name) throws IOException;
    public LinkedList<String[]> getListOfPlayers() throws IOException;
    public LinkedList<String[]> getLevelStats() throws IOException;
    public void loadGameProfile(int idProfile) throws IOException;
    public void loadLevel(int level,boolean modality);
    public void deleteProfile(int idProfile);
    
    
    
    
    
}
