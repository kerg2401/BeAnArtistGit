package fr.eseo.gpi.beanartist.modele.formes;

import java.text.DecimalFormat;

public class Ligne extends Forme {
  private static final long serialVersionUID = -6678579485633395349L;
  public static final double EPSILON = 1e-1;

  /*
   * Constructeurs
   */

  public Ligne(Point p1, Point p2) {
    this(p1, p2.getX() - p1.getX(), p2.getY() - p1.getY());
  }

  public Ligne(Point position, double largeur, double hauteur) {
    super(position, largeur, hauteur);
  }

  public Ligne(double x, double y, double largeur, double hauteur) {
    this(new Point(x, y), largeur, hauteur);
  }

  public Ligne(Point point) {
    this(point, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  public Ligne(double largeur, double hauteur) {
    this(new Point(), largeur, hauteur);
  }

  public Ligne() {
    this(new Point(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  /*
   * Getters
   */

  public Point getP1() {
    return getPosition();
  }

  public Point getP2() {
    return new Point(getPosition().getX() + getLargeur(), getPosition().getY() + getHauteur());
  }

  public double getCadreMinX() {
    return Math.min(getX(), getX() + getLargeur());
  }

  public double getCadreMinY() {
    return Math.min(getY(), getY() + getHauteur());
  }

  public double getCadreMaxX() {
    return Math.max(getX(), getX() + getLargeur());
  }

  public double getCadreMaxY() {
    return Math.max(getY(), getY() + getHauteur());
  }

  /*
   * Setters
   */

  public void setP1(Point p) {
    Point p2 = getP2();
    setPosition(p);
    setP2(p2);
  }

  public void setP2(Point p) {
    setLargeur(p.getX() - getPosition().getX());
    setHauteur(p.getY() - getPosition().getY());
  }

  /*
   * Méthodes de classe
   */

  public double aire() {
    return 0;
  }

  public double perimetre() {
    return Math.sqrt(Math.pow(getHauteur(), 2) + Math.pow(getLargeur(), 2));
  }

  public String toString() {
    DecimalFormat df = new DecimalFormat("0.##");
    return "[" + this.getClass().getSimpleName() + "] p1 : " + getPosition().toString() + " p2 : "
        + getP2().toString() + " longueur : " + df.format(perimetre());

  }

  public boolean contient(double x, double y) {
    double dist1 = Math.sqrt(Math.pow(x - getP1().getX(), 2) + Math.pow(y - getP1().getY(), 2));
    double dist2 = Math.sqrt(Math.pow(x - getP2().getX(), 2) + Math.pow(y - getP2().getY(), 2));
    return Math.abs(dist1 + dist2 - perimetre()) < EPSILON;
  }

  public boolean contient(Point position) {
    return contient(position.getX(), position.getY());
  }
}
