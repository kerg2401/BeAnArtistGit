package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.formes.Rectangle;

public class VueRectangle extends VueForme {
  /*
   * Constructeurs
   */
  public VueRectangle() {
    this(new Rectangle());
  }

  public VueRectangle(Rectangle rect) {
    super(rect);
  }

  /*
   * Méthodes de classe
   */
  public void affiche(Graphics2D g2d) {
    int x = (int) Math.round(getForme().getX());
    int y = (int) Math.round(getForme().getY());
    int largeur = (int) Math.round(getForme().getLargeur());
    int hauteur = (int) Math.round(getForme().getHauteur());
    g2d.setColor(getForme().getCouleurLigne());
    g2d.drawRect(x, y, largeur, hauteur);
  }
}
