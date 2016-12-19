package View.Classes;

/**
 *
 * @author Flo
 */
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import View.Interfaces.ISector;
import View.Interfaces.IBeacon;
import View.Interfaces.IZone;
import View.Interfaces.ICartographyManager;

public class AirspaceFilters {
    
    private static final int FL = 200;

    private HashMap<String,ISector> espaceS;
    private HashMap<String,IBeacon> espaceB;
    
    public AirspaceFilters() {
        espaceS=new HashMap<String,ISector>();
        espaceB=new HashMap<String,IBeacon>();
    }
    
    public AirspaceFilters(ICartographyManager cartographyManager) {
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
    public static List<ISector> getSectorsFilteredByFL(List<ISector> sectors) {
        ArrayList<ISector> result = new ArrayList<ISector>(sectors);
        Iterator<ISector> i = result.iterator();
        while (i.hasNext()) {
            ISector sector = i.next();
            int floor = Integer.parseInt(sector.getFloor());
            int ceiling = Integer.parseInt(sector.getCeiling());
            if (floor > 200 || ceiling < 200) {
                i.remove();
                continue;
            }
            List<IZone> slices = sector.getSlices();
            Iterator<IZone> j = slices.iterator();
            while (j.hasNext()) {
                IZone slice = j.next();
                floor = Integer.parseInt(slice.getFloor());
                ceiling = Integer.parseInt(slice.getCeiling());
                if (floor <= 200 && ceiling >= 200) continue;
                j.remove();
            }
            sector.setSlices(slices);
        }
        return result;
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