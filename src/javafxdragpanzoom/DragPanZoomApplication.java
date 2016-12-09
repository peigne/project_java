package javafxdragpanzoom;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;
import javafxdragpanzoom.view.views.AbstractHomotheticPane;
import javafxdragpanzoom.view.views.AbstractHomotheticPaneRectangle;
import javafxdragpanzoom.view.views.HomotheticPaneGridStandard;
import javafxdragpanzoom.view.views.HomotheticPaneRectangleStandard;
import javafxdragpanzoom.view.controls.HomotheticPanePanManager;
import javafxdragpanzoom.view.controls.HomotheticPaneDragManager;
/**
 * TP POO IENAC minSITA : Manipulation directe, zoom centré souris différencié
 * @author saporito
 */
public class DragPanZoomApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Racine du graphe de scène
        Group root = new Group();

        // Conteneur sur lequel on veut faire du pan & zoom
        AbstractHomotheticPane panAndZoomPane = new HomotheticPaneGridStandard();
        panAndZoomPane.setLayoutX(10);
        panAndZoomPane.setLayoutY(10);
        root.getChildren().add(panAndZoomPane);
        
        // Noeud sur lequel on veut faire du drag
        AbstractHomotheticPaneRectangle rect1 = new HomotheticPaneRectangleStandard();
        rect1.setLayoutX(450);
        rect1.setLayoutY(450);
        panAndZoomPane.getChildren().add(rect1);
        

        //le deplacement
        HomotheticPanePanManager panManager=new HomotheticPanePanManager(panAndZoomPane);
        HomotheticPaneDragManager panDrag = new HomotheticPaneDragManager(rect1);
        // Creation de la scène
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("DragPanZoomDiffInv v2 inv");
        stage.show();
        
        scene.setOnScroll(new EventHandler<ScrollEvent>(){
        

            @Override
            public void handle(ScrollEvent event) {
                if (event.getDeltaY()>0)
                {   
                    panAndZoomPane.setScale(panAndZoomPane.getScale()*1.1,
                    panAndZoomPane.parentToLocal(event.getX(),event.getY()).getX(),
                    panAndZoomPane.parentToLocal(event.getX(),event.getY()).getY());
                }
                else 
                {
                    panAndZoomPane.setScale(panAndZoomPane.getScale()*0.909090909,
                    panAndZoomPane.parentToLocal(event.getX(),event.getY()).getX(),
                    panAndZoomPane.parentToLocal(event.getX(),event.getY()).getY());
                }
            
            }
        });
        
        // Déplacer le noeud avec les touches de direction
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int offset = 50;
                int dx = 0;
                int dy = 0;
                switch (event.getCode()) {
                    case UP:
                        dx = 0;
                        dy = - offset;
                        break;
                        
                    case DOWN:
                        dx = 0;
                        dy = offset;
                        break;
                    case LEFT:
                        dx = - offset;
                        dy = 0;
                        break;
                    case RIGHT:
                        dx = offset;
                        dy = 0;
                        break;
                    case P:                  
                    panAndZoomPane.setScale(panAndZoomPane.getScale()*1.1,
                    rect1.getLayoutX()+50,rect1.getLayoutY()+50);
                    rect1.setScale(rect1.getScale()*1.1);
                    break;
                    case M:                        

                    panAndZoomPane.setScale(panAndZoomPane.getScale()*0.909090909,
                    rect1.getLayoutX()+50,rect1.getLayoutY()+50);
                    break;
                             
                    default:
                        break;
                }
                rect1.setLayoutX(rect1.getLayoutX() + dx);
                rect1.setLayoutY(rect1.getLayoutY() + dy);
            }                        

        });
    }
}
