package Zoom;

import java.awt.Point;
import javafx.geometry.Point2D;
import javafx.scene.transform.Affine;

/**
 * Pane homothétique dont la mise à l'échelle est gérée par les méthodes
 * standard de Node
 *
 * @author saporito
 */
public class HomotheticPaneGridStandard extends AbstractHomotheticPaneGrid {

   private  Affine transfo;


    public HomotheticPaneGridStandard() {
        super();
        //scaleXProperty().bind(scaleProperty());
        //scaleYProperty().bind(scaleProperty());
        transfo = new Affine();
        this.getTransforms().add(transfo);

    }

    @Override
    public void setScale(double scale) {
        scaleProperty().setValue(scale);

    }

    @Override
    public void setScale(double scale, double pivotX, double pivotY) {
        /*Point point2D= new Point();
        point2D.setLocation(localToScreen(pivotX,pivotY).getX(),localToScreen(pivotX,pivotY).getY());
        scaleProperty().setValue(scale);        
        translate(point2D.getX()-localToScreen(pivotX,pivotY).getX(),point2D.getY()-localToScreen(pivotX,pivotY).getY());*/
        transfo.appendScale(scale, scale,pivotX,pivotY);
        scaleProperty().setValue(getScale()*scale);

    }

    @Override
    public void addScale(double deltaScale, double pivotX, double pivotY) {
    if (deltaScale>0)
                {   
                    setScale(1.1,pivotX,pivotY);
                }
                else 
                {
                    setScale(1/1.1,pivotX,pivotY);

                }    
    }
    
        
    @Override
    public void translate(double dx, double dy) {
        transfo.appendTranslation(this.getLayoutX()+dx, this.getLayoutY()+dy);

    }

}
