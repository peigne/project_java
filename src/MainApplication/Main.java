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
import java.util.List;


public class Main extends Application {
    public static VisualParameters param = VisualParametersManager.load();

    public static void main(String[] args) {
        System.out.println(param.getBeaconSize());
        ICartographyManager cartographyManager = new CartographyManagerXanthane();
        List<IBeacon> lb=cartographyManager.loadBeacons(param.getFileBeacons());
        
        //IBaseMap map= cartographyManager.loadBaseMap();
        //System.out.println(map.getZones());
        //List<ISector> li= cartographyManager.loadSectors();
        //System.err.println(li.get(0).getFloor());
        //System.out.println(lb.get(0).getCode());
        //Airspace airspace=new Airspace(cartographyManager);
        //IBaseMap baseMap=cartographyManager.loadBaseMap(this.param.getFileBaseMap());
        //System.out.println(lb);
        launch(args);
        //ICartographyManager cartographyManager = new CartographyManagerXanthane();
        //List<IBeacon> lb=cartographyManager.loadBeacons(param.getFileBeacons());
    //Airspace airspace=new Airspace(cartographyManager);
    //IBaseMap baseMap=cartographyManager.loadBaseMap(this.param.getFileBaseMap());
    System.out.println(lb);

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
