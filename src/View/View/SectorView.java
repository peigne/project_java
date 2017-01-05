package View.View;

import View.Interfaces.ISector;

import View.Xanthane.CartographyManagerXanthane;
import View.Xanthane.VertexXanthane;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class SectorView extends Group{
    public static visualparameters.VisualParameters param = visualparameters.VisualParametersManager.load();
    private List<ISector> Sector;
    private List<VertexXanthane> Vertex;
    
    public SectorView(){
        CartographyManagerXanthane cartographyManager = new CartographyManagerXanthane();
        this.Sector = (List<ISector>)cartographyManager.loadSectors(param.getFileSectors());
        

           try{ 
             JAXBContext jaxbContextBalise = JAXBContext.newInstance(VertexXanthane.class);
             System.out.println("ok");
             Unmarshaller jaxbUnmarshaller = jaxbContextBalise.createUnmarshaller();
             Vertex = (List<VertexXanthane>)jaxbUnmarshaller.unmarshal(new File(param.getFileSectors()));
            }
           catch (JAXBException je) {
            je.printStackTrace();
            throw new ExceptionInInitializerError("Impossible to load beacons");
        }
 
    }

}