package View.Xanthane;

import data.xmladapters.DoublePropertyAdapter;
import View.Interfaces.IBeacon;
import View.Interfaces.IPoint;
import View.Classes.Point;
import javafx.beans.property.DoubleProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="point")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class BeaconXanthane extends Point implements IBeacon {
    @XmlAttribute(name="code")
    private String code;
    
    @XmlAttribute(name="type")
    private String type;
    
    @XmlAttribute(name="lat")
    @XmlJavaTypeAdapter(value=DoublePropertyAdapter.class)
    private DoubleProperty x;
    
    @XmlAttribute(name="lon")
    @XmlJavaTypeAdapter(value=DoublePropertyAdapter.class)
    private DoubleProperty y;

    public  BeaconXanthane() {
    }
    
    public BeaconXanthane(Point p) {
        super(p);
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "BeaconXanthane(code:" + this.getCode() + ", type:" + this.type + ", x:" + this.getX() + ", y:" + this.getY() + ")";
    }
}