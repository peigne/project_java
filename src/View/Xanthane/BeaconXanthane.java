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
    public void setX(double x) {
        this.x.set(x);
    }

    @Override
    public void setY(double y) {
        this.y.set(y);
    }

    @Override
    public void set(IPoint p) {
        this.x.set(p.getX().doubleValue());
        this.y.set(p.getY().doubleValue());
    }

    public String toString() {
        return "BeaconXanthane(code:" + this.getCode() + ", type:" + this.type + ", x:" + this.getX() + ", y:" + this.getY() + ")";
    }
}