/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import awayfromthemilkyway.view.MenuGui;
import java.io.FileNotFoundException;
import javafx.scene.layout.Pane;


import awayfromthemilkyway.view.View;
 
        
        
public class AwayFromTheMilkyWay extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        View.getInstance().openMenuWindow();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
