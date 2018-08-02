package fr.eseo.gpi.beanartist.modele.formes;

public class Rectangle extends Forme {
  private static final long serialVersionUID = -9159729898073901518L;

  
  /*
   * Constructeurs
   */

  public Rectangle(Point position, double largeur, double hauteur) {
    super(position, largeur, hauteur);
    if (largeur < 0) {
      throw new IllegalArgumentException("(largeur < 0)");
    }
    if (hauteur < 0) {
      throw new IllegalArgumentException("(hauteur < 0)");
    }
  }

  // Constructeur avec une position fixee mais taille par defaut
  public Rectangle(Point point) {
    this(point, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  // Constructeur avec position par défaut et largeur / hauteur fixees
  public Rectangle(double largeur, double hauteur) {
    this(new Point(), largeur, hauteur);
  }

  // Constructeur avec position sous formes de nombres + largeur/hauteurs
  public Rectangle(double x, double y, double largeur, double hauteur) {
    this(new Point(x, y), largeur, hauteur);
  }

  // Constructeur avec position par défaut
  public Rectangle() {
    this(new Point(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
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
    return getLargeur() * getHauteur();
  }

  public double perimetre() {
    return getLargeur() * 2 + getHauteur() * 2;
  }

  public boolean contient(double x, double y) {
    return x >= getX() && x <= getCadreMaxX() && y >= getY() && y <= getCadreMaxY();
  }

  public boolean contient(Point position) {
    return contient(position.getX(),position.getY());
  }
}