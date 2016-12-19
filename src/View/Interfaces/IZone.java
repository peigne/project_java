package View.Interfaces;

import java.util.List;

/**
 * Zone représentant un espace convexe (par exemple les différentes couches d'un
 * secteur ou les contours de carte)
 *
 * @author Pierre Rondin
 */
public interface IZone {

    /**
     * Obtenir le centre de la zone
     */
    public IPoint getCentre();

    /**
     * Obtenir le FL du plancher de la zone
     */
    public String getFloor();

    /**
     * Obtenir le FL du plafond de la zone
     */
    public String getCeiling();

    /**
     * Obtenir une copie de la liste des points constituants la zone
     */
    public List<IPoint> getVertexes();

    /**
     * Obtenir un tableau de Double contenant l'ensemble des points constituants
     * la zone. Tableau sous la forme [x0, y0, x1, y1,...]
     */
    public Double[] getVertexesXYArray();

}
