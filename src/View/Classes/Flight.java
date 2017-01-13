package View.Classes;
import View.Classes.Comet;
import javafx.beans.property.IntegerProperty;
/**
 *
 * @author flori
 */
public class Flight {
    
    private int flight;
    private Comet comete;
    private String callSign;
    private int groundSpeed;
    private int fl;
    private int heading;
    private String type;
    private Point position;
    private String sector;
    private double Vx;
    private double Vy;
    //constructeur
    public Flight(int flight,String nom, int fl, double x,double y,double Vx,double Vy,int heading,String sector,int speed){
        this.flight=flight;
        this.callSign=nom;
        this.Vx=Vx;
        position=new Point(x,y);
        this.fl=fl;
        this.Vy=Vy;
        this.heading=heading;
        this.sector=sector;
        this.groundSpeed=speed;
        comete=new Comet(position);
    }
    
    public void update(String sector,double x,double y,double Vx, double Vy,int fl,int heading,int groundspeed){
        comete.ajoutCoordonnees(position);
        position.setX(x);
        position.setY(y);
        this.fl=fl;
        this.Vy=Vy;
        this.Vx=Vx;
        this.heading=heading;
        this.sector=sector;
        this.groundSpeed=groundspeed;
    }

    public int getFlight() {
        return flight;
    }

    public Comet getComete() {
        return comete;
    }

    public String getCallSign() {
        return callSign;
    }

    public int getGroundSpeed() {
        return groundSpeed;
    }

    public int getFl() {
        return fl;
    }

    public int getHeading() {
        return heading;
    }

    public String getType() {
        return type;
    }

    public Point getPosition() {
        return position;
    }

    public String getSector() {
        return sector;
    }

    public double getVx() {
        return Vx;
    }

    public double getVy() {
        return Vy;
    }
    
    
}
