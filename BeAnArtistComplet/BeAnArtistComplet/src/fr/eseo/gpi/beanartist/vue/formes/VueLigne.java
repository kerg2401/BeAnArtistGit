package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.formes.Ligne;

public class VueLigne extends VueForme {
  /*
   * Constructeurs
   */
  public VueLigne() {
    this(new Ligne());
  }

  public VueLigne(Ligne ligne) {
    super(ligne);
  }

  /*
   * Méthodes de classe
   */
  public void affiche(Graphics2D g2d) {
    int x1 = (int) Math.round(getForme().getX());
    int y1 = (int) Math.round(getForme().getY());
    int x2 = (int) Math.round((getForme().getX() + getForme().getLargeur()));
    int y2 = (int) Math.round((getForme().getY() + getForme().getHauteur()));
    g2d.setColor(getForme().getCouleurLigne());
    g2d.drawLine(x1, y1, x2, y2);

  }
}
