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
import View.Xanthane.BeaconXanthane;
import View.Interfaces.IBeacon;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="points")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class BeaconListXanthane {
    @XmlElement(name="point")
    private ArrayList<BeaconXanthane> beacons;

    public ArrayList<IBeacon> getBeacons() {
        return new ArrayList<IBeacon>(this.beacons);
    }

    public String toString() {
        String res = "BeaconListXanthane(";
        for (BeaconXanthane beacon : this.beacons) {
            res = res + beacon + " ";
        }
        res = res + ")";
        return res;
    }
}
