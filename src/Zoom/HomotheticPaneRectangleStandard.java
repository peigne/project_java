/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoom;

import View.View.Etiquette;
import View.Classes.Flight;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;


/**
 *
 * @author darwich
 */
public class HomotheticPaneRectangleStandard extends Etiquette {
    private Affine transformation_1;
    
    public HomotheticPaneRectangleStandard (AbstractHomotheticPane pane, Flight flight) {
        super(pane,flight);
        transformation_1= new Affine();
        this.getTransforms().add(transformation_1);
        
        
    }

    @Override
    public void setScale(double scale) {
        scaleProperty().setValue(scale);
        }

    @Override
    public void setScale(double scale,double pivotX,double pivotY) {

        transformation_1.setToTransform(1/scale,0,transformation_1.getTx(),0, 1/scale,transformation_1.getTy());
       
        
   }

    @Override
    public void addScale(double deltaScale, double pivotX, double pivotY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void translate(double dx, double dy) {
        transformation_1.appendTranslation(dx,dy);
   }
    
}

