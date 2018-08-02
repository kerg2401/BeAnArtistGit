package fr.eseo.gpi.beanartist.controleur.outils;

import javax.swing.SwingUtilities;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilTraceTest {

  public OutilTraceTest() {
    testDefaultConstructor();
  }

  public void testDefaultConstructor() {
    FenetreBeAnArtist f = FenetreBeAnArtist.getInstance();
    OutilTrace outilTrace = new OutilTrace(f.getPanneauDessin());
    outilTrace.associer(f.getPanneauDessin());

    f.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new OutilTraceTest();
      }
    });
  }
}