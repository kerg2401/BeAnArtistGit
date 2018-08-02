package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Rectangle;
import fr.eseo.gpi.beanartist.vue.formes.VueRectangle;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilRectangle extends OutilForme {

  /*
   * Constructeurs
   */

  public OutilRectangle(PanneauDessin p) {
    super(p);
  }

  /*
   * Méthodes de classe
   */

  protected VueRectangle creerVueForme() {
    Rectangle rect;
    if (getFin().equals(getDebut())) {
      rect = new Rectangle(getDebut());
    } else {
      int x1 = (int) Math.round(Math.min(getDebut().getX(), getFin().getX()));
      int x2 = (int) Math.round(Math.max(getDebut().getX(), getFin().getX()));
      int y1 = (int) Math.round(Math.min(getDebut().getY(), getFin().getY()));
      int y2 = (int) Math.round(Math.max(getDebut().getY(), getFin().getY()));

      rect = new Rectangle(x1, y1, x2 - x1, y2 - y1);
      rect.setPosition(new Point(Math.min(x1,x2), Math.min(y1, y2)));
    }
    
    VueRectangle vueRectangle = new VueRectangle(rect);
    return vueRectangle;
  }
}
