
package data.xmladapters;

import javafx.scene.paint.Color;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ColorAdapter
extends XmlAdapter<String, Color> {
    @Override
    public Color unmarshal(String value) throws Exception {
        return Color.valueOf((String)value);
    }

    @Override
    public String marshal(Color value) throws Exception {
        return value.toString();
    }
}

