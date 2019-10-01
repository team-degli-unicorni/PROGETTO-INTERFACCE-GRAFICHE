/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Stefania
 */
public class Model implements IModel {
    
    //static fields
   
    private static Model instance = null; 
    
    //instance fields
   
    private int playerLevel;
    private int level;
    private SpaceshipModel spaceship;
    private ObstacleEnemyModel enemyPlanet;
    private PlayerData playerData;
    private GameData gameData;
    private Player player;
    
    //Methods Used in order to set/get the position of the spaceship

    @Override
    public void updateSpaceshipCenter(double x, double y) {
        
        this.spaceship.setCenterX(x);
        this.spaceship.setCenterY(y);
    }

    @Override
    public void updateXSpaceshipCoordinate(double xTranslation) {
        
        this.spaceship.setTranslateX(xTranslation);
    }

    @Override
    public void updateYSpaceshipCoordinate(double yTranslation) {
        
         this.spaceship.setTranslateY(yTranslation);
    }

    @Override
    public double getSpaceshipXPosition() {
        
        return (this.spaceship.getTranslateX()+this.spaceship.getCenterX());
    }

    @Override
    public double getSpaceshipYPosition() {
        
        return (this.spaceship.getTranslateY()+this.spaceship.getCenterY());
    }

    @Override
    public double getSpaceshipXStartPosition() {
        
        return this.spaceship.getCenterX();
    }

    @Override
    public double getSpaceshipYStartPosition() {
        
       return this.spaceship.getCenterY();
    }
    
    //Methods used in order to Manage the life of spaceship
    
    @Override
    public boolean isSpaceshipOutOfScenaryLimits() {
        
        double startXPosition = this.getSpaceshipXStartPosition();
        double startYPosition = this.getSpaceshipYStartPosition();
        
        double xUniverseBound = 1200.0-this.spaceship.getRadius();
        double yUniverseBound = 800.0-this.spaceship.getRadius();
       
        
        boolean maxLimitReach = startXPosition+this.spaceship.getTranslateX()>xUniverseBound || startYPosition+this.spaceship.getTranslateY()>yUniverseBound;
        
        return maxLimitReach;
        
        /*boolean spaceshipOutOfScenaryLimits = true;
        
        if(this.spaceship.getCenterX()+ this.spaceship.getRadius()<1200.0 || this.spaceship.getCenterY()+ this.spaceship.getRadius()<800.0) {
            
            spaceshipOutOfScenaryLimits = false;
            
            return spaceshipOutOfScenaryLimits;
        }
        
        return spaceshipOutOfScenaryLimits;*/
        
    }

    @Override
    public boolean isHurtingAPlanet() {
        
        boolean collision = false;
        
        if(this.spaceship.intersects(enemyPlanet.getBoundsInParent()))
            collision = true;
        
        return collision;
    }
    
     //Methods used in order to control the match
    
    @Override
    public GameData getGameData() {
        
        return gameData;
    }

    @Override
    public int getLevel() {
         
        return this.level;
    }
    
    //Methods used in order to get/set the data about the match.

    @Override
    public boolean isGameWin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isGameLost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPlayerRebounces() {
        
        return this.player.getPlayerBouncesNumber();
    }

    @Override
    public String getPlayerName() {
        
       return this.player.getPlayerName();
    }

    @Override
    public void setCurrentPlayer(Player p) {
        
        this.player = p;
    }

    @Override
    public void setPlayerData() throws IOException, FileNotFoundException {
        
        LinkedList<String[]> lstRows=null;

            playerData = new PlayerData();
            if(new File("gameprofiles/saved.csv").exists()) {
                
                lstRows = ReadCSV.getRows("gameprofiles/saved.csv", "UTF-8");
            }
            else {
                
                new File("gameprofiles").mkdir();
                new File("gameprofiles/saved.csv").createNewFile();
            }
            
            if(lstRows!=null)
            for(String[] currentPlayer : lstRows) {
                
                playerData.add(new Player(Integer.parseInt(currentPlayer[0]),
                        currentPlayer[1],Integer.parseInt(currentPlayer[2]),
                        Integer.parseInt(currentPlayer[3]),
                        Integer.parseInt(currentPlayer[4]),
                        Integer.parseInt(currentPlayer[5])));
            }   
    }

    @Override
    public PlayerData getPlayerData() {
        
        return this.playerData;
    }

    @Override
    public void deleteProfile(int idProfile) {
        
        for(Player p: this.playerData.getListOfPlayers())
            if(p.getPlayerId() == idProfile)
                this.playerData.getListOfPlayers().remove(p);
        try {
            
            WriteCSV.print("gameprofiles/saved.csv", "UTF-8", this.playerData.asListOfStringArray());
        
        } catch(IOException ioe) {
            
            ControllerForModel.getInstance().notifyException("Si Ã¨ verificato un errore: "+ioe);
        }
    }
    
    //Other Methods
    private Model() {

    }
    public static IModel getInstance() {
	if (instance == null)
            instance = new Model();
	return instance;  
    }
    
}
