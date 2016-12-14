/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdragpanzoom.view.views;

import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;


/**
 *
 * @author darwich
 */
public class HomotheticPaneRectangleStandard extends AbstractHomotheticPaneRectangle {
    private Affine transformation_1;
    
    public HomotheticPaneRectangleStandard (AbstractHomotheticPane pane) {
        super(pane);
        // La seule chose à faire ici est de lier le mécanisme de mise à l'échelle
        // lié au choix d'implémentation (les méthodes standard setScaleX...)
        // au mécanisme de gestion de la mise à l'échelle homothétique 
        // et au modèle issus d'AbstractHomotheticPane.
        // Toutes les transformations se feront ensuite directement sur le modèle 
        // via les méthodes setScale(...) réalisées dans cette classe.
        transformation_1= new Affine();
        this.getTransforms().add(transformation_1);
        
        
    }

    @Override
    public void setScale(double scale) {
        scaleProperty().setValue(scale);
        }

    @Override
    public void setScale(double scale, double pivotX, double pivotY) {
        transformation_1.setToTransform(1/scale,0,pivotX,0, 1/scale,pivotY);
        System.err.println(transformation_1);
       
        
   }

    @Override
    public void addScale(double deltaScale, double pivotX, double pivotY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void translate(double dx, double dy) {
        this.setLayoutX(this.getLayoutX()+dx);
        this.setLayoutY(this.getLayoutY()+dy);
        //transformation_1.appendTranslation(this.getLayoutX()+dx, this.getLayoutY()+dy);
        System.err.println("ca marche pas");
   }
    
}

