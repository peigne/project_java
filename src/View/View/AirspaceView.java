
package View.View;

import View.Classes.Airspace;
import View.Interfaces.IBeacon;
import View.Interfaces.ISector;
import View.Interfaces.IZone;

import View.Xanthane.CartographyManagerXanthane;
import View.Xanthane.VertexXanthane;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
/**
 *
 * @author flori
 */
public class AirspaceView extends Group{
    public static visualparameters.VisualParameters param = visualparameters.VisualParametersManager.load();
    private Airspace airspace;
    
    public AirspaceView(){
        CartographyManagerXanthane cartographyManager = new CartographyManagerXanthane();
        airspace=new Airspace(cartographyManager);
        Map<String,ISector> list_sector=airspace.getSectorByNameMap();
        List<IBeacon> list_beacon=airspace.getPublishedBeacons();
        for (Map.Entry<String,ISector> entry :list_sector.entrySet()){
            for (IZone zone : entry.getValue().getSlices()){
                Double[] points = zone.getVertexesXYArray();
                Polygon polygon = new Polygon();
                polygon.getPoints().addAll(points);
                polygon.setStroke(param.getSectorStrokeColor());
                polygon.setFill(param.getSectorFillColor());
                this.getChildren().add(polygon);
            }
        }
        
    }
}
