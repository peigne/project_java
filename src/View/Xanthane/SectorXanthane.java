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
import View.Xanthane.SliceXanthane;
import View.Interfaces.ISector;
import View.Interfaces.IZone;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="sector")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class SectorXanthane implements ISector {
    @XmlAttribute(name="name")
    private String name;
    @XmlElement(name="slice")
    private ArrayList<SliceXanthane> slices;
    @XmlAttribute(name="floor")
    private String floor;
    @XmlAttribute(name="ceiling")
    private String ceiling;
    @XmlAttribute(name="acc")
    private String acc;

    @Override
    public String getAcc() {
        return this.acc;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getFloor() {
        return this.floor;
    }

    @Override
    public String getCeiling() {
        return this.ceiling;
    }

    @Override
    public List<IZone> getSlices() {
        return new ArrayList<IZone>(this.slices);
    }

    @Override
    public void setSlices(List<IZone> slices) {
        this.slices.clear();
        for (IZone slice : slices) {
            this.slices.add((SliceXanthane)slice);
        }
    }

    public String toString() {
        return "SectorXanthane(name:" + this.name + ", acc:" + this.acc + ", floor:" + this.floor + ", ceiling:" + this.ceiling + ", slices:" + this.getSlices() + ")";
    }
}
