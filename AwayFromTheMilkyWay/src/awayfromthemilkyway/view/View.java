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
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;



public class View implements IView{
    
    //STATIC STUFF
    private final static int MENU_WINDOW_WIDTH = 1280;
    private final static int MENU_WINDOW_HEIGHT = 800; 
    private final static int GAME_WINDOW_WIDTH = 1280;
    private final static int GAME_WINDOW_HEIGHT = 800;
    
     //INSTANCE FIELDS
    //--------------------------------------------------------------------------
    private static View instance = null;    
    private GameGui gameWindow = null;
    private Stage shownWindow; 
   
    
    
    //method for the transition between game windows-----------------------------------------------------------------------------------------------------------------------------
    private void prepareSceneToShowWindow(String xmlSrc,String title,int windowWidth,int windowHeight)
    {
        closeGameWindow();
        Parent root;
        try
        {
            root = FXMLLoader.load(getClass().getResource(xmlSrc));
            shownWindow.getIcons().add(Resources.otherImages.icon.getImage());//general images è un metodo che sta nella classe Resources che ancora devo implementare e in questo caso serve a caricare l'icona iniziale del gioco
            shownWindow.setScene(new Scene(root,windowWidth,windowHeight));
            shownWindow.setTitle(title);
            shownWindow.show();
            shownWindow.setResizable(false);   
        }catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end method prepareSceneToShowWindow
    
    @Override
    public void openGameWindow(){
        closeGameWindow();
        this.gameWindow = new GameGui();
        gameWindow.getIcons().add(Resources.otherImages.icon.getImage());
        this.gameWindow.getUniverse().setGalaxyConfiguration();//serve a settare la galassia con i èpianeti all'inizio//PROBLEMA IN QUESTO METODO
        //Resources.Music.SOUNDTRACK.play(); questa riga serve a mettere la musica,la implementeremo qundo implementeremo resources
        gameWindow.show();
        shownWindow.setScene(null);
        shownWindow.hide();
        
        
    }//end override method openGameWindow
   
    @Override
    public void openMenuWindow() {
        prepareSceneToShowWindow("menuGui.fxml", "Away From The Milky Way", MENU_WINDOW_WIDTH, MENU_WINDOW_HEIGHT);
    }//end override method openMenuWindow

    
    @Override
    public void openOptionsWindow(){
        this.prepareSceneToShowWindow("optionsGui.fxml","Opzioni - Away From The Milky Way", MENU_WINDOW_WIDTH, MENU_WINDOW_HEIGHT);
    }//end override method openOptionsWindow()
    
    @Override
    public void openInstructionsWindow(){
        this.prepareSceneToShowWindow("instructionsGui.fxml", "Istruzioni - Away From The Milky Way", MENU_WINDOW_WIDTH, MENU_WINDOW_HEIGHT);
    }//end override method openInstructionsWindow()
    
    private void closeGameWindow()
    {
        if(this.gameWindow!=null)
        {
            //Resources.Music.SOUNDTRACK.stop();//music deve ancora essere implementato. Il suo compito è quello di stoppare la traccia musicale
            gameWindow.close();
            gameWindow = null;
        }
    }//end method close game window
     
     
     
     //show dialogue methods--------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public void showInformationDialog(String message, String title){
    

            Alert dialogWindow = new Alert(Alert.AlertType.INFORMATION);
            ((Stage) dialogWindow.getDialogPane().getScene().getWindow()).getIcons()
                .add(Resources.otherImages.icon.getImage());
            dialogWindow.setTitle(title);
            dialogWindow.setContentText(message);
            dialogWindow.showAndWait();

    }

    @Override
    public boolean showConfirmationDialog(String message,String title, String firstOption, String secondOption){
    
        AtomicBoolean userChoose = new AtomicBoolean();
        Alert dialogWindow = new Alert(Alert.AlertType.INFORMATION);
        dialogWindow.setTitle(title);
        dialogWindow.setHeaderText(null);
        dialogWindow.setContentText(message);
        ((Stage) dialogWindow.getDialogPane().getScene().getWindow()).getIcons()
                .add(Resources.otherImages.icon.getImage());
        
        ButtonType opt1 = new ButtonType(firstOption);
        ButtonType opt2 = new ButtonType(secondOption);
       
        dialogWindow.getButtonTypes().setAll(opt1,opt2);
       
        Optional<ButtonType> result = dialogWindow.showAndWait();
        userChoose.set(result.get() == opt1);

        dialogWindow.close();
        return userChoose.get();
    }
    @Override
    public void showErrorDialog(String message){
    
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Si Ã¨ verificato un errore...");
        error.setHeaderText("Si Ã¨ verificato l'errore:");
        error.setContentText(message); 
        error.show();
    }

    //methods to move the spaceship
    @Override
    public void updateSpaceshipPositionX(double translation){
        this.gameWindow.getUniverse().getSpaceship().setTranslateX(translation);
    }//end method updateSpaceshipCenterPositionX
    
    
    @Override
    public void updateSpaceshipPositionY(double translation){
        this.gameWindow.getUniverse().getSpaceship().setTranslateY(translation);
    }//end method updateSpaceshipCenterPositionY
    
    
    @Override
    public void updateSpaceshipCenter(double xCenter,double yCenter){
        this.gameWindow.getUniverse().getSpaceship().setCenterX(xCenter);
        this.gameWindow.getUniverse().getSpaceship().setCenterX(yCenter);
    }//end method updateBulletCenter
    
    
    @Override
    public double getSpaceshippositionX(){
        return (this.gameWindow.getUniverse().getSpaceship().getTranslateX()+this.gameWindow.getUniverse().getSpaceship().getCenterX());
    }
    
    @Override
    public double getSpaceshippositionY(){
        return (this.gameWindow.getUniverse().getSpaceship().getTranslateY()+this.gameWindow.getUniverse().getSpaceship().getCenterY());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private View(){
        
         shownWindow = new Stage();
     }//end constructor View
     
     
      public static IView getInstance() {
	if (instance == null)
            instance = new View();
	return instance;  
    }//end method getInstance







}//end class view

