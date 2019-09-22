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
public class GameStats {
    
    private int gameId;
    
    public int getGameId() {
        return gameId;
    }
    
    private int idBest;
    private int idBestTwo;
    private int idBestThree;
    
    private String nameBest;
    private String nameBestTwo;
    private String nameBestThree;
    
    private int levelBest;
    private int levelBestTwo;
    private int levelBestThree;
   

    public GameStats(int gameId,int idBest, String nameBest, int levelBest, int idBestTwo, String nameBestTwo, int levelBestTwo, int idBestThree, String nameBestThree, int levelBestThree){
        this.gameId = gameId;
        this.idBest = idBest;
        this.idBestTwo = idBestTwo;
        this.idBestThree = idBestThree;
        this.nameBest = nameBest;
        this.nameBestTwo = nameBestTwo;
        this.nameBestThree = nameBestThree;
        this.levelBest = levelBest;
        this.levelBestTwo = levelBestTwo;
        this.levelBestThree = levelBestThree;
    }

    public GameStats(int gameId, int idBest, String nameBest, int levelBest){
        this.gameId = gameId;
        this.idBest = idBest;
        this.nameBest = nameBest;
        this.levelBest = levelBest;
        this.idBestTwo = 0;
        this.nameBestTwo = "";
        this.levelBestTwo = 0;
        this.idBestThree = 0;
        this.nameBestThree = "";
        this.levelBestThree = 0;
    }
    
    public int getIdBest() {
        return idBest;
    }

    public int getIdBestTwo() {
        return idBestTwo;
    }

    public int getIdBestThree() {
        return idBestThree;
    }

    public String getNameBest() {
        return nameBest;
    }

    public String getNameBestTwo() {
        return nameBestTwo;
    }

    public String getNameBestThree() {
        return nameBestThree;
    }

    public int getLevelBest() {
        return levelBest;
    }

    public int getLevelBestTwo() {
        return levelBestTwo;
    }

    public int getLevelBestThree() {
        return levelBestThree;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setIdBest(int idBest) {
        this.idBest = idBest;
    }

    public void setIdBestTwo(int idBestTwo) {
        this.idBestTwo = idBestTwo;
    }

    public void setIdBestThree(int idBestThree) {
        this.idBestThree = idBestThree;
    }

    public void setNameBest(String nameBest) {
        this.nameBest = nameBest;
    }

    public void setNameBestTwo(String nameBestTwo) {
        this.nameBestTwo = nameBestTwo;
    }

    public void setNameBestThree(String nameBestThree) {
        this.nameBestThree = nameBestThree;
    }

    public void setLevelBest(int levelBest) {
        this.levelBest = levelBest;
    }

    public void setLevelBestTwo(int levelBestTwo) {
        this.levelBestTwo = levelBestTwo;
    }

    public void setLevelBestThree(int levelBestThree) {
        this.levelBestThree = levelBestThree;
    }

    @Override
    public String toString() {
        return "GameStats{" + "idBest=" + idBest + ", idBestTwo=" + idBestTwo + ", idBestThree=" + idBestThree + ", nameBest=" + nameBest + ", nameBestTwo=" + nameBestTwo + ", nameBestThree=" + nameBestThree + ", levelBest=" + levelBest + ", levelBestTwo=" + levelBestTwo + ", levelBestThree=" + levelBestThree + '}';
    }
    
    public String[] dataAsStringArray()
    {
        String[] gameData = new String[3];
        gameData[0]= new StringBuilder().append("Miglior Giocatore: ")
                .append(this.nameBest)
                .append(", Livello: ")
                .append(this.getLevelBest()).toString();
        
        gameData[1] = new StringBuilder().append("Secondo miglior giocatore: ")
                .append(this.nameBestTwo)
                .append(", Livello: ")
                .append(this.getLevelBestTwo()).toString();
        
        gameData[2] = new StringBuilder().append("Terzo miglior giocatore: ")
                .append(this.nameBestThree)
                .append(", Livello: ")
                .append(this.getLevelBestThree()).toString();
        
        return gameData;
        
    }
    
}
