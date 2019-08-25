/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import awayfromthemilkyway.view.menuGui;
import javafx.scene.layout.Pane;
 
        
        
public class AwayFromTheMilkyWay extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        
        menuGui menu = new menuGui();
        Pane root = menuGui.disegnaGui();
        //root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 1280, 720);
        
        primaryStage.setTitle("Away From The Milky Way");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
