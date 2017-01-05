/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.View;

import data.param.VisualParameters;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import View.View.Radar;

public final class View extends Control{
    public static visualparameters.VisualParameters param = visualparameters.VisualParametersManager.load();

    public View() {
        this.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(param.getSceneBackgroundColor(), new CornerRadii(0), new Insets(0))}));
        Pane pane = new Pane();
        this.getChildren().add(pane);
        Radar radar = new Radar();
        //SectorView sector=new SectorView();
        pane.getChildren().add(radar);

    }
}

