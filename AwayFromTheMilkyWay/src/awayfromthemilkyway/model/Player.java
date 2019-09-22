/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.model;

/**
 *
 * @author Stefania
 */
public class Player {
    
    private String playerName;
    private int playerBouncesNumber;
    private int desiredBounces;
    private int levelNumber;
    private double launchPower;

    public Player(String playerName, int playerBouncesNumber, int desiredBounces, int levelNumber, double launchPower){
        
        this.playerName = playerName;
        this.playerBouncesNumber = playerBouncesNumber;
        this.desiredBounces = desiredBounces;
        this.levelNumber = levelNumber;
        this.launchPower = launchPower;
    }
    
    public String getPlayerName(){
       
        return this.playerName;
        
    }//end method getPlayerName 
    
    public int getPlayerBouncesNumber(){
        
        return this.playerBouncesNumber;
    
    }//end method getPlayerBouncesNumber
    
    public void setDesiredBounces(int desiredBounces){
        
        this.desiredBounces = desiredBounces;
    
    }//end method setDesiredBounces
    
    public int getDesiredBounces(){
        
        return this.desiredBounces;
    
    }//end method getDesiredBounces
    
    public void setLevelNumber(int levelNumber){
        
        this.levelNumber = levelNumber;
    
    }//end method setLevelNumber
    
    public int getLevelNumber(){
        
        return this.levelNumber;
    
    }//end method getLevelNumber

    public double getLaunchPower(){
        
        return launchPower;
    
    }//end method getLaunchPower 
}

    
}
