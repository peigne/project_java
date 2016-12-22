
package data.xmladapters;

/**
 *
 * @author Flo
 */
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoublePropertyAdapter
extends XmlAdapter<String, DoubleProperty> {
    private DoubleProperty x;

    @Override
    public DoubleProperty unmarshal(String value) throws Exception {
        this.x = new SimpleDoubleProperty();
        this.x.set(Double.parseDouble(value));
        return this.x;
    }

    @Override
    public String marshal(DoubleProperty value) throws Exception {
        return Double.toString(value.get());
    }
}