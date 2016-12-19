package View.Classes;

import View.Interfaces.IBeacon;
import View.Interfaces.IBaseMap;
import View.Interfaces.IPoint;
import View.Interfaces.ISector;
import View.Interfaces.IZone;
import java.util.List;
import utilsgeo.ConversionCautra;

public class CoordinatesTransforms {
    
    private static void latLonToCautra(IPoint p) {
        IPoint res = ConversionCautra.latLonToCautra(p.getX(), p.getY());
        res.setY(- res.getY().doubleValue());
        p.set(res);
    }

    public static void beaconsLatLonToCautra(List<IBeacon> beacons) {
        for (IBeacon beacon : beacons) {
            CoordinatesTransforms.latLonToCautra((IPoint) beacon);
        }
    }

    public static void sectorsLatLonToCautra(List<ISector> sectors) {
        for (ISector sector : sectors) {
            for (IZone slice : sector.getSlices()) {
                CoordinatesTransforms.latLonToCautra(slice.getCentre());
                for (IPoint vertex : slice.getVertexes()) {
                    CoordinatesTransforms.latLonToCautra(vertex);
                }
            }
        }
    }

    public static void latLonToCautra(IBaseMap baseMap) {
        for (IZone zone : baseMap.getZones()) {
            for (IPoint vertex : zone.getVertexes()) {
                CoordinatesTransforms.latLonToCautra(vertex);
            }
        }
    }
}