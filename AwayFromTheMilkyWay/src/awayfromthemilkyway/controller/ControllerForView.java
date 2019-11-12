/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.controller;

import awayfromthemilkyway.model.Model;
import awayfromthemilkyway.model.PlayerData;
import awayfromthemilkyway.utils.Configuration;
import awayfromthemilkyway.utils.Constants;
import awayfromthemilkyway.utils.ReadCSV;
import awayfromthemilkyway.utils.WriteCSV;
import awayfromthemilkyway.view.View;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
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
        return Model.getInstance().getSpaceshipXStartPosition();
    }//end method getXStartPosition
    
    @Override
    public double getYStartPosition(){
        return Model.getInstance().getSpaceshipYStartPosition();
    }//end method getYStartPosition
    
    @Override
    public String getPlayerName(){
        return Model.getInstance().getPlayerName();
    }//end method getPlayerName
    
    @Override
    public int getPlayerRebounces(){
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
    
    @Override
    public void createNewGameProfile(String name) throws IOException{
    
        int playerId=-1;
     
        
        if(new File("gameprofiles/saved.csv").exists())  
        {
            if (!ReadCSV.getRows("gameprofiles/saved.csv", "UTF-8").isEmpty())//starebbe a dire che se il CSV è vuoto non si entra nemmeno nell'if
                playerId = Integer.parseInt(ReadCSV.getRows("gameprofiles/saved.csv", "UTF-8").getLast()[0]);//assegna a playerId l'ultimo elemnto della lista
        }
        else
        {
            new File("gameprofiles").mkdir();
            new File("gameprofiles/saved.csv").createNewFile();
        }

        String[] playerData = new String[6];//inserisco in un array di stringhe i dati del nuovo giocatore
        playerData[0]=String.valueOf(++playerId); //Setting up the ID of the player.
        playerData[1]=name; //Setting up the name of the player.
        playerData[2]=String.valueOf(0); //Setting up the number of desired bounces
        playerData[3]=String.valueOf(Model.getInstance().getPlayerRebounces()); //number of bounces
        playerData[4]=String.valueOf(Model.getInstance().getPlayerLevel()); //number of level
        playerData[5]=String.valueOf(1); //Setting up the current scenery in the campaign.

        WriteCSV.printRow("gameprofiles/saved.csv","UTF-8" , playerData);//scrivo i dati del nuovo giocatore nel file CSV

        Model.getInstance().setPlayerData();//aggiornao il nuovo giocatore nella lista "Players"
    }
    @Override
    public LinkedList<String[]> getListOfPlayers() throws IOException{
        Model.getInstance().setPlayerData();
        return Model.getInstance().getPlayerData().asListOfStringArray();
    }
    /*@Override 
    public LinkedList<String[]> getLevelStats() throws IOException{
        Model.getInstance().setupResults();
        return Model.getInstance().getLevelData().asListOfStringArray();
    }*/
    @Override 
    public String[] getLevelData(int level){//questo metodo ritorna i dati di un determinato livello a partire dal numero del livello
        return Model.getInstance().getGameData().searchForGameId(level).dataAsStringArray();
    }
    
    @Override
    public void loadGameProfile(int idProfile) throws IOException{//carica un profilo di gioco di un giocatore con id pari a idProfile
        Model.getInstance().setPlayerData();
        Model.getInstance().getPlayerData().getListOfPlayers().stream().filter((p) -> (p.getPlayerId()==idProfile)).forEachOrdered((p) -> {
            Model.getInstance().setCurrentPlayer(p);
        });
    }
    @Override
    public void loadLevel(int level,boolean modality)
    {
        
        String path = "/resources/config/level"+level+".txt";//stringa che esprime il path del livello che si vuole loaddare

        switch(level){//lo switch case funziona in questo modo: se l'argomento dello switch, in questo caso level è uguale a quello riportato dopo case, ad ex model.gegtInstance.MISSION_ONE_ID allora si entra in quel case      
            case Constants.MISSION_ONE_ID:
                Configuration.getInstance().changeConfigurationFile(path);
                Model.getInstance().init(level, //init è un metodo che da quanto ho capito setuppa il livello
                        modality,
                        new Level1Model(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()),
                        new Level1Model(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                View.getInstance().prepareGameScreen(
                        new Level1(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()), 
                        new Level1(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                break;
            case Constants.MISSION_TWO_ID:
                Config.getInstance().changeConfigurationFile(path);
                Model.getInstance().init(level, 
                        modality,
                        new Level2AlliedModel(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()),
                        new Level2EnemyModel(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                View.getInstance().prepareGameScreen(
                        new Level2Allied(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()), 
                        new Level2Enemy(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                break;
            case Constants.MISSION_THREE_ID:  //init è un metodo che da quanto ho capito setuppa il livello
                Config.getInstance().changeConfigurationFile(path);
                Model.getInstance().init(level, 
                        modality,
                        new Level3AlliedModel(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()),
                        new Level3EnemyModel(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                View.getInstance().prepareGameScreen(
                        new Level3Allied(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()), 
                        new Level3Enemy(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                break;
            case Constants.MISSION_FOUR_ID:
                Config.getInstance().changeConfigurationFile(path);
                Model.getInstance().init(level, 
                        modality,
                        new Level4Model(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()),
                        new Level4Model(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                View.getInstance().prepareGameScreen(
                        new Level4(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()), 
                        new Level4(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                break;
            case Constants.MISSION_FIVE_ID:
                Config.getInstance().changeConfigurationFile(path);
                Model.getInstance().init(level, 
                        modality,
                        new Level5Model(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()),
                        new Level5Model(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                View.getInstance().prepareGameScreen(
                        new Level5(Config.getInstance().getPlayerBaseStartX(),Config.getInstance().getPlayerBaseStartY()), 
                        new Level5(Config.getInstance().getEnemyBaseStartX(),Config.getInstance().getEnemyBaseStartY()));
                break;
            default:
                View.getInstance().showInformationDialog("Complimenti, hai completato tutte le missioni. "
                        + "Ora puoi rigiocare un qualunque scenario senza perdere vite",
                        "Campagna Completata");
                break;
        }
    }
    @Override
    public void deleteProfile(int idProfile){
        Model.getInstance().deleteProfile(idProfile);
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
