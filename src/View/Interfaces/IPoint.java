package View.Interfaces;

import javafx.beans.property.DoubleProperty;

/**
 * Interface spécifiant les informations disponibles sur un point
 *
 * @author Pierre Rondin, Nicolas Saporito
 */
public interface IPoint {

    /**
     * Obtenir la Property englobant l'abscisse (coordonnées Cautra)
     */
    public DoubleProperty xProperty();

    /**
     * Obtenir la Property englobant l'ordonnée (coordonnées Cautra)
     */
    public DoubleProperty yProperty();

    /**
     * Obtenir l'abscisse (coordonnées Cautra)
     */
    public Double getX();

    /**
     * Obtenir l'ordonnée (coordonnées Cautra)
     */
    public Double getY();

    /**
     * Fixer l'abscisse (coordonnées Cautra)
     */
    public void setX(double x);

    /**
     * Fixer l'ordonnée (coordonnées Cautra)
     */
    public void setY(double y);

    /**
     * Fixer de nouvelles coordonnées
     *
     * @param p Point dont les coordonnées sont à recopier
     */
    public void set(IPoint p);

}
