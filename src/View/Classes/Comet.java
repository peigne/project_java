package View.Classes;

/**
 *
 * @author picaudfl
 *anas fait un test/
public class Comet {

    private Point[] tab;

    public Comet(Point p1) {
        this.tab[0] = new Point(p1);
    }

    public Point getP1() {
        return tab[0];
    }

    public Point getP2() {
        return tab[1];
    }

    public Point getP3() {
        return tab[2];
    }

    public Point getP4() {
        return tab[3];
    }

    public Point getP5() {
        return tab[4];
    }

    public void ajoutCoordonnees(Point p) {
        for (int i = 1; i < 5; i++) {
            tab[i] = new Point(tab[i - 1]);
        }
        tab[0].set(p);
    }
}
