package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public abstract class OutilForme extends Outil {

  private VueForme vf;

  /*
   * Constructeurs
   */
  public OutilForme(PanneauDessin p) {
    super(p);
    //this.associer(p);
  }

  /*
   * Mouse events
   */
  public void mouseClicked(MouseEvent event) {
    if (event.getClickCount() == 2) {
      setDebut(new Point(event.getX(), event.getY()));
      setFin(new Point(event.getX(), event.getY()));
      vf = creerVueForme();
      getPanneauDessin().ajouterVueForme(vf);
      getPanneauDessin().repaint();
    }
  }

  public void mouseReleased(MouseEvent event) {
    super.mouseReleased(event);
    if (!getDebut().equals(getFin())) {
      vf = creerVueForme();
      getPanneauDessin().ajouterVueForme(vf);
      getPanneauDessin().repaint();
    }
  }

  /*
   * Méthodes abstraites
   */
  protected abstract VueForme creerVueForme();
}
