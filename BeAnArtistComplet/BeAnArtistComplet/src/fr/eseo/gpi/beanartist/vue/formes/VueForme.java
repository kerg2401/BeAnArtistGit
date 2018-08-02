package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.formes.Forme;

public abstract class VueForme {
  protected final Forme forme;

  /*
   * Constructeurs
   */
  public VueForme(Forme f) {
    forme = f;
  }

  /*
   * Méthodes de classe
   */
  public Forme getForme() {
    return forme;
  }

  /*
   * Méthodes abstraites
   */
  public abstract void affiche(Graphics2D g2d);
}
