
package View.Xanthane;

/**
 *
 * @author Flo
 */

import View.Classes.AirspaceFilters;
import View.Classes.CoordinatesTransforms;
import View.Interfaces.IBaseMap;
import View.Interfaces.IBeacon;
import View.Interfaces.ICartographyManager;
import View.Interfaces.ISector;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class CartographyManagerXanthane implements ICartographyManager {

    
    
    @Override
    public List<IBeacon> loadBeacons(String nom_fic) {
        try {
            JAXBContext jaxbContextBalise = JAXBContext.newInstance(BeaconListXanthane.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextBalise.createUnmarshaller();
            BeaconListXanthane balisesXanthane = (BeaconListXanthane)jaxbUnmarshaller.unmarshal(new File(nom_fic));
            List result = balisesXanthane.getBeacons();
            result = AirspaceFilters.getPublishedBeacons(result);
            CoordinatesTransforms.beaconsLatLonToCautra(result); 
            return result;
        }
        catch (JAXBException je) {
            je.printStackTrace();
            throw new ExceptionInInitializerError("Impossible to load beacons");
        }
    }
    

    @Override
    public List<ISector> loadSectors(String nom_fic) {
        try {
            File fic= new File(nom_fic);
            JAXBContext jaxbContextSecteurs = JAXBContext.newInstance(SectorListXanthane.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextSecteurs.createUnmarshaller();
            SectorListXanthane sectorListXanthane = (SectorListXanthane)jaxbUnmarshaller.unmarshal(fic);
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
    public IBaseMap loadBaseMap(String nom_fic) {
        try {
            JAXBContext jaxbContextFondCarte = JAXBContext.newInstance(BaseMapXanthane.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextFondCarte.createUnmarshaller();
            BaseMapXanthane map = (BaseMapXanthane)jaxbUnmarshaller.unmarshal(new File(nom_fic));
            CoordinatesTransforms.latLonToCautra(map);
            return map;
        }
        catch (JAXBException je) {
            throw new ExceptionInInitializerError("Impossible to load base map");
        }
    }
}