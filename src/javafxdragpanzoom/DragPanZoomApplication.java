package javafxdragpanzoom;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxdragpanzoom.view.views.AbstractHomotheticPane;
import javafxdragpanzoom.view.views.AbstractHomotheticPaneRectangle;
import javafxdragpanzoom.view.views.HomotheticPaneGridStandard;
import javafxdragpanzoom.view.views.HomotheticPaneRectangleStandard;
import javafxdragpanzoom.view.controls.HomotheticPanePanManager;
import javafxdragpanzoom.view.controls.HomotheticPaneDragManager;
import javafxdragpanzoom.view.controls.KeyControl;
import javafxdragpanzoom.view.controls.ScrollEvent;
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

        // Conteneur grid
        AbstractHomotheticPane grid = new HomotheticPaneGridStandard();//faut voir si on met pan ou pangrid
        grid.setLayoutX(0);
        grid.setLayoutY(0);
        root.getChildren().add(grid);
        
        // Conteneur rectangle bleu
        AbstractHomotheticPaneRectangle rectangle = new HomotheticPaneRectangleStandard(grid);
        rectangle.setLayoutX(450);
        rectangle.setLayoutY(450);
        grid.getChildren().add(rectangle);
        
        // Creation de la scène
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Image Radar");
       
        //les reactions au touches du clavier
        KeyControl key=new KeyControl(scene,grid,rectangle);
        
        //les reactions du scroll
        ScrollEvent zoom= new ScrollEvent(scene, grid);
        
        //les deplacements
        HomotheticPanePanManager panManager=new HomotheticPanePanManager(grid);
        HomotheticPaneDragManager panDrag = new HomotheticPaneDragManager(rectangle);
        
        // affichage final
        stage.show();
        
       
        
        
    }
}
