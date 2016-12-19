package View.Interfaces;

import java.util.List;

/**
 * Interfrace spécifiant les informations disponibles sur un secteur
 * aéronautique
 *
 * @author Pierre Rondin, Nicolas Saporito
 *
 */
public interface ISector {

    /**
     * Obtenir le plancher du secteur en FL
     */
    public String getFloor();

    /**
     * Obtenir le plafond du secteur en FL
     */
    public String getCeiling();

    /**
     * Obtenir le nom du secteur
     */
    public String getName();

    /**
     * Obtenir le nom du centre de contrôle régional
     */
    public String getAcc();

    /**
     * Obtenir une copie de la liste des couches composants le secteur
     */
    public List<IZone> getSlices();

    /**
     * Renseigner la liste des couches de ce secteur
     *
     * @param slices liste des couches (les poignées vers les couches sont
     * conservées mais pas la liste)
     */
    public void setSlices(List<IZone> slices);

}
