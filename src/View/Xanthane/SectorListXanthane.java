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
import View.Xanthane.SectorXanthane;
import View.Interfaces.ISector;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="sectors")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class SectorListXanthane {
    @XmlElement(name="sector")
    private ArrayList<SectorXanthane> sectors;

    public ArrayList<ISector> getSectors() {
        return new ArrayList<ISector>(this.sectors);
    }
}
