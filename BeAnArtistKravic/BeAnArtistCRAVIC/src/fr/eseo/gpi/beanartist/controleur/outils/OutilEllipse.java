package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.Ellipse;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.vue.formes.VueEllipse;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilEllipse extends OutilForme {

  /*
   * Constructeurs
   */

  public OutilEllipse(PanneauDessin p) {
    super(p);
  }

  /*
   * Méthodes de classe
   */

  protected VueEllipse creerVueForme() {
    Ellipse ellipse;
    if (getFin().equals(getDebut())) {
      ellipse = new Ellipse(getDebut());
    } else {
      int x1 = (int) Math.round(Math.min(getDebut().getX(), getFin().getX()));
      int x2 = (int) Math.round(Math.max(getDebut().getX(), getFin().getX()));
      int y1 = (int) Math.round(Math.min(getDebut().getY(), getFin().getY()));
      int y2 = (int) Math.round(Math.max(getDebut().getY(), getFin().getY()));

      ellipse = new Ellipse(x1, y1, x2 - x1, y2 - y1);
      ellipse.setPosition(new Point(Math.min(x1, x2), Math.min(y1, y2)));
    }
    VueEllipse vueEllipse = new VueEllipse(ellipse);
    return vueEllipse;
  }
}
