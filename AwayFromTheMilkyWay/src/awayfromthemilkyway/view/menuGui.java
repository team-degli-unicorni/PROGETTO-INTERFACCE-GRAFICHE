/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;

/**
 *
 * @author giorg
 */




import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane; 
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.*;
import javafx.scene.text.Font.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



public class menuGui  {
    
    public menuGui(){
        //empty constructor
    }//end constructor
    
    public static Pane disegnaGui(){
        
        
        BorderPane menu = new BorderPane();      
        VBox disposizioneVerticaleBottoni = new VBox(100);//20 is the spacing between buttons
        menu.setLeft(disposizioneVerticaleBottoni);
        disposizioneVerticaleBottoni.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY, Insets.EMPTY)));//colore di background blu
        disposizioneVerticaleBottoni.setAlignment(Pos.CENTER);//allinea tutti gli elementi della vbox al centro
          
        Font fontEtichetta = new Font("Comic Sans", 42);
        Font fontBottoni = new Font("Comic Sans", 25);
        InnerShadow is = new InnerShadow();
        
        Button btn1 = new Button("Nuova Partita");    
        btn1.setPrefSize(300,100);
        btn1.setMinHeight(70);
        btn1.setFont(fontBottoni);
        btn1.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY, Insets.EMPTY)));
        btn1.setEffect(is);
        disposizioneVerticaleBottoni.getChildren().add(btn1);
       
      
        Button btn2 = new Button("carica partita");
        btn2.setPrefSize(300,100);
        btn2.setMinHeight(70);
        btn2.setFont(fontBottoni);
        btn2.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY, Insets.EMPTY)));
        btn2.setEffect(is);
        disposizioneVerticaleBottoni.getChildren().add(btn2);
        
        
        Button btn3 = new Button("Opzioni");
        btn3.setPrefSize(300,100);
        btn3.setMinHeight(70);
        btn3.setFont(fontBottoni);
        btn3.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY, Insets.EMPTY)));
        btn3.setEffect(is);
        disposizioneVerticaleBottoni.getChildren().add(btn3);
        
        HBox contenitoreTitolo = new HBox();
        contenitoreTitolo.setAlignment(Pos.CENTER);
        contenitoreTitolo.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY, Insets.EMPTY)));
        
        /*Label titolo = new Label("AWAY FROM THE MILKY WAY");
        titolo.setFont(fontEtichetta);
        titolo.setPrefHeight(100);
        contenitoreTitolo.getChildren().add(titolo);*/
        Text titolo = new Text("AWAY FROM THE MILKY WAY");
        titolo.setId("fancytext");
        titolo.setFont(Font.font(null, FontWeight.BOLD, 80));
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);
        titolo.setEffect(is);
        titolo.setFill(YELLOW);
        contenitoreTitolo.getChildren().add(titolo);
                
        menu.setTop(contenitoreTitolo);
        
        
        
        return menu;
    }//end method disegnaGui
    
}
