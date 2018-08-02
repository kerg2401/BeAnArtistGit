package fr.eseo.gpi.beanartist.controleur.actions;

import javax.swing.SwingUtilities;

import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionEffacerTest {

  public ActionEffacerTest() {
    testDefaultConstructor();
  }

  public void testDefaultConstructor() {
    FenetreBeAnArtist f = FenetreBeAnArtist.getInstance();
    OutilLigne outilLigne = new OutilLigne(f.getPanneauDessin());
    outilLigne.associer(f.getPanneauDessin());

    f.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new ActionEffacerTest();
      }
    });
  }
}