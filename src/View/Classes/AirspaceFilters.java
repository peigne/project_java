package View.Classes;

/**
 *
 * @author Flo
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import View.Interfaces.IBeacon;
import View.Interfaces.ISector;
import View.Interfaces.IZone;

public class AirspaceFilters {
    public static List<ISector> getSectorsFilteredByFL(List<ISector> sectors, int fl) {
        ArrayList<ISector> result = new ArrayList<ISector>(sectors);
        Iterator<ISector> i = result.iterator();
        while (i.hasNext()) {
            ISector sector = i.next();
            int floor = Integer.parseInt(sector.getFloor());
            int ceiling = Integer.parseInt(sector.getCeiling());
            if (floor > fl || ceiling < fl) {
                i.remove();
                continue;
            }
            List<IZone> slices = sector.getSlices();
            Iterator<IZone> j = slices.iterator();
            while (j.hasNext()) {
                IZone slice = j.next();
                floor = Integer.parseInt(slice.getFloor());
                ceiling = Integer.parseInt(slice.getCeiling());
                if (floor <= fl && ceiling >= fl) continue;
                j.remove();
            }
            sector.setSlices(slices);
        }
        return result;
    }

    public static List<IBeacon> getPublishedBeacons(List<IBeacon> beacons) {
        ArrayList<IBeacon> result = new ArrayList<IBeacon>();
        for (IBeacon beacon : beacons) {
            if (!beacon.getType().equals("published")) continue;
            result.add(beacon);
        }
        return result;
    }

}