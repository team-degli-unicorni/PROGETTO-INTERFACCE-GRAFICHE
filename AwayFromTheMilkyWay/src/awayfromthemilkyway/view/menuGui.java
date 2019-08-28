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





import java.io.FileNotFoundException;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image; 
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane; 
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;



public class menuGui  {
    
    public menuGui(){
        //empty constructor
    }//end constructor
    
    public static Pane disegnaMenuGui() throws FileNotFoundException{
        
        
        BorderPane menu = new BorderPane();      
        VBox disposizioneVerticaleBottoni = new VBox(100);//20 is the spacing between buttons
        menu.setLeft(disposizioneVerticaleBottoni);
        disposizioneVerticaleBottoni.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY, Insets.EMPTY)));//colore di background blu
        disposizioneVerticaleBottoni.setAlignment(Pos.CENTER);//allinea tutti gli elementi della vbox al centro
          
        Font fontEtichetta = new Font("Comic Sans", 42);
        Font fontBottoni = new Font("Comic Sans", 25);
        InnerShadow is = new InnerShadow();
        DropShadow shadow = new DropShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);
        
        Button btn1 = new Button("Nuova Partita");    
        btn1.setPrefSize(300,100);
        btn1.setMinHeight(70);
        btn1.setFont(fontBottoni);
        btn1.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY, Insets.EMPTY)));
        btn1.setEffect(shadow);
        disposizioneVerticaleBottoni.getChildren().add(btn1);
        //Adding the shadow when the mouse cursor is on
        btn1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn1.setEffect(is);
        });
        //Removing the shadow when the mouse cursor is off
        btn1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn1.setEffect(shadow);
        });
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            //TO-DO
        });
            
        
      
        Button btn2 = new Button("carica partita");
        btn2.setPrefSize(300,100);
        btn2.setMinHeight(70);
        btn2.setFont(fontBottoni);
        btn2.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY, Insets.EMPTY)));
        btn2.setEffect(shadow);
        disposizioneVerticaleBottoni.getChildren().add(btn2);
         //Adding the shadow when the mouse cursor is on
        btn2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn2.setEffect(is);
        });
        //Removing the shadow when the mouse cursor is off
        btn2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn2.setEffect(shadow);
        });
        
        
        Button btn3 = new Button("Opzioni");
        btn3.setPrefSize(300,100);
        btn3.setMinHeight(70);
        btn3.setFont(fontBottoni);
        btn3.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY, Insets.EMPTY)));
        btn3.setEffect(shadow);
        disposizioneVerticaleBottoni.getChildren().add(btn3);
         //Adding the shadow when the mouse cursor is on
        btn3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btn3.setEffect(is);
        });
        //Removing the shadow when the mouse cursor is off
        btn3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btn3.setEffect(shadow);
        });
        
        HBox contenitoreTitolo = new HBox();
        contenitoreTitolo.setAlignment(Pos.CENTER);
        contenitoreTitolo.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY, Insets.EMPTY)));
        menu.setTop(contenitoreTitolo);
        Text titolo = new Text("AWAY FROM THE MILKY WAY");
        titolo.setId("fancytext");
        titolo.setFont(Font.font(null, FontWeight.BOLD, 80));
        titolo.setEffect(is);
        titolo.setFill(YELLOW);
        contenitoreTitolo.getChildren().add(titolo);
        menu.setTop(contenitoreTitolo);
                
        Pane contenitoreImmagine = new Pane();
        Image immagine = new Image("https://wallpapercave.com/wp/kiv5I70.jpg");
        ImageView nodoImmagine = new ImageView();//ho dovuto usare ImageView altrimenti l'immagine non sarebbe stata un nodo e non l'avrei potuta mettere nell'Anchor pane
        nodoImmagine.setImage(immagine);
        nodoImmagine.fitWidthProperty().bind(contenitoreImmagine.widthProperty());
        nodoImmagine.fitHeightProperty().bind(contenitoreImmagine.heightProperty());
        contenitoreImmagine.getChildren().add(nodoImmagine);
        menu.setCenter(contenitoreImmagine);
        
       
        
        
        
        return menu;
    }//end method disegnaGui
    
}
