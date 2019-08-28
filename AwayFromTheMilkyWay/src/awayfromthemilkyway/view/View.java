/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



import awayfromthemilkyway.utils.Resources;



public class View implements IView{
    
    //STATIC STUFF
    private final static int MENU_WINDOW_WIDTH = 1280;
    private final static int MENU_WINDOW_HEIGHT = 720;
    
     //INSTANCE FIELDS
    //--------------------------------------------------------------------------
    private static View instance = null;    
    private GameWindow gameWindow = null;
    private Stage shownWindow; 
    
    
    //method for the transition between game windows-----------------------------------------------------------------------------------------------------------------------------
    private void prepareSceneToShowWindow(String xmlSrc,String title,int windowWidth,int windowHeight)
    {
        closeGameWindow();
        Parent root;
        try
        {
            root = FXMLLoader.load(getClass().getResource(xmlSrc));
            //shownWindow.getIcons().add(Resources.GeneralImages.ICON.getImage());//general images è un metodo che sta nella classe Resources che ancora devo implementare e in questo caso serve a caricare l'icona iniziale del gioco
            shownWindow.setScene(new Scene(root,windowWidth,windowHeight));
            shownWindow.setTitle(title);
            shownWindow.show();
            shownWindow.setResizable(false);   
        }catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void openMenuWindow() {
        prepareSceneToShowWindow("menuGui.fxml", "Away From The Milky Way", MENU_WINDOW_WIDTH, MENU_WINDOW_HEIGHT);
    }//end override method openMenuWindow

    @Override
    public void openGameWindow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//end override method openGameWindow
    
    
     private void closeGameWindow()
    {
        if(this.gameWindow!=null)
        {
            //Resources.Music.SOUNDTRACK.stop();//music deve ancora essere implementato. Il suo compito è quello di stoppare la traccia musicale
            gameWindow.close();
            gameWindow = null;
        }
    }//end method close game window
     
     
     
     //other methods---------------------------------------------------------------------------------------------------------------------------------------

     private View(){
         shownWindow = new Stage();
     }//end constructor View
     
     
      public static IView getInstance() {
	if (instance == null)
            instance = new View();
	return instance;  
    }//end method getInstance












}//end class view

