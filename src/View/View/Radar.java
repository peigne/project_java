/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.View;

import View.Xanthane.CartographyManagerXanthane;
import data.param.VisualParameters;
import data.param.VisualParametersManager;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import View.Classes.Airspace;
import View.Interfaces.IBaseMap;
import View.Interfaces.IBeacon;
import View.Interfaces.ISector;
import View.View.BaseMapView;
import Zoom.AbstractHomotheticPane;
import java.util.Map;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.transform.Affine;
import javafx.scene.layout.Pane;
/**
 *
 * @author Florian
 */
public class Radar extends Pane{
    private AirspaceView airspace;
    private BaseMapView basemap;
    public static visualparameters.VisualParameters param = visualparameters.VisualParametersManager.load();
    public Radar(AbstractHomotheticPane grid){
       
        basemap = new BaseMapView(grid);
        airspace = new AirspaceView(grid);
        this.getChildren().addAll(new Node[]{this.basemap});
        this.getChildren().addAll(new Node[]{this.airspace});
    }
    
}
