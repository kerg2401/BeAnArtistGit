package fr.eseo.gpi.beanartist.vue.ui;

import javax.swing.SwingUtilities;

import fr.eseo.gpi.beanartist.modele.formes.Rectangle;
import fr.eseo.gpi.beanartist.vue.formes.VueRectangle;

//....
public class FenetreBeAnArtistTest {

  public FenetreBeAnArtistTest() {
    testDefaultConstructor();
  }

  // M�thode de test avec un doublepone
  
  public void testDefaultConstructor() {
    FenetreBeAnArtist f = FenetreBeAnArtist.getInstance();
    Rectangle rect1 = new Rectangle();
    Rectangle rect2 = new Rectangle(100, 100, 50, 50);
    Rectangle rect3 = new Rectangle(25, 400, 20, 100);
    Rectangle rect4 = new Rectangle(600, 600, 250, 100);
    Rectangle rect5 = new Rectangle(70, 200, 125, 378);

    VueRectangle vr1 = new VueRectangle(rect1);
    VueRectangle vr2 = new VueRectangle(rect2);
    VueRectangle vr3 = new VueRectangle(rect3);
    VueRectangle vr4 = new VueRectangle(rect4);
    VueRectangle vr5 = new VueRectangle(rect5);

    f.getPanneauDessin().ajouterVueForme(vr1);
    f.getPanneauDessin().ajouterVueForme(vr2);
    f.getPanneauDessin().ajouterVueForme(vr3);
    f.getPanneauDessin().ajouterVueForme(vr4);
    f.getPanneauDessin().ajouterVueForme(vr5);

    f.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new FenetreBeAnArtistTest();
      }
    });
  }
}