package fr.eseo.gpi.beanartist.controleur.outils;

import javax.swing.SwingUtilities;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilEllipseTest {
  public OutilEllipseTest() {
    testDefaultConstructor();
  }

  public void testDefaultConstructor() {
    FenetreBeAnArtist f = FenetreBeAnArtist.getInstance();
    OutilEllipse outilEllipse = new OutilEllipse(f.getPanneauDessin());
    outilEllipse.associer(f.getPanneauDessin());

    f.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new OutilEllipseTest();
      }
    });
  }
}