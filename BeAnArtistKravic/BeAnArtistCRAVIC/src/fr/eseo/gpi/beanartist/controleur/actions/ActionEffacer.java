package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionEffacer extends AbstractAction {
  private static final long serialVersionUID = 8180565209865993467L;
  public static final String NOM_ACTION = "Effacer Tout";
  
  public ActionEffacer() {
    super(NOM_ACTION);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (JOptionPane.showConfirmDialog(FenetreBeAnArtist.getInstance(),"Effacer toutes les figures ?",NOM_ACTION,0) == 0) {
      /*while (FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes().size() > 0) {
        FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes().remove(0);
      }*/
      FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes().clear();
      FenetreBeAnArtist.getInstance().getPanneauDessin().repaint();
    }
  }
}
