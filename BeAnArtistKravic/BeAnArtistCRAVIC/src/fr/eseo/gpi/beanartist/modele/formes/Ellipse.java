package fr.eseo.gpi.beanartist.modele.formes;

public class Ellipse extends Forme {
  private static final long serialVersionUID = -381241016647278766L;

  /*
   * Constructeurs
   */

  public Ellipse(Point point, double largeur, double hauteur) {
    super(point, largeur, hauteur);
    if (largeur < 0) {
      throw new IllegalArgumentException("(largeur < 0)");
    }
    if (hauteur < 0) {
      throw new IllegalArgumentException("(hauteur < 0)");
    }
  }

  public Ellipse() {
    this(new Point(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  public Ellipse(Point point) {
    this(point, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  public Ellipse(double x, double y, double largeur, double hauteur) {
    this(new Point(x, y), largeur, hauteur);
  }

  public Ellipse(double largeur, double hauteur) {
    this(new Point(), largeur, hauteur);
  }

  /*
   * Setters
   */

  public void setLargeur(double largeur) {
    if (largeur < 0) {
      throw new IllegalArgumentException("(largeur < 0)");
    } else {
      super.setLargeur(Math.abs(largeur));
    }
  }

  public void setHauteur(double hauteur) {
    if (hauteur < 0) {
      throw new IllegalArgumentException("(hauteur < 0)");
    } else {
      super.setHauteur(Math.abs(hauteur));
    }
  }

  /*
   * Méthodes de classe
   */

  public double aire() {
    return Math.PI * getLargeur() / 2 * getHauteur() / 2;
  }

  public double perimetre() {
    double b = getHauteur() / 2;
    double a = getLargeur() / 2;
    double h = Math.pow((a - b) / (a + b), 2);
    return Math.PI * (a + b) * (1 + 3 * h / (10 + Math.sqrt(4 - 3 * h)));
  }

  public boolean contient(double x, double y) {
    double rx = getLargeur() / 2;
    double ry = getHauteur() / 2;
    double h = getX() + rx;
    double k = getY() + ry;

    double result = Math.pow(x - h, 2) / Math.pow(rx, 2) + Math.pow(y - k, 2) / Math.pow(ry, 2);

    return result <= 1;
  }

  public boolean contient(Point position) {
    return contient(position.getX(), position.getY());
  }
}
