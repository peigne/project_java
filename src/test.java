/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flo
 */

import View.Interfaces.IBaseMap;
import View.Interfaces.ICartographyManager;
import View.Xanthane.CartographyManagerXanthane;
import java.util.List;
import View.Classes.Airspace;
import View.Interfaces.IBeacon;
import View.Interfaces.ISector;
import data.param.VisualParameters;
import data.param.VisualParametersManager;

public class test {
    public static VisualParameters param = VisualParametersManager.load();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
    ICartographyManager cartographyManager = new CartographyManagerXanthane();
    List<IBeacon> lb=cartographyManager.loadBeacons(param.getFileBeacons());
    //Airspace airspace=new Airspace(cartographyManager);
    //IBaseMap baseMap=cartographyManager.loadBaseMap(this.param.getFileBaseMap());
    System.out.println(lb);
    }
}
