package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.modele.formes.Ligne;
import fr.eseo.gpi.beanartist.vue.formes.VueLigne;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilLigne extends OutilForme {

  /*
   * Constructeurs
   */

  public OutilLigne(PanneauDessin p) {
    super(p);
  }

  /*
   * Méthodes de classe
   */

  protected VueLigne creerVueForme() { // Remettre en privé après
    Ligne ligne;
    if (getFin().equals(getDebut())) {
      ligne = new Ligne(getDebut());
    } else {
      ligne = new Ligne(getDebut(), getFin());
    }
    VueLigne vueLigne = new VueLigne(ligne);
    return vueLigne;
  }
}