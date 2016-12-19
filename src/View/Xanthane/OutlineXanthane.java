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

import View.Xanthane.CentreXanthane;
import View.Xanthane.VertexXanthane;
import View.Interfaces.IPoint;
import View.Interfaces.IZone;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="outline")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class OutlineXanthane
implements IZone {
    @XmlElement(name="centre")
    private CentreXanthane centre;
    @XmlElement(name="vertex")
    private ArrayList<VertexXanthane> vertexes;
    @XmlAttribute(name="floor")
    private String floor;
    @XmlAttribute(name="ceiling")
    private String ceiling;

    @Override
    public CentreXanthane getCentre() {
        return this.centre;
    }

    @Override
    public String getFloor() {
        return this.floor;
    }

    @Override
    public String getCeiling() {
        return this.ceiling;
    }

    public ArrayList<IPoint> getVertexes() {
        return new ArrayList<IPoint>(this.vertexes);
    }

    @Override
    public Double[] getVertexesXYArray() {
        Double[] resultat = new Double[this.vertexes.size() * 2];
        int i = 0;
        for (VertexXanthane vertexCourant : this.vertexes) {
            resultat[i] = vertexCourant.getX();
            resultat[++i] = vertexCourant.getY();
            ++i;
        }
        return resultat;
    }
}