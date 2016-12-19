/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Xanthane;

/**
 *
 * @author Flo
 */

import data.xmladapters.DoublePropertyAdapter;
import View.Interfaces.IPoint;
import javafx.beans.property.DoubleProperty;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="vertex")
public class VertexXanthane
implements IPoint {
    @XmlAttribute(name="lat")
    @XmlJavaTypeAdapter(value=DoublePropertyAdapter.class)
    private DoubleProperty x;
    @XmlAttribute(name="lon")
    @XmlJavaTypeAdapter(value=DoublePropertyAdapter.class)
    private DoubleProperty y;

    @Override
    public DoubleProperty xProperty() {
        return this.x;
    }

    @Override
    public DoubleProperty yProperty() {
        return this.y;
    }

    @Override
    public Double getX() {
        return this.x.get();
    }

    @Override
    public Double getY() {
        return this.y.get();
    }

    @Override
    public void setY(double y) {
        this.y.set(y);
    }

    @Override
    public void setX(double x) {
        this.x.set(x);
    }

    @Override
    public void set(IPoint p) {
        this.x.set(p.getX().doubleValue());
        this.y.set(p.getY().doubleValue());
    }

    public String toString() {
        return "VertexXanthane(" + this.x.get() + ", " + this.y.get() + ")";
    }
}
