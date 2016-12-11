/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdragpanzoom.view.views;

import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import static javafx.scene.transform.Transform.affine;


/**
 *
 * @author darwich
 */
public class HomotheticPaneRectangleStandard extends AbstractHomotheticPaneRectangle {
    
    public HomotheticPaneRectangleStandard (AbstractHomotheticPane pane) {
        super(pane);
        // La seule chose à faire ici est de lier le mécanisme de mise à l'échelle
        // lié au choix d'implémentation (les méthodes standard setScaleX...)
        // au mécanisme de gestion de la mise à l'échelle homothétique 
        // et au modèle issus d'AbstractHomotheticPane.
        // Toutes les transformations se feront ensuite directement sur le modèle 
        // via les méthodes setScale(...) réalisées dans cette classe.
        scaleXProperty().bind(scaleProperty());
        scaleYProperty().bind(scaleProperty());
        Affine transfo= new Affine();
        this.getTransforms().add(transfo);
        
        
    }

    @Override
    public void setScale(double scale) {
        scaleProperty().setValue(scale);
        }

    @Override
    public void setScale(double scale, double pivotX, double pivotY) {
        System.out.println("zoom_affine");
        Affine transfo= new Affine();
        transfo.appendScale(1/scale, 1/scale, pivotX, pivotY);
        this.getTransforms().set(0,transfo);
        System.err.println("this"+this.getTransforms()+"TT");
       
        
   }

    @Override
    public void addScale(double deltaScale, double pivotX, double pivotY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void translate(double dx, double dy) {
        this.setLayoutX(this.getLayoutX()+dx);
        this.setLayoutY(this.getLayoutY()+dy);
   }
    
}

