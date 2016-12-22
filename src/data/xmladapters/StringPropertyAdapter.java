package data.xmladapters;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringPropertyAdapter
extends XmlAdapter<String, StringProperty> {
    private StringProperty s;

    @Override
    public StringProperty unmarshal(String value) throws Exception {
        this.s = new SimpleStringProperty();
        //this.s.set((Object)value);
        return this.s;
    }

    @Override
    public String marshal(StringProperty value) throws Exception {
        return (String)value.get();
    }
}

