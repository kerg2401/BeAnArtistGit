package fr.eseo.gpi.beanartist.modele.formes;

public class Cercle extends Ellipse {
  private static final long serialVersionUID = 1113551939466556524L;

  /*
   * Constructeurs
   */

  public Cercle(Point p, double diametre) {
    super(p, diametre, diametre);
  }

  // Constructeur avec position
  public Cercle(Point p) {
    this(p, Ellipse.LARGEUR_PAR_DEFAUT);
  }

  // Constructeur avec diametre
  public Cercle(double diametre) {
    this(new Point(), diametre);
  }

  // Constructeur vide
  public Cercle() {
    this(new Point(), Ellipse.LARGEUR_PAR_DEFAUT);
  }

  // Constructeur avec position sous forme de double
  public Cercle(double x, double y, double diametre) {
    this(new Point(x, y), diametre);
  }

  /*
   * Setters
   */

  public void setHauteur(double h) {
    super.setHauteur(h);
    super.setLargeur(h);
  }

  public void setLargeur(double l) {
    setHauteur(l);
  }

  /*
   * Méthodes de classe
   */

  public double aire() {
    return Math.PI * Math.pow(this.getLargeur() / 2, 2);
  }

  public double perimetre() {
    return Math.PI * getLargeur();
  }
}
