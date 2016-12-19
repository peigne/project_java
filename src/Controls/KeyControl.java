/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import Zoom.AbstractHomotheticPane;
import Zoom.AbstractHomotheticPaneRectangle;
/**
 *
 * @author darwich
 */
public class KeyControl {
    public KeyControl(Scene scene,AbstractHomotheticPane paneGridStandard,AbstractHomotheticPaneRectangle rectangle)
    {
    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int offset = 50;
                int dx = 0;
                int dy = 0;
                switch (event.getCode()) {
                    case UP:
                        dx = 0;
                        dy = - offset;
                        break;
                        
                    case DOWN:
                        dx = 0;
                        dy = offset;
                        break;
                    case LEFT:
                        dx = - offset;
                        dy = 0;
                        break;
                    case RIGHT:
                        dx = offset;
                        dy = 0;
                        break;
                    case P:                  
                    paneGridStandard.addScale(1,rectangle.getLayoutX()+50,rectangle.getLayoutY()+50);
                    break;
                    case M:                        
                    paneGridStandard.addScale(-1,rectangle.getLayoutX()+50,rectangle.getLayoutY()+50);
                    break;
                             
                    default:
                        break;
                }
                rectangle.setLayoutX(rectangle.getLayoutX() + dx);
                rectangle.setLayoutY(rectangle.getLayoutY() + dy);
                System.err.println("ok");
            }                        

        });
    }
    
}
