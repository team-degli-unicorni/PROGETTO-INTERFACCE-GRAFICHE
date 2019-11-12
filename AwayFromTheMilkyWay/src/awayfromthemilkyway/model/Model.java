/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.model;

import awayfromthemilkyway.utils.ReadCSV;
import awayfromthemilkyway.utils.WriteCSV;
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
    public int getPlayerLevel() {
         
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
    public void setPlayerData() throws IOException, FileNotFoundException{
        
        LinkedList<String[]> lstRows=null;//inizializza una linked list

            playerData = new PlayerData();
            if(new File("gameprofiles/saved.csv").exists()) {//se il file esiste allora leggo la prima riga
                
                lstRows = ReadCSV.getRows("gameprofiles/saved.csv", "UTF-8");
            }
            else {//se il file non esiste allora creo il file
                
                new File("gameprofiles").mkdir();
                new File("gameprofiles/saved.csv").createNewFile();
            }
            
            if(lstRows!=null)//con il foreach scorro tutta la linked list
            for(String[] currentPlayer : lstRows) {//il comando con i due punti si chiama foreach. INFO  SUL FOREACH:https://www.mrwebmaster.it/java/costrutto-foreach_12821.html
                                                   //in parole povere se la nosta linked list 1stRows non è vuota allora per ogni elemento che verrà chiamato
                                                   //"currentPlayer" nel momento in cui vene scorso, viene eseguita l'azione sottostante
                playerData.add(new Player(Integer.parseInt(currentPlayer[0]),//aggiungo un giocatore dentro alla linked list composta da oggetti del tipo "giocatore" attraverso il metodo add della classe playerData
                        currentPlayer[1],Integer.parseInt(currentPlayer[2]),
                        Integer.parseInt(currentPlayer[3]),
                        Integer.parseInt(currentPlayer[4]),
                        Integer.parseInt(currentPlayer[5])));
            }   
    }//end method set player data

    @Override
    public PlayerData getPlayerData() {
        
        return this.playerData;
    }//end method getPlayerData
    
    
    
    
    
    
    
    
     private void setupConfiguration()//DA CONTROLLARE
    {
        this.bulletRadius = Config.getInstance().getBulletRadius();

        this.battlefieldWidth = Config.getInstance().getBattlefieldWidth();
        this.battlefieldHeight = Config.getInstance().getBattlefieldHeight();
        
        
        
    @Override//DA CONTROLLARE E ANCORA DA METTERE NELL'INTERFACE
    public void setupResults()
    {
        if(!(new File("gameprofiles/stats.csv").exists()))
        {
                new File("gameprofiles").mkdir();
                try
                {
                    new File("gameprofiles/stats.csv").createNewFile();
                }catch(IOException ioe){
                    ControllerForModel.getInstance().notifyException(ioe.toString());
                }
        }
        this.levelData = new LevelData();
        try
        {
            for(String[] currentLevel : ReadCSV.getRows("gameprofiles/stats.csv", "UTF-8"))
            {
                levelData.add(new LevelStats(Integer.parseInt(currentLevel[0]), //Level - ID
                                            Integer.parseInt(currentLevel[1]), //BestPlayer - ID
                                            currentLevel[2], //BestPlayer - Name
                                            Integer.parseInt(currentLevel[3]), //Best player - Score
                                            Integer.parseInt(currentLevel[4]), //Second Best - ID
                                            currentLevel[5],//Second Best - Name
                                            Integer.parseInt(currentLevel[6]), //Second Best - Score
                                            Integer.parseInt(currentLevel[7]), //Third Best - ID
                                            currentLevel[8],//Third Best - name
                                            Integer.parseInt(currentLevel[9]))); //Third Best - Score
            }
        }catch(IOException ioe){
            ControllerForModel.getInstance().notifyException(ioe.toString());
        }          
    }//end method setupResults

        
        
        
        
        
        
    @Override//DA CONTROLLARE E ANCORA DA METTERE NELL'INTERFACE
    public void init(int level,UniverseModel universe){//devo creare il modello dell'universo
    
 
        this.level = level;
        setupConfiguration();
        setupResults();
        this.playerBase = playerBase;
        this.enemyBase = enemyBase;

        penguins = new ArrayList<>();
        this.playerCurrentDamageFactor = Constants.SNOWBALL_DAMAGE_FACTOR;
        this.secondPlayerCurrentDamageFactor = Constants.SNOWBALL_DAMAGE_FACTOR;

        this.playerScore = 0;
        this.indexTurn = 0;
        
        //Sarebbe opportuno recuperare questi dati da un file di configurazione.
        this.bullet = new BulletModel(Config.getInstance().getPlayerBulletStartXPosition(),
                Config.getInstance().getPlayerBulletStartYPosition(),
                this.bulletRadius,
                this.playerCurrentDamageFactor); 
        this.numberAlliedPenguins = Config.getInstance().getNumberPenguins();
        this.numberEnemyPenguins = Config.getInstance().getNumberPenguins();
        
        int penguinLife = 100;
        switch(this.player.getDifficultyLevel())
        {
            case Constants.EASY_LEVEL:
                penguinLife = Constants.EASY_LEVEL_PENGUIN_LIFE;
                break;
            case Constants.MEDIUM_LEVEL:
                penguinLife = Constants.MEDIUM_LEVEL_PENGUIN_LIFE;
                break;
            case Constants.HARD_LEVEL:
                penguinLife = Constants.HARD_LEVEL_PENGUIN_LIFE;
                break;
            default:
                break;
        }
            
        
        for(int i=0;i<this.numberAlliedPenguins;i++)
        {
            double distance = Config.getInstance().getDistanceBetweenPenguins()*i;
            PenguinModel penguin = new PenguinModel(Config.getInstance().getAlliedPenguinsStartXPosition()+distance,
                    Config.getInstance().getPenguinsStartYPosition(), //Penguin Position
                    penguinLife, //Penguin Life Points
                    true); //Allied Penguin
            this.penguins.add(penguin);  
        }
        
        for(int i=0;i<this.numberEnemyPenguins;i++)
        {
            double distance = Config.getInstance().getDistanceBetweenPenguins()*i;
            PenguinModel penguin = new PenguinModel(Config.getInstance().getEnemyPenguinsStartXPosition()-distance,
                    Config.getInstance().getPenguinsStartYPosition(),
                    penguinLife,
                    false);
            this.penguins.add(penguin);
        }
    }


    @Override
    public void deleteProfile(int idProfile) {//il metodo getListOfPlayers restituisce la lista dei giocatori,che viene fatta scorrere
                                              //e per ciascun elemento si confronta se il suo id è uguale a quello da eliminare
        
        for(Player p: this.playerData.getListOfPlayers())
            if(p.getPlayerId() == idProfile)
                this.playerData.getListOfPlayers().remove(p);
        try {
            
            WriteCSV.print("gameprofiles/saved.csv", "UTF-8", this.playerData.asListOfStringArray());
        
        } catch(IOException ioe) {
            //COMANDO DA IMPLEMENTARE QUANDO SI FARA' IL CONTROLLER FOR MODEL
            //ControllerForModel.getInstance().notifyException("Si Ã¨ verificato un errore: "+ioe);
        }
    }
    
    //Other Methods
 
    private Model() 
    {

    }//end constructor model
    public static IModel getInstance() {
	if (instance == null)
            instance = new Model();
	return instance;  
    }//end method getInstance

}//end class model
