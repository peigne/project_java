/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import Zoom.AbstractHomotheticPane;


/**
 *
 * @author darwich
 */
public class ScrollEvent {
    public ScrollEvent(Scene scene,AbstractHomotheticPane grid )
    { 
        scene.setOnScroll(new EventHandler<javafx.scene.input.ScrollEvent>(){
        

            @Override
            public void handle(javafx.scene.input.ScrollEvent event)
            {
                grid.addScale(event.getDeltaY(),
                grid.parentToLocal(event.getX(),event.getY()).getX(),
                grid.parentToLocal(event.getX(),event.getY()).getY());

            }
        });}
}
