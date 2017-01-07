package utilsgeo;

import View.Interfaces.IPoint;
import View.Classes.Point;
import View.Interfaces.IBeacon;

public class ConversionCautra {
    private static final double PI_4 = 0.7853981633974483;
    private static final double DEG_EN_RAD = 0.017453292519943295;
    private static final double MILLE_N = 1852.0;
    private static final double DEMI_GRAND_AXE = 6378137.0;
    private static final double A_WGS84 = 3443.918466522678;
    private static final double E_WGS84 = 0.0818191908426;
    private static final double E2_WGS84 = 0.0066943799901378;
    private static final double LATC_D = 47.0;
    private static final double LATC_R = ConversionCautra.degToRad(47.0);
    private static final double SINL = Math.sin(LATC_R);
    private static final double N = 3443.918466522678 / Math.sqrt(1.0 - 0.0066943799901378 * SINL * SINL);
    private static final double L0 = ConversionCautra.lat_conforme(LATC_R);
    private static final double R0 = N * Math.cos(LATC_R) / Math.cos(L0);

    private static double degToRad(double x) {
        return x * 0.017453292519943295;
    }

    private static double lat_conforme(double lat) {
        double coef = Math.pow((1.0 - 0.0818191908426 * Math.sin(lat)) / (1.0 + 0.0818191908426 * Math.sin(lat)), 0.0409095954213);
        double lc = 2.0 * (Math.atan(coef * Math.tan(0.7853981633974483 + lat / 2.0)) - 0.7853981633974483);
        return lc;
    }

    public static void latLonToCautra(IBeacon beacon) {
        double lat=beacon.getX();
        double lon = beacon.getY();
        double lat_r = ConversionCautra.degToRad(lat);
        double lon_r = ConversionCautra.degToRad(lon);
        double lc = ConversionCautra.lat_conforme(lat_r);
        double kp = 2.0 / (1.0 + Math.sin(L0) * Math.sin(lc) + Math.cos(L0) * Math.cos(lc) * Math.cos(lon_r));
        double x_res = kp * R0 * Math.cos(lc) * Math.sin(lon_r);
        double y_res = kp * R0 * (Math.cos(L0) * Math.sin(lc) - Math.sin(L0) * Math.cos(lc) * Math.cos(lon_r));
        Point p=new Point(x_res, y_res);
        beacon.set(p);
    }
    
    public static IPoint latLonToCautra(double lat, double lon) {
        double lat_r = ConversionCautra.degToRad(lat);
        double lon_r = ConversionCautra.degToRad(lon);
        double lc = ConversionCautra.lat_conforme(lat_r);
        double kp = 2.0 / (1.0 + Math.sin(L0) * Math.sin(lc) + Math.cos(L0) * Math.cos(lc) * Math.cos(lon_r));
        double x_res = kp * R0 * Math.cos(lc) * Math.sin(lon_r);
        double y_res = kp * R0 * (Math.cos(L0) * Math.sin(lc) - Math.sin(L0) * Math.cos(lc) * Math.cos(lon_r));
        return new Point(x_res, y_res);
    }
}
