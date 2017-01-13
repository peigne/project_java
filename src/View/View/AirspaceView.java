
package View.View;

import View.Classes.Airspace;
import View.Interfaces.IBeacon;
import View.Interfaces.ISector;
import View.Interfaces.IZone;

import View.Xanthane.CartographyManagerXanthane;
import View.Xanthane.VertexXanthane;
import Zoom.AbstractHomotheticPane;
import Zoom.HomotheticPaneGridStandard;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import java.lang.Math;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;
/**
 *
 * @author flori
 */
public class AirspaceView extends Group{
    public static visualparameters.VisualParameters param = visualparameters.VisualParametersManager.load();
    private Airspace airspace;
    
    public AirspaceView(AbstractHomotheticPane grid){
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
                Text text = new Text(zone.getCentre().getX(), zone.getCentre().getY(), entry.getKey());
                text.setFill(param.getSectorTextFillColor());
                this.getChildren().add(text);
                ChangeListener the_listener = new ChangeListener<Double>(){
                @Override
                public void changed(ObservableValue<? extends Double> observable, Double first_width, Double second_width) {
                        polygon.setStrokeWidth(1/grid.getScale());
                }

            };
        grid.scaleProperty().addListener(the_listener); 
            }
        }
        float dx=param.getBeaconSize();
        double d=(dx/(grid.getScale()*grid.getScale()));
        for (IBeacon beacon : list_beacon){
            Double[] position = {beacon.getX(),beacon.getY()};
            //Double[] points = {position[0],position[1]-1.5*dx,position[0]-dx/2,position[1]-dx/2,position[0]+dx/2,position[1]-dx/2};
            Double[] points = {position[0],position[1]-1.5*d,position[0]-d/2,position[1]-d/2,position[0]+d/2,position[1]-d/2};
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(points);
            polygon.setStroke(param.getBeaconStrokeColor());
            polygon.setFill(param.getBeaconFillColor());
            this.getChildren().add(polygon);
            Text text = new Text(beacon.getCode());
            text.setFill((Paint)param.getBeaconTextFillColor());
            text.setScaleX(0.6);
            text.setScaleY(0.6);
            text.setLayoutX(position[0]);
            text.setLayoutY(position[1]);
            this.getChildren().add(text);
            ChangeListener beacon_listener = new ChangeListener<Double>(){
                @Override
                public void changed(ObservableValue<? extends Double> observable, Double first_width, Double second_width) {
                        if (grid.getScale()>1.3)
                        {
                        text.setScaleX(1/(grid.getScale()));
                        text.setScaleY(1/(grid.getScale()));
                        polygon.setScaleX(1/grid.getScale());
                        polygon.setScaleY(1/grid.getScale());
                        }
                        
                        if (grid.getScale()<1)
                        {
                            text.setScaleX(grid.getScale());
                            text.setScaleY(grid.getScale());                            
                            polygon.setScaleX(grid.getScale());
                            polygon.setScaleY(grid.getScale());// a revoir
                            
                        }
                        else
                        text.setLayoutX(position[0]-d);
                        text.setLayoutY(position[1]+d);
                }

            };
                    grid.scaleProperty().addListener(beacon_listener); 

        }
    }
}