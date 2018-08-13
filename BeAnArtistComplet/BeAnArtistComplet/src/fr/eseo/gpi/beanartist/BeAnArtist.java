package fr.eseo.gpi.beanartist;

import javax.swing.SwingUtilities;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class BeAnArtist {

  public BeAnArtist() {
    FenetreBeAnArtist f = FenetreBeAnArtist.getInstance();
    f.setVisible(true);
    //
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new BeAnArtist();
      }
    });
  }
}