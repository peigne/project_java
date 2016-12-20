
package View.Xanthane;

/**
 *
 * @author Flo
 */
import View.Xanthane.BaseMapXanthane;
import View.Xanthane.BeaconListXanthane;
import View.Xanthane.SectorListXanthane;
import View.Classes.AirspaceFilters;
import View.Classes.CoordinatesTransforms;
import View.Interfaces.IBaseMap;
import View.Interfaces.IBeacon;
import View.Interfaces.ICartographyManager;
import View.Interfaces.ISector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class CartographyManagerXanthane implements ICartographyManager {
    
    @Override
    public List<IBeacon> loadBeacons() {
        try {
            JAXBContext jaxbContextBalise = JAXBContext.newInstance(BeaconListXanthane.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextBalise.createUnmarshaller();
            BeaconListXanthane balisesXanthane = (BeaconListXanthane)jaxbUnmarshaller.unmarshal(new File("points.xml"));
            List result = balisesXanthane.getBeacons();
            result = AirspaceFilters.getPublishedBeacons(result);
            CoordinatesTransforms.beaconsLatLonToCautra(result);
            return result;
        }
        catch (JAXBException je) {
            throw new ExceptionInInitializerError("Impossible to load beacons");
        }
    }

    @Override
    public List<ISector> loadSectors() {
        try {
            JAXBContext jaxbContextSecteurs = JAXBContext.newInstance(SectorListXanthane.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextSecteurs.createUnmarshaller();
            SectorListXanthane sectorListXanthane = (SectorListXanthane)jaxbUnmarshaller.unmarshal(new File("sectors.xml"));
            List result = sectorListXanthane.getSectors();
            result = AirspaceFilters.getSectorsFilteredByFL(result,200);
            CoordinatesTransforms.sectorsLatLonToCautra(result);
            return result;
        }
        catch (JAXBException je) {
            throw new ExceptionInInitializerError("Impossible to load sectors");
        }
    }

    @Override
    public IBaseMap loadBaseMap() {
        try {
            JAXBContext jaxbContextFondCarte = JAXBContext.newInstance(BaseMapXanthane.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextFondCarte.createUnmarshaller();
            BaseMapXanthane map = (BaseMapXanthane)jaxbUnmarshaller.unmarshal(new File("france.xml"));
            CoordinatesTransforms.latLonToCautra(map);
            return map;
        }
        catch (JAXBException je) {
            throw new ExceptionInInitializerError("Impossible to load base map");
        }
    }
}