package fr.eseo.gpi.beanartist.modele.formes;

import java.awt.Color;
import java.io.Serializable;
import java.text.DecimalFormat;

import javax.swing.UIManager;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public abstract class Forme implements Serializable {

  private static final long serialVersionUID = 1;
  public static final double LARGEUR_PAR_DEFAUT = 100;
  public static final double HAUTEUR_PAR_DEFAUT = 150;
  public static final Color COULEUR_LIGNE_PAR_DEFAUT = UIManager.getColor("Panel.foreground");

  private Point position;
  private double largeur;
  private double hauteur;
  private Color couleurLigne;
  
  /*
   * Constructeurs
   */

  public Forme() {
    this(new Point(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  public Forme(double x, double y, double largeur, double hauteur) {
    this(new Point(x, y), largeur, hauteur);
  }

  public Forme(Point position, double largeur, double hauteur) {
    this.position = position;
    this.largeur = largeur;
    this.hauteur = hauteur;
    this.couleurLigne = FenetreBeAnArtist.getInstance().getPanneauDessin().getCouleurCourante();
  }

  public Forme(double largeur, double hauteur) {
    this(new Point(), largeur, hauteur);
  }

  public Forme(Point position) {
    this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  /*
   * Getters
   */

  public Point getPosition() { return position;}
  public double getLargeur() { return largeur;}
  public double getHauteur() { return hauteur;}
  public double getX() { return getPosition().getX();}
  public double getY() { return getPosition().getY();}
  public double getCadreMinX() { return Math.min(getX(), getX() + getLargeur());}
  public double getCadreMinY() { return Math.min(getY(), getY() + getHauteur());}
  public double getCadreMaxX() { return Math.max(getX(), getX() + getLargeur());}
  public double getCadreMaxY() { return Math.max(getY(), getY() + getHauteur());}
  public Color getCouleurLigne() { return couleurLigne;}

  /*
   * Setters
   */

  public void setPosition(Point pos) { this.position = pos;}
  public void setLargeur(double largeur) { this.largeur = largeur;}
  public void setHauteur(double hauteur) { this.hauteur = hauteur;}
  public void setX(double x) { this.position.setX(x);}
  public void setY(double y) { this.position.setY(y);}
  public void setCouleurLigne(Color c) { couleurLigne = c;}
  
  /*
   * M�thodes de classe
   */

  public void deplacerVers(double x, double y) {
    this.position.deplacerVers(x, y);
  }

  public void deplacerDe(double x, double y) {
    this.position.deplacerDe(x, y);
  }

  public String toString() {
    String str = new String();
    DecimalFormat df = new DecimalFormat("0.##");
    str += "[" + this.getClass().getSimpleName() + "] pos " + getPosition().toString() + " dim ";
    str += df.format(getLargeur()) + " x " + df.format(getHauteur());
    str += " périmètre : " + df.format(perimetre());
    str += " aire : " + df.format(aire());
    return str;
  }

  /*
   * M�thodes abstraites
   */

  public abstract double aire();
  public abstract double perimetre();
  public abstract boolean contient(double x, double y);
  public abstract boolean contient(Point pos);
}
