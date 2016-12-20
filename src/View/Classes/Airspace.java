package View.Classes;

/**
 *
 * @author Flo
 */
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import View.Interfaces.ISector;
import View.Interfaces.IBeacon;
import View.Interfaces.IZone;
import View.Interfaces.ICartographyManager;

public class Airspace {
    
    private static final int FL = 200;

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

    
    public static List<IBeacon> getPublishedBeacons(List<IBeacon> beacons) {
        List<IBeacon> publishedB=new ArrayList<IBeacon>();
        for (IBeacon beacon : beacons) {
            if (beacon.getType().equals("published")) {
                publishedB.add(beacon);
            }
        }
        return publishedB;
    }
}