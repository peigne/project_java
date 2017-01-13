package MainApplication;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Zoom.AbstractHomotheticPane;
import View.View.Etiquette;
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
import View.Classes.Flight;
import View.Classes.Ivy_communication;
import java.util.ArrayList;
import static javafx.application.Application.launch;
public class Main extends Application {
    
    public static VisualParameters param = VisualParametersManager.load();
    public ArrayList<Flight> list_flight=new ArrayList<Flight>();
    public AbstractHomotheticPane grid = new HomotheticPaneGridStandard();
    public Ivy_communication simulation= new Ivy_communication(list_flight,grid);

    public static void main(String[] args) 
    {
        
        Main.launch((String[])args);
    
    }

    @Override
    public void start(Stage stage) 
    {
        stage.setFullScreen(true);

        // Conteneur grid
  
        
        //importation de la carte
        View view = new View(grid);
        Flight flight=new Flight(1, "anas",200, 0, 0, 20, 20, 180, "anazs", 82);
        
        // Conteneur rectangle bleu
        Etiquette rectangle = new HomotheticPaneRectangleStandard(grid, flight);
        rectangle.setLayoutX(450);
        rectangle.setLayoutY(450);
        grid.getChildren().add(rectangle);
        
        // Creation de la scène
        Scene scene = new Scene(view);
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
    
    @Override
    public void stop(){
        simulation.stop();
    }
    
}
