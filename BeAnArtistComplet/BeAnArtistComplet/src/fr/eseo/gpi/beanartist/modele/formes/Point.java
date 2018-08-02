package fr.eseo.gpi.beanartist.modele.formes;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Point implements Serializable {
  private static final long serialVersionUID = 560119375454349082L;
  // Variables d'instance
  private double posX;
  private double posY;

  /*
   * Constructeurs
   */

  public Point(double x, double y) {
    this.posX = x;
    this.posY = y;
  }

  // Constructeur avec position par défaut
  public Point() {
    this(0, 0);
  }

  /*
   * Getters
   */

  public double getX() {
    return posX;
  }

  public double getY() {
    return posY;
  }

  /*
   * Setters
   */

  public void setX(double x) {
    this.posX = x;
  }

  public void setY(double y) {
    this.posY = y;
  }

  /*
   * Méthodes de classe
   */

  public String toString() {
    String str = new String();
    DecimalFormat df = new DecimalFormat("0.##");
    str = "(";
    str += df.format(posX);
    str += " , ";
    str += df.format(posY);
    str += ")";
    return str;
  }

  public void deplacerVers(double x, double y) {
    this.posX = x;
    this.posY = y;
  }

  public void deplacerDe(double deltaX, double deltaY) {
    this.posX += deltaX;
    this.posY += deltaY;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(posX);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(posY);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    /*
     * if (!(obj instanceof Point)) { return false; }
     */
    Point other = (Point) obj;
    if (Double.doubleToLongBits(posX) != Double.doubleToLongBits(other.posX)) {
      return false;
    }
    if (Double.doubleToLongBits(posY) != Double.doubleToLongBits(other.posY)) {
      return false;
    }
    return true;
  }
}