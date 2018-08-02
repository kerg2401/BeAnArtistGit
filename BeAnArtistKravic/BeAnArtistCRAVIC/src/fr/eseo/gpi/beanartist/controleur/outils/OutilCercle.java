package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.Cercle;
import fr.eseo.gpi.beanartist.vue.formes.VueCercle;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilCercle extends OutilForme {

  /*
   * Constructeurs
   */

  public OutilCercle(PanneauDessin p) {
    super(p);
  }

  /*
   * Méthodes de classe
   */

  protected VueCercle creerVueForme() {
    Cercle ellipse;
    if (getFin().equals(getDebut())) {
      ellipse = new Cercle(getDebut());
    } else {
      int posX, posY;
      int cote = (int) Math.max(Math.abs(getDebut().getX()-getFin().getX()),
                       Math.abs(getDebut().getY() - getFin().getY()));
      
      if (getDebut().getX() >= getFin().getX()) {
        posX = (int)getDebut().getX()-cote;
      }else {
        posX = (int)getDebut().getX();
      }
      if (getDebut().getY() >= getFin().getY()) {
        posY = (int)getDebut().getY()-cote;
      } else {
        posY = (int)getDebut().getY();
      }
      
      ellipse = new Cercle(posX, posY, cote);
    }
    VueCercle vueCercle = new VueCercle(ellipse);
    return vueCercle;
  }
}
