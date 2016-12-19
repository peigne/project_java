/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import Zoom.AbstractHomotheticPane;
//import javafxdragpanzoom.view.views.AbstractHomotheticPaneGrid;
//DEPLACEMENT DU CARRE GRILLE
/**
 *
 * @author darwican
 */
public class HomotheticPanePanManager
{
private double y0;
private double x0;


    public HomotheticPanePanManager(AbstractHomotheticPane grid) 
    {
    x0=0;
    y0=0;
    
    grid.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event)
        {
            x0=event.getX();
            y0=event.getY();
            event.consume();
            
        }
    });
        grid.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event)
        {  
            double dx=event.getX()-x0;
            double dy=event.getY()-y0;
            grid.translate(dx, dy);
            event.consume();

        }
        
    });

 

}
}
