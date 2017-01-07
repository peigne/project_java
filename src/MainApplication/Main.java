package MainApplication;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Zoom.AbstractHomotheticPane;
import Zoom.AbstractHomotheticPaneRectangle;
import Zoom.HomotheticPaneGridStandard;
import Zoom.HomotheticPaneRectangleStandard;
import Controls.HomotheticPanePanManager;
import Controls.HomotheticPaneDragManager;
import Controls.KeyControl;
import Controls.ScrollEvent;
import View.Interfaces.IBeacon;
import View.Interfaces.ICartographyManager;
import View.Xanthane.CartographyManagerXanthane;
import visualparameters.VisualParameters;
import visualparameters.VisualParametersManager;
import View.Interfaces.ISector;
import View.Interfaces.IBaseMap;
import View.View.View;
import java.util.List;
import javafx.scene.Parent;
import View.Classes.Airspace;

public class Main extends Application {
    public static VisualParameters param = VisualParametersManager.load();

    public static void main(String[] args) 
    {
        Main.launch((String[])args);
    }

    @Override
    public void start(Stage stage) 
    {
        //parametres stages.
        stage.setFullScreen(true);

        // Racine du graphe de scène
        Group root = new Group();

        // Conteneur grid
        AbstractHomotheticPane grid = new HomotheticPaneGridStandard();
        grid.setLayoutX(400);
        grid.setLayoutY(50);
        root.getChildren().add(grid);
        
        //importation de la carte
        View view = new View(grid);
        grid.getChildren().add(view);
        view.setLayoutX(200);
        view.setLayoutY(300);
        
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
        KeyControl key=new KeyControl(scene,grid,rectangle);//a refaire
        
        //les reactions du scroll
        ScrollEvent zoom= new ScrollEvent(scene, grid);
        
        //les deplacements
        HomotheticPanePanManager panManager=new HomotheticPanePanManager(grid);
        HomotheticPaneDragManager panDrag = new HomotheticPaneDragManager(rectangle);
        
        // affichage final
        stage.show();
    }      
    
}
