package View.View;

import View.Interfaces.IBaseMap;
import View.Interfaces.IZone;
import View.Xanthane.CartographyManagerXanthane;
import Zoom.AbstractHomotheticPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class BaseMapView extends Group{
    public static visualparameters.VisualParameters param = visualparameters.VisualParametersManager.load();
    private IBaseMap basemap;
    
    public BaseMapView(AbstractHomotheticPane grid){
        CartographyManagerXanthane cartographyManager = new CartographyManagerXanthane();
        this.basemap = cartographyManager.loadBaseMap(this.param.getFileBaseMap());
        for (IZone zone : basemap.getZones()) {
            Double[] points = zone.getVertexesXYArray();
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(points);
            polygon.setStroke(param.getBaseMapStrokeColor());
            polygon.setFill(param.getBaseMapFillColor());
            this.getChildren().add(polygon);
            ChangeListener the_listener = new ChangeListener<Double>()
            {
            @Override
            public void changed(ObservableValue<? extends Double> observable, Double first_width, Double second_width) 
                {
                        polygon.setStrokeWidth(1/grid.getScale());
                }

            };
            grid.scaleProperty().addListener(the_listener); 
        }
    }

}
