/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdragpanzoom.view.controls;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafxdragpanzoom.view.views.AbstractHomotheticPane;
import javafxdragpanzoom.view.views.AbstractHomotheticPaneRectangle;
//DEPLACEMENT DU CARRE BLEU
/**
 *
 * @author darwican
 */
public class HomotheticPaneDragManager {
private double y0;
private double x0;

    public HomotheticPaneDragManager(AbstractHomotheticPane rectangle) {
    x0=0;
    y0=0;
    
    rectangle.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event)
        {
            x0=event.getX();
            y0=event.getY();
            event.consume();

        }
    });
        rectangle.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>()
        {
        @Override
        public void handle(MouseEvent event)
        {
            double dx=event.getX()-x0;
            double dy=event.getY()-y0;
            event.consume();
            rectangle.translate(dx, dy);

        }
        
    });
    
    
}}
