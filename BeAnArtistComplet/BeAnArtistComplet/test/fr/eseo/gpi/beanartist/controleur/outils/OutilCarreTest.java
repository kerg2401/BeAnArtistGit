package fr.eseo.gpi.beanartist.controleur.outils;

import javax.swing.SwingUtilities;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilCarreTest {

  public OutilCarreTest() {
    testDefaultConstructor();
  }

  public void testDefaultConstructor() {
    FenetreBeAnArtist f = FenetreBeAnArtist.getInstance();
    OutilCarre outilCarre = new OutilCarre(f.getPanneauDessin());
    outilCarre.associer(f.getPanneauDessin());

    f.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new OutilCarreTest();
      }
    });
  }
}