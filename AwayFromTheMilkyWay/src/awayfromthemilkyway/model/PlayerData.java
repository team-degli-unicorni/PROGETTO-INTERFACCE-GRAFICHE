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
public class PlayerData {
    
    private LinkedList<Player> playerLst;//dichiarazione lista dei giocatori salvati al momento. Gli elementi di playerList saranno del tipo Player

    public PlayerData(){
        
        this.playerLst = new LinkedList<Player>();//il costruttore crea una nuova lista
    }//end constructor of the class

    public void add(Player player) {
        
        this.playerLst.add(player);//aggiungo un giocatore alla lista dei giocatori
    }
    
    public void remove(Player player) {
        
        this.playerLst.remove(player);//rimuovo un giocatore dalla lista dei giocatori
    }

    public LinkedList<Player> getListOfPlayers() { 
        
        return this.playerLst;
    }

    public LinkedList<String[]> asListOfStringArray() {
        
        LinkedList<String[]> lstSA = null;//inizializzo una lista chiamata 1stSA, cha sarà una lista di array di stringhe

        lstSA = new LinkedList<String[]>();
        String[] sArr = null;//inizializzazione dell'array di stinghe sArr
        for (Player p : this.playerLst) {//il foreach serve a far scorrere tutta la linkedlist DEI GIOCATORI
                                          //per ogni componente p della lista, ciascuno dei quali sarà un player, i suoi dati verranno copiati
                                          //ciascuno in una diversa casella di sArr e poi l'array di stringhe verrà aggiunto
                                          //alla linkedList
                                          //così facendo otterremo la rappresentazione della lista player come lista di array di stringhe
            sArr = new String[6];
            sArr[0] = String.valueOf(p.getPlayerId());
            sArr[1] = p.getPlayerName();
            sArr[2] = String.valueOf(p.getPlayerBouncesNumber());
            sArr[3] = String.valueOf(p.getDesiredBounces());
            sArr[4] = String.valueOf(p.getLevelNumber());
            sArr[5] = String.valueOf(p.getLaunchPower());
            lstSA.add(sArr);
        }

        return lstSA;
    }  
    
}//end class
