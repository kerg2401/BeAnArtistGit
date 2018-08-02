package fr.eseo.gpi.beanartist.modele.formes;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;
// @author Thomas CRAVIC
public class Trace extends Forme {
  private static final long serialVersionUID = 2133511501450421295L;
  private List<Point> points = new ArrayList<Point>();

  /*
   * Constructeurs
   */
//@author Thomas CRAVIC
  public Trace(Point pos1, Point pos2) {
    super(pos1, 0, 0);
    this.ajouterPoint (pos1);
    this.ajouterPoint(pos2);
  }
//@author Thomas CRAVIC
  public Trace() {
    this(new Point());

  }
//@author Thomas CRAVIC
  public Trace(Point pos1) {
    super(pos1, 0, 0);
    this.ajouterPoint(pos1);
  }

  /*
   * Getters
   */
//@author Thomas CRAVIC
  public List<Point> getPoints() {
    return points;
  }

  /*
   * Setters
   */
//@author Thomas CRAVIC
  public void setPosition(Point p) {
    double dx = p.getX() - getX();
    double dy = p.getY() - getY();
    deplacerDe(dx, dy);
  }
//@author Thomas CRAVIC
  public void setX(double x) {
    double dx = x - getX();
    deplacerDe(dx, 0);
  }
//@author Thomas CRAVIC
  public void setY(double y) {
    double dy = y - getY();
    deplacerDe(0, dy);
  }
//@author Thomas CRAVIC
  public void setHauteur(double height) {
    double ratio = height / getHauteur();
    for (Point p : points) {
      p.setY(getY() + (p.getY() - getY()) * ratio);
    }
    super.setHauteur(height);
  }
//@author Thomas CRAVIC
  public void setLargeur(double width) {
    double ratio = width / getLargeur();
    for (Point p : points) {
      p.setX(getX() + (p.getX() - getX()) * ratio);
    }
    super.setLargeur(width);
  }

  /*
   * M�thodes de classe
   */
//@author Thomas CRAVIC
  public void deplacerDe(double dx, double dy) {
    super.deplacerDe(dx, dy); // On change la position du point de d�part
    // On change la position de chacun des points relativement au d�placement
    for (Point point : points) {
      point.deplacerDe(dx, dy);
    }
  }
//@author Thomas CRAVIC
  public void deplacerVers(double x, double y) {
    double dx = x - getX();
    double dy = y - getY();
    deplacerDe(dx, dy);
  }
//@author Thomas CRAVIC
  public void ajouterPoint(Point p) {
    points.add(p);
    double maxX = Double.MIN_VALUE;
    double minX = Double.MAX_VALUE;
    double maxY = Double.MIN_VALUE;
    double minY = Double.MAX_VALUE;

    for (Point point : points) {
      if (point.getX() < minX)
        minX = point.getX();
      if (point.getX() > maxX)
        maxX = point.getX();
      if (point.getY() < minY)
        minY = point.getY();
      if (point.getY() > maxY)
        maxY = point.getY();

      super.setPosition(new Point(minX, minY));
      super.setHauteur(maxY - minY);
      super.setLargeur(maxX - minX);
    }
  }
//@author Thomas CRAVIC
  public String toString() {
    String str = new String();
    DecimalFormat df = new DecimalFormat("0.##");
    str += "[" + this.getClass().getSimpleName() + "] pos : " + getPosition().toString()
        + " dim : ";
    str += df.format(getLargeur()) + " x " + df.format(getHauteur());
    str += " longueur : " + df.format(perimetre());
    str += " nbSegments : " + df.format(points.size() - 1);
    return str;
  }
//@author Thomas CRAVIC
  public double aire() {
    return 0;
  }
//@author Thomas CRAVIC
  public double perimetre() {
    double perimetre = 0;
    Point p1, p2;
    for (int i = 0; i < points.size() - 1; i++) {
      p1 = points.get(i);
      p2 = points.get(i + 1);
      perimetre += Math
          .sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }
    return perimetre;
  }
//@author Thomas CRAVIC
  public boolean contient(double x, double y) {
    Ligne l = new Ligne();
    for (int i = 0; i < points.size() - 1; i++) {
      l.setP1(points.get(i));
      l.setP2(points.get(i + 1));
      if (l.contient(x, y)) {
        return true;
      }
    }
    return false;
  }
//@author Thomas CRAVIC
  public boolean contient(Point position) {
    return contient(position.getX(), position.getY());
  }
}
