package fr.eseo.gpi.beanartist.controleur.outils;

import javax.swing.SwingUtilities;

import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class OutilRectangleTest {

  public OutilRectangleTest() {
    testDefaultConstructor();
  }

  public void testDefaultConstructor() {
    FenetreBeAnArtist f = FenetreBeAnArtist.getInstance();
    OutilRectangle outilRectangle = new OutilRectangle(f.getPanneauDessin());
    outilRectangle.associer(f.getPanneauDessin());

    f.setVisible(true);
    System.out.println(f.getPanneauDessin().getVueFormes().size());
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new OutilRectangleTest();
      }
    });
  }
}