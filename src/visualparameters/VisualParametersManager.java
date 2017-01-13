package visualparameters;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class VisualParametersManager {
    public static VisualParameters load() {
        try {
            File file =new File("src/xml/param.xml");
            JAXBContext jaxbContextSecteurs = JAXBContext.newInstance(VisualParameters.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextSecteurs.createUnmarshaller();
            VisualParameters visu= (VisualParameters) jaxbUnmarshaller.unmarshal(file);
            return (visu);
            }
        catch (JAXBException ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Impossible to load parameters!!!!");
        }
    }

    public static void save(VisualParameters param) throws JAXBException {
        JAXBContext jaxbContextSecteurs = JAXBContext.newInstance(VisualParameters.class);
        Marshaller jaxbMarshaller = jaxbContextSecteurs.createMarshaller();
        jaxbMarshaller.setProperty("jaxb.formatted.output", true);
        jaxbMarshaller.marshal((Object)param, new File("../java_projet/src/data/param/param.xml"));
    }
}

