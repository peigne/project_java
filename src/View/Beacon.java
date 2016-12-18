package View;

/**
 *
 * @author Flo
 */

public class Beacon extends Point implements IBeacon {
    
    private String nom;
    private String etat;

    public Beacon(double x, double y,String nom) {
        super(x, y);
        this.nom=nom;
    }
    
    
    @Override
    public String getCode() {
        return nom;
    }

    @Override
    public String getType() {
        return etat;       
    }
}
