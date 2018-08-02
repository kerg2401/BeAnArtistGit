package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.gpi.beanartist.controleur.outils.OutilSelection;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionSelectionner extends AbstractAction {
  private static final long serialVersionUID = -8739761606251946659L;
  public static final String NOM_ACTION = "Selectionner";
  
  public ActionSelectionner() {
    super(NOM_ACTION);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    OutilSelection outilSelect = new OutilSelection(FenetreBeAnArtist.getInstance().getPanneauDessin());
    outilSelect.associer(FenetreBeAnArtist.getInstance().getPanneauDessin());
    FenetreBeAnArtist.getInstance().getPanneauDessin().setOutilCourant(outilSelect);
  }
}
