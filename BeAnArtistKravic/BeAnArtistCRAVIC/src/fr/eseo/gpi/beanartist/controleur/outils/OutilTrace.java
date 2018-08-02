package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.modele.formes.Trace;
import fr.eseo.gpi.beanartist.vue.formes.VueTrace;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilTrace extends OutilForme {

  private Trace currentTrace;
  
  /*
   * Constructeurs
   */

  public OutilTrace(PanneauDessin p) {
    super(p);
  }

  /*
   * Méthodes de classe
   */

  protected VueTrace creerVueForme() {
    VueTrace vueTrace = new VueTrace(currentTrace);
    return vueTrace;
  }

  /*
   * Mouse Events
   */
  
  public void mousePressed(MouseEvent event) {
    currentTrace = new Trace(new Point(event.getX(), event.getY()),new Point(event.getX(), event.getY()));
    getPanneauDessin().ajouterVueForme(creerVueForme());
  }

  public void mouseDragged(MouseEvent event) {
    setFin(new Point(event.getX(), event.getY()));
    currentTrace.ajouterPoint(new Point(event.getX(), event.getY()));
    getPanneauDessin().repaint();
  }

  public void mouseReleased(MouseEvent event) {
    setFin(new Point(event.getX(), event.getY()));
    currentTrace.ajouterPoint(new Point(event.getX(), event.getY()));
    getPanneauDessin().repaint();
  }
}
