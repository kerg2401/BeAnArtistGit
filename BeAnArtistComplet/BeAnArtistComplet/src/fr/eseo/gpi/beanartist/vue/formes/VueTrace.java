package fr.eseo.gpi.beanartist.vue.formes;

import java.awt.Graphics2D;
import java.util.List;

import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Trace;

public class VueTrace extends VueForme {
  /*
   * Constructeurs
   */
  public VueTrace() {
    this(new Trace());
  }

  public VueTrace(Trace trace) {
    super(trace);
  }

  /*
   * Méthodes de classe
   */
  public void affiche(Graphics2D g2d) {
    List<Point> points = ((Trace) getForme()).getPoints();
    g2d.setColor(getForme().getCouleurLigne());
    for (int i = 0; i < points.size() - 1; i++) {
      g2d.drawLine((int) Math.round(points.get(i).getX()), (int) Math.round(points.get(i).getY()),
          (int) Math.round(points.get(i + 1).getX()), (int) Math.round(points.get(i + 1).getY()));
    }
  }
}
