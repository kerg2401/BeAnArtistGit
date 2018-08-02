package fr.eseo.gpi.beanartist.modele.formes;

public class Carre extends Rectangle {
  private static final long serialVersionUID = 4806308283424698065L;

  /*
   * Constructeurs
   */

  // Constructeur vide
  public Carre() {
    super(LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
  }

  // Constructeur avec position par d�faut, et cot� d�fini
  public Carre(double cote) {
    this(new Point(), cote);
  }

  // Constructeur avec position et cot� d�finis
  public Carre(Point point, double cote) {
    super(point, cote, cote);
  }

  // Constructeur avec position par d�faut
  public Carre(Point point) {
    this(point, LARGEUR_PAR_DEFAUT);
  }

  // Constructeur avec position par d�faut sous forme de doubles
  public Carre(double x, double y, double cote) {
    this(new Point(x, y), cote);
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
}
