package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.gpi.beanartist.controleur.outils.Outil;
import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;

public class PanneauDessin extends JPanel {
  private static final long serialVersionUID = -4956919191326380817L; // Generated Serial ID
  public static final int LARGEUR_PAR_DEFAUT = 1600;
  public static final int HAUTEUR_PAR_DEFAUT = 900;
  public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(224, 224, 255); // Gris bleuté

  private List<VueForme> vueFormes = new ArrayList<VueForme>();
  private Outil outilCourant;
  private Color couleurCourante;
  
  /*
   * Constructeurs
   */

  public PanneauDessin(int largeur, int hauteur, Color c) {
    setPreferredSize(new Dimension(largeur, hauteur));
    setBackground(c);
    couleurCourante = Forme.COULEUR_LIGNE_PAR_DEFAUT;
  }

  public PanneauDessin(int largeur, int hauteur) {
    this(largeur, hauteur, COULEUR_FOND_PAR_DEFAUT);
  }

  public PanneauDessin(Color c) {
    this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, c);
  }

  public PanneauDessin() {
    this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
  }

  /*
   * Getters
   */

  public List<VueForme> getVueFormes() { return vueFormes;}
  public Outil getOutilCourant() { return outilCourant;}
  public Color getCouleurCourante() {return couleurCourante;}
  
  /*
   * Setters
   */

  public void setOutilCourant(Outil o) { outilCourant = o;}
  public void setCouleurCourante(Color c) { couleurCourante = c;}
  
  /*
   * Méthodes de classe
   */

  public void ajouterVueForme(VueForme vf) {
    vueFormes.add(vf);
  }

  public void paintComponent(Graphics g) {
    
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D) g.create();

    for (VueForme vf : vueFormes) {
      vf.affiche(g2D);
    }
    g2D.dispose();
  }

}
