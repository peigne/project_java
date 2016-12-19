
package View.Xanthane;

/**
 *
 * @author Flo
 */
import View.Xanthane.OutlineXanthane;
import View.Interfaces.IBaseMap;
import View.Interfaces.IZone;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="map")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class BaseMapXanthane
implements IBaseMap {
    @XmlElement(name="outline")
    ArrayList<OutlineXanthane> outlines;

    @Override
    public List<IZone> getZones() {
        return new ArrayList<IZone>(this.outlines);
    }

}
