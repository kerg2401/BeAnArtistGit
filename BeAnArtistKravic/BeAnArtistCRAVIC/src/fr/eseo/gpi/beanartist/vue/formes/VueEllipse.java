package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.formes.Ellipse;

public class VueEllipse extends VueForme {
  /*
   * Constructeurs
   */
  public VueEllipse() {
    this(new Ellipse());
  }

  public VueEllipse(Ellipse ellipse) {
    super(ellipse);
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
    g2d.drawOval(x, y, largeur, hauteur);

  }
}
