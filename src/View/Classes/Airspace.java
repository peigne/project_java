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
import java.util.Map.Entry;
import visualparameters.VisualParameters;
import visualparameters.VisualParametersManager;

public class Airspace {

    private HashMap<String,ISector> espaceS=new HashMap<String,ISector>();
    private HashMap<String,IBeacon> espaceB=new HashMap<String,IBeacon>();
    
    public Airspace(ICartographyManager cartographyManager) {
        VisualParameters param = VisualParametersManager.load();
        List<IBeacon> l_Beacon=cartographyManager.loadBeacons(param.getFileBeacons());
        List<ISector> l_Sectors=cartographyManager.loadSectors(param.getFileSectors());
        for (ISector sector : l_Sectors) {
            espaceS.put(sector.getName(), sector);
        }
        for (IBeacon beacon: l_Beacon) {
            espaceB.put(beacon.getCode(), beacon);
        }       
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
        for (Entry<String,IBeacon> entry :espaceB.entrySet()){
            if (entry.getKey().equals("published")){
                publishedB.add(entry.getValue());
            }
        }
        return publishedB;
    }
}