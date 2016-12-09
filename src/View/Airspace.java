package View;

/**
 *
 * @author Flo
 */
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Airspace {
    private HashMap<String,ISector> espaceS;
    private HashMap<String,IBeacon> espaceB;
    
    public Airspace() {
        espaceS=new HashMap<String,ISector>();
        espaceB=new HashMap<String,IBeacon>();
    }
    
    public Airspace(ICartographyManager cartographyManager) {
        List<IBeacon> l_Beacon=cartographyManager.loadBeacons();
        List<IBeacon> l_Sectors=cartographyManager.loadSectors();
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
}
