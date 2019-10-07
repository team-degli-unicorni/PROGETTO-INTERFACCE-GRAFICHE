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
    public void updateSpaceshipCenter(double x,double y); //ok
    public void updateXSpaceshipCoordinate(double xTranslation); //ok
    public void updateYSpaceshipCoordinate(double yTranslation); //ok
    public double getSpaceshipXPosition(); //ok
    public double getSpaceshipYPosition(); //ok
    public double getSpaceshipXStartPosition(); //ok
    public double getSpaceshipYStartPosition(); //ok
    public double getMilkyWayXPosition();
    public double getMilkyWayYPosition();
    public double getMilkyWayRadius();
    
    //Methods used in order to Manage the life of spaceship
    public boolean isSpaceshipOutOfScenaryLimits(); //ok
    public boolean isHurtingAPlanet(); //ok
    
    //Methods used in order to control the match
    public GameData getGameData();
    public int getPlayerLevel(); //ok
    
    //Methods used in order to get/set the data about the match.
    public boolean isLevelWin();
    public boolean isGameLost();
    public int getPlayerRebounces(); //ok
    public String getPlayerName(); //ok
    public void setCurrentPlayer(Player p);
    public void setPlayerData() throws IOException, FileNotFoundException;
    public PlayerData getPlayerData();
    public void deleteProfile(int idProfile);  
}

