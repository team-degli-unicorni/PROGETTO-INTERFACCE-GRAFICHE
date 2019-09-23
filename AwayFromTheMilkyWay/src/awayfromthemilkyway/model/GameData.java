/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.model;

import java.util.LinkedList;

/**
 *
 * @author Stefania
 */
public class GameData {
    private LinkedList<GameStats> gameListData;

    public GameData(){
        
        this.gameListData = new LinkedList<GameStats>();
    }

    public void add(GameStats game){
        this.gameListData.add(game);
    }
    
    public GameStats searchForGameId(int game){
        
        GameStats found = null;
        
        for(GameStats current : gameListData){
            if(current.getGameId() == game)
                found = current;
        }
        
        return found;
    }
    
    public void checkForUpdate(Player player, int game,int level){
        
        int gameIndex = level - 1;
        GameStats currentGame = searchForGameId(game);
        
        if(currentGame!=null){
            if(level>currentGame.getLevelBest()){
                
                currentGame.setIdBestThree(currentGame.getIdBestTwo());
                currentGame.setNameBestThree(currentGame.getNameBestTwo());
                currentGame.setLevelBestThree(currentGame.getLevelBestTwo());

                currentGame.setIdBestTwo(currentGame.getIdBest());
                currentGame.setNameBestTwo(currentGame.getNameBest());
                currentGame.setLevelBestTwo(currentGame.getLevelBest());

                currentGame.setIdBest(player.getPlayerId());
                currentGame.setNameBest(player.getPlayerName());
                currentGame.setLevelBest(level);
            } else if(level>currentGame.getLevelBestTwo()){
                
                currentGame.setIdBestThree(currentGame.getIdBestTwo());
                currentGame.setNameBestThree(currentGame.getNameBestTwo());
                currentGame.setLevelBestThree(currentGame.getLevelBestTwo());

                currentGame.setIdBestTwo(player.getPlayerId());
                currentGame.setNameBestTwo(player.getPlayerName());
                currentGame.setLevelBestTwo(level);            
            } else if(level>currentGame.getLevelBestThree()){
                
                currentGame.setIdBestThree(player.getPlayerId());
                currentGame.setNameBestThree(player.getPlayerName());
                currentGame.setLevelBestThree(level);      
            }
        }
        else{
            
            currentGame = new GameStats(game,
                    player.getPlayerId(),
                    player.getPlayerName(),
                    level);
            gameListData.add(currentGame);
        }
    }
    
    public void remove(GameStats game){
        
        this.gameListData.remove(game);
    }

    public LinkedList<GameStats> getListOfGames(){
        
        return this.gameListData;
    }

    public LinkedList<String[]> asListOfStringArray(){
        
        LinkedList<String[]> lstSA = null;

        lstSA = new LinkedList<String[]>();
        String[] sArr = null;
        for (GameStats game : this.gameListData){
            sArr = new String[10];
            //Best Player of the level
            sArr[0] = String.valueOf(game.getGameId());
            
            sArr[1] = String.valueOf(game.getIdBest());
            sArr[2] = game.getNameBest();
            sArr[3] = String.valueOf(game.getLevelBest());
            
            sArr[4] = String.valueOf(game.getIdBestTwo());
            sArr[5] = game.getNameBestTwo();
            sArr[6] = String.valueOf(game.getLevelBestTwo());
            
            sArr[7] = String.valueOf(game.getIdBestThree());
            sArr[8] = game.getNameBestThree();
            sArr[9] = String.valueOf(game.getLevelBestThree());
            
            lstSA.add(sArr);
        }

        return lstSA;
    }

}//end class
