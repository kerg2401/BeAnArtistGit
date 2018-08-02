package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionChoisirCouleur extends AbstractAction {
  private static final long serialVersionUID = -3381659453613174135L;
  public static final String NOM_ACTION = "Action Couleur";
  
  public ActionChoisirCouleur() {
    super(NOM_ACTION);
  }
  
  public void actionPerformed(ActionEvent e) {
    FenetreBeAnArtist.getInstance().getPanneauDessin().setCouleurCourante(JColorChooser.showDialog(
                            FenetreBeAnArtist.getInstance().getPanneauDessin(),NOM_ACTION,
                            FenetreBeAnArtist.getInstance().getPanneauDessin().getCouleurCourante()));
  }
}
