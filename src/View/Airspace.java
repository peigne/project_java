package View;

/**
 *
 * @author Flo
 */
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/*public class Airspace {
    private HashMap<String,ISector> espaceS;
    private HashMap<String,IBeacon> espaceB;
    
    public Airspace() {
        espaceS=new HashMap<String,ISector>();
        espaceB=new HashMap<String,IBeacon>();
    }
    
    public Airspace(ICartographyManager cartographyManager) {
        List<IBeacon> l_Beacon=cartographyManager.loadBeacons();
        List<ISector> l_Sectors=cartographyManager.loadSectors();
        espaceB=new HashMap<String,IBeacon>();
        espaceS=new HashMap<String,ISector>();
    }
    public boolean containSectors(String s) {
        return espaceS.containsKey(s);
    }
    
    public boolean containBeacon(String s) {
        return espaceB.containsKey(s);
    }
    
    public Map<String,ISector> getSectorByNameMap() {
        return espaceS;
    }
    
    public Map<String,IBeacon> getBeaconByNameMap() {
        return espaceB;
    }
    
    public List<IBeacon> getPublishedBeacons() {
        List<IBeacon> publishedB=new ArrayList<IBeacon>();
        for (Map.Entry<String,IBeacon> l_B : espaceB.entrySet()) {
            if (l_B.getValue().getType()=="published") {
                publishedB.add(l_B.getValue());
            }
        }
        return publishedB;
    }
}*/