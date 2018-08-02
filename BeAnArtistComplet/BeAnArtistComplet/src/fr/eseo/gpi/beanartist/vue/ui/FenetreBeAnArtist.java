package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class FenetreBeAnArtist extends JFrame {
  private static final long serialVersionUID = 441759246130424109L; // Generated Serial ID
  public static final String TITRE_PAR_DEFAUT = "Be An Artist - Thomas CRAVIC";
  private static FenetreBeAnArtist instance = new FenetreBeAnArtist();
  private PanneauDessin panneauDessin;
  private PanneauBarreOutils panneauBarreOutils;

  /*
   * Constructeurs
   */

  private FenetreBeAnArtist() {
    this(TITRE_PAR_DEFAUT);
  }

  private FenetreBeAnArtist(String titre) {
    this(titre, PanneauDessin.LARGEUR_PAR_DEFAUT, PanneauDessin.HAUTEUR_PAR_DEFAUT);
  }

  private FenetreBeAnArtist(String titre, int largeur, int hauteur) {
    this(titre, largeur, hauteur, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
  }

  private FenetreBeAnArtist(String titre, int largeur, int hauteur, Color c) {

    setTitle(titre);
    setPreferredSize(new Dimension(largeur, hauteur));
    setBackground(c);

    //
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    panneauDessin = new PanneauDessin(largeur, hauteur, c);
    panneauBarreOutils = new PanneauBarreOutils();
    getContentPane().add(panneauBarreOutils,BorderLayout.EAST);
    getContentPane().add(panneauDessin);
    
    pack();
    setLocationRelativeTo(null); // Position de la fenêtre
  }

  /*
   * Getters
   */

  public static FenetreBeAnArtist getInstance() {
      synchronized (FenetreBeAnArtist.class) {
        if (FenetreBeAnArtist.instance == null) {
          FenetreBeAnArtist.instance = new FenetreBeAnArtist();
        }
      }
    return instance;
  }

  public PanneauDessin getPanneauDessin() {return panneauDessin;}
  
  public PanneauBarreOutils getPanneauBarreOutils() {return panneauBarreOutils;}
}
