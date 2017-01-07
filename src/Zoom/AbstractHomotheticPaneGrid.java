package Zoom;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.shape.Line;

/**
 * Classe abstraite décrivant un Pane contenant une grille et dont la mise à l'échelle est toujours homothétique
 * @author saporito
 */
public abstract class AbstractHomotheticPaneGrid extends AbstractHomotheticPane {
    
    // Style et tailles à attribuer aux réalisations de cette classe abstraite
    private static final String STYLE = "-fx-background-color: lightgrey; -fx-border-color: blue;";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    /** Group contenant la grille */
    protected final Group grid = new Group();
    
    /**
     * Initialiser le composant et créer la grille 
     * (ce constructeur de classe abstraite sera appelé depuis le constructeur de ses réalisations) 
     */
    
    public AbstractHomotheticPaneGrid() {
        // Créer la grille
        //setStyle(STYLE);
        //super.setWidth(WIDTH);
        //super.setHeight(HEIGHT);
        /*for (int i=50; i< HEIGHT-1;i+=50)
        {
            Line line_H= new Line();
            line_H.setStartX(i);
            line_H.setStartY(0);
            line_H.setEndX(i);
            line_H.setEndY(WIDTH);
            grid.getChildren().add(line_H);
            
            Line line_V= new Line();
            line_V.setStartX(0);
            line_V.setStartY(i);
            line_V.setEndX(HEIGHT);
            line_V.setEndY(i);
            grid.getChildren().add(line_V);
            
            ChangeListener the_listener = new ChangeListener<Double>(){
                @Override
                public void changed(ObservableValue<? extends Double> observable, Double first_width, Double second_width) {
                        line_V.setStrokeWidth(1/getScale());
                        line_H.setStrokeWidth(1/getScale());
                }

            };
        scaleProperty().addListener(the_listener);
        }*/
        super.getChildren().add(grid);
    }
}
