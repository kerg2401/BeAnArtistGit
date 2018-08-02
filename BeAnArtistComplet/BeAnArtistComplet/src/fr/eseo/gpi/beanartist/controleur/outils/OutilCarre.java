package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.Carre;
import fr.eseo.gpi.beanartist.vue.formes.VueCarre;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilCarre extends OutilForme {

  /*
   * Constructeurs
   */

  public OutilCarre(PanneauDessin p) {
    super(p);
  }

  /*
   * Méthodes de classe
   */
  protected VueCarre creerVueForme() {
    Carre carre;
    if (getFin().equals(getDebut())) {
      carre = new Carre(getDebut());
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
      
      carre = new Carre(posX, posY, cote);
    }
    VueCarre vueCarre = new VueCarre(carre);
    return vueCarre;
  }
}
