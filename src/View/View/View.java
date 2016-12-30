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
    private static Dimension SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
    public static double SCREEN_HEIGHT = SCREEN_DIMENSIONS.getHeight();
    public static double SCREEN_WIDTH = SCREEN_DIMENSIONS.getWidth();
    public static visualparameters.VisualParameters param = visualparameters.VisualParametersManager.load();

    public View() {
        this.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(param.getSceneBackgroundColor(), new CornerRadii(0.0), new Insets(0.0))}));
        Pane pane = new Pane();
        this.getChildren().add(pane);
        Radar radar = new Radar();
        pane.getChildren().add(radar);
        //MenusManager.createAndManageGeneralMenu(pane);
        //MenusManager.createAndManageGeneralContextMenu(this);
        //radar.translate(SCREEN_WIDTH / 2.0, SCREEN_HEIGHT / 2.0);
        //double dsH = SCREEN_WIDTH / radarViewPane.getBoundsInLocal().getWidth();
        //double dsV = SCREEN_HEIGHT / radarViewPane.getBoundsInLocal().getHeight();
        //radarViewPane.addScale(Math.min(dsH, dsV), 0.0, 0.0);
    }
}

