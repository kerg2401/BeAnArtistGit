package fr.eseo.gpi.beanartist.vue.formes;

import fr.eseo.gpi.beanartist.modele.formes.Cercle;

public class VueCercle extends VueEllipse {
  /*
   * Constructeurs
   */
  public VueCercle() {
    this(new Cercle());
  }

  public VueCercle(Cercle cercle) {
    super(cercle);
  }
}
