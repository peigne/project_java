
package data.xmladapters;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanPropertyAdapter
extends XmlAdapter<String, BooleanProperty> {
    private BooleanProperty s;

    @Override
    public BooleanProperty unmarshal(String value) throws Exception {
        this.s = new SimpleBooleanProperty();
        this.s.setValue(Boolean.valueOf(value));
        return this.s;
    }

    @Override
    public String marshal(BooleanProperty value) throws Exception {
        return Boolean.toString(value.get());
    }
}

