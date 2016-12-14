package javafxdragpanzoom.view.views;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Affine;


/**
 * Classe abstraite décrivant un Pane contenant un rectangle et dont la mise à l'échelle est toujours homothétique 
 * @author saporito
 */
public abstract class AbstractHomotheticPaneRectangle extends AbstractHomotheticPane {

    /**
     * Initialiser le composant et créer le rectangle 
     * (ce constructeur de classe abstraite sera appelé depuis le constructeur de ses réalisations)
     * @param pane
     */
    public AbstractHomotheticPaneRectangle(AbstractHomotheticPane pane) {
        // Créer le rectangle
        // Option 1 : origine en haut à gauche
        
        Rectangle rect = new Rectangle(100, 100);
        rect.setStroke(Color.BLUE);
        rect.setStrokeType(StrokeType.INSIDE);
        rect.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.5));
        ChangeListener the_second_listener = new ChangeListener<Double>(){
            
                @Override
                public void changed(ObservableValue<? extends Double> observable, Double high, Double second_high) {
                        setScale(pane.getScale(),rect.getLayoutX(),rect.getLayoutY());
                        
                        
                        
                }
            };
            
            pane.scaleProperty().addListener(the_second_listener);
            
            super.getChildren().add(rect);
            
            
            
    }
    
}
