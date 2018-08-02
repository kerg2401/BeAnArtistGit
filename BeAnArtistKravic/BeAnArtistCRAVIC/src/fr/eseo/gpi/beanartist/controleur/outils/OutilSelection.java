package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilSelection extends Outil {

  private Forme formeSelectionnee;
  
  public OutilSelection(PanneauDessin p) {
    super(p);
  }

  /*
   * Mouse events
   */
  public void mouseClicked(MouseEvent event) {
    setDebut(new Point(event.getX(), event.getY()));
    formeSelectionnee = null;
    for (VueForme vf:getPanneauDessin().getVueFormes()) {
      if (vf.getForme().contient(getDebut())) {
        formeSelectionnee = vf.getForme();
      }
    }
    if (formeSelectionnee!=null) {
      System.out.println(formeSelectionnee.toString());
    }
  }

  public void mouseDragged(MouseEvent event) {

  }
}
