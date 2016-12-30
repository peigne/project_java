package View.View;

import View.Interfaces.IBaseMap;
import View.Interfaces.IZone;
import View.Xanthane.CartographyManagerXanthane;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class BaseMapView extends Group{
    public static visualparameters.VisualParameters param = visualparameters.VisualParametersManager.load();
    private IBaseMap basemap;
    
    public BaseMapView(){
        CartographyManagerXanthane cartographyManager = new CartographyManagerXanthane();
        this.basemap = cartographyManager.loadBaseMap(this.param.getFileBaseMap());
        for (IZone zone : basemap.getZones()) {
            Double[] points = zone.getVertexesXYArray();
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(points);
            polygon.setStroke((Paint)param.getBaseMapStrokeColor());
            polygon.setFill((Paint)param.getBaseMapFillColor());
            this.getChildren().add(polygon);
        }
    }

}
