/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Stefania
 */
public interface IModel {
    
    //Methods Used in order to set/get the position of the spaceship
    public void updateSpaceshipCenter(double x,double y);
    public void updateXSpaceshipCoordinate(double xTranslation);
    public void updateYSpaceshipCoordinate(double yTranslation);
    public double getSpaceshipXPosition();
    public double getSpaceshipYPosition();
    public double getSpaceShipXStartPosition();
    public double getSpaceShipYStartPosition();
    
    //Methods used in order to Manage the life of spaceship
    public boolean isSpaceshipOutOfScenaryLimits();
    public boolean isHurtingAPlanet();
    
    //Methods used in order to control the match
    public GameData getGameData();
    public int getLevel();
    
    //Methods used in order to get/set the data about the match.
    public boolean isGameWin();
    public boolean isGameLost();
    public int getPlayerRebounces();
    public String getPlayerName();
    public int getPlayerLevel();
    public int getPlayerBestLevel();
    public void setCurrentPlayer(Player p);
    public void setPlayerData() throws IOException, FileNotFoundException;
    public PlayerData getPlayerData();
    public void deleteProfile(int idProfile);  
}

