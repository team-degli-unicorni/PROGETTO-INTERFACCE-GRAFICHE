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
public class Model implements IModel {
    
    //static fields
   
    private static Model instance = null; 
    
    //instance fields
   
    private int playerLevel;
    private double playerBulletXStartPosition;
    private double playerBulletYStartPosition;
    private int level;
    private double bulletRadius;
    private SpaceshipModel spaceship;
    private PlayerData playerData;
    private GameData gameData;
    private Player player;
    private MilkyWayModel milkyWay;
    
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
    
    @Override
    public double getMilkyWayXPosition(){
        
        return this.milkyWay.getCenterX();
    
    }//end method getMilkyWayXPosition()
    
    @Override
    public double getMilkyWayYPosition(){
        
        return this.milkyWay.getCenterY();
    
    }//end method getMilkyWayYPosition()
    
    @Override
    public double getMilkyWayRadius(){
        
        return this.milkyWay.getRadius();
        
    }//end method getMilkyWayRadius
    
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean isLevelWin() {//confronta la posizione del centro dell'astronave con quella del centro della milkyway
       return(Model.getInstance().getSpaceshipXPosition() == Model.getInstance().getMilkyWayXPosition() & Model.getInstance().getSpaceshipYPosition() == Model.getInstance().getMilkyWayYPosition());
    }

    @Override
    public boolean isGameLost() {//secondo me non serve perchè abbiamo solo bisogno di sapere se il livello è superato oppure no,e il metodo sopra lo verifica restituendo false se non è superato e true se lo è
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPlayerRebounces() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPlayerName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPlayerLevel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPlayerBestLevel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCurrentPlayer(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPlayerData() throws IOException, FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlayerData getPlayerData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProfile(int idProfile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private Model() 
    {

    }//end constructor model
    public static IModel getInstance() {
	if (instance == null)
            instance = new Model();
	return instance;  
    }//end method getInstance
}
