package View.View;
import View.Classes.Flight;
import Zoom.AbstractHomotheticPane;
import static View.View.AirspaceView.param;
import static java.awt.PageAttributes.ColorType.COLOR;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;


/**
 * Classe abstraite décrivant un Pane contenant un rectangle et dont la mise à l'échelle est toujours homothétique 
 * @author saporito
 */
public abstract class Etiquette extends AbstractHomotheticPane {

    /**
     * Initialiser le composant et créer le rectangle 
     * (ce constructeur de classe abstraite sera appelé depuis le constructeur de ses réalisations)
     * @param pane
     */
    public Etiquette(AbstractHomotheticPane pane, Flight flight) {

        //parametres texte
        Text text = new Text(flight.getGroundSpeed()+"\n"+flight.getCallSign()+
                                "\n"+flight.getFl()+"\n"+flight.getSector());
        text.setFill(param.getLabelFillColor());
        
        //creation du conteneur de texte
        Rectangle etiquette = new Rectangle(100, 100);
        etiquette.setFill(Color.TRANSPARENT);
        
        
        //creation du stackpane
        StackPane stack = new StackPane();
        stack.getChildren().addAll(etiquette , text); 
        
        //ajout du stackpane a la view
        super.getChildren().add(stack);

            ChangeListener the_second_listener = new ChangeListener<Double>(){
            
                @Override
                public void changed(ObservableValue<? extends Double> observable, Double high, Double second_high) {
                        setScale(pane.getScale(),0,0);
                }
            };
            
            //abonnement a la scaleproperty du conteur view
            pane.scaleProperty().addListener(the_second_listener);
            
    }
    
}
