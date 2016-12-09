package javafxdragpanzoom.view.views;
import java.awt.Point;

/**
 * Pane homothétique dont la mise à l'échelle est gérée par les méthodes standard de Node
 * @author saporito
 */
public class HomotheticPaneGridStandard extends AbstractHomotheticPaneGrid {

    public HomotheticPaneGridStandard() {
        super();
        scaleXProperty().bind(scaleProperty());
        scaleYProperty().bind(scaleProperty());
        
    }

    @Override
    public void setScale(double scale) {
        scaleProperty().setValue(scale);
        
    }

    @Override
    public void setScale(double scale, double pivotX, double pivotY) {
        Point point2D= new Point();
        point2D.setLocation(localToScreen(pivotX,pivotY).getX(),localToScreen(pivotX,pivotY).getY());
        scaleProperty().setValue(scale);        
        translate(point2D.getX()-localToScreen(pivotX,pivotY).getX(),point2D.getY()-localToScreen(pivotX,pivotY).getY());
        
                

    }

    @Override
    public void addScale(double deltaScale, double pivotX, double pivotY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void translate(double dx, double dy) {
        this.setLayoutX(getLayoutX()+dx);
        this.setLayoutY(getLayoutY()+dy);
          }
    
}
