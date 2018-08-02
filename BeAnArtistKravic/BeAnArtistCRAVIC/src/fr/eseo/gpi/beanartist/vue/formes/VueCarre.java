package fr.eseo.gpi.beanartist.vue.formes;

import fr.eseo.gpi.beanartist.modele.formes.Rectangle;

public class VueCarre extends VueRectangle {
  /*
   * Constructeurs
   */
  public VueCarre() {
    this(new Rectangle());
  }

  public VueCarre(Rectangle carre) {
    super(carre);
  }
}
