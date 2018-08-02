package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.gpi.beanartist.controleur.actions.ActionChoisirCouleur;
import fr.eseo.gpi.beanartist.controleur.actions.ActionEffacer;
import fr.eseo.gpi.beanartist.controleur.actions.ActionEnregistrer;
import fr.eseo.gpi.beanartist.controleur.actions.ActionForme;
import fr.eseo.gpi.beanartist.controleur.actions.ActionOuvrir;
import fr.eseo.gpi.beanartist.controleur.actions.ActionSelectionner;

public class PanneauBarreOutils extends JPanel {
  private static final long serialVersionUID = -465425101473466306L;
  private JButton boutonEffacer;
  
  private JToggleButton boutonRectangle;
  private JToggleButton boutonEllipse;
  private JToggleButton boutonCarre;
  private JToggleButton boutonCercle;
  private JToggleButton boutonLigne;
  private JToggleButton boutonTrace;
  
  private JButton boutonCouleurLigne;
  private JButton boutonEnregistrer;
  private JButton boutonOuvrir;
  
  private JToggleButton boutonSelection;
    
  private ButtonGroup boutonOutils;
  
  public PanneauBarreOutils() {
    boutonEffacer = new JButton(new ActionEffacer());
    boutonRectangle = new JToggleButton(new ActionForme(ActionForme.NOM_ACTION_RECTANGLE));
    boutonEllipse = new JToggleButton(new ActionForme(ActionForme.NOM_ACTION_ELLIPSE));
    boutonCarre = new JToggleButton(new ActionForme(ActionForme.NOM_ACTION_CARRE));
    boutonCercle = new JToggleButton(new ActionForme(ActionForme.NOM_ACTION_CERCLE));
    boutonLigne = new JToggleButton(new ActionForme(ActionForme.NOM_ACTION_LIGNE));
    boutonTrace = new JToggleButton(new ActionForme(ActionForme.NOM_ACTION_TRACE));
    boutonSelection = new JToggleButton(new ActionSelectionner());
    boutonCouleurLigne = new JButton(new ActionChoisirCouleur());
    boutonEnregistrer = new JButton(new ActionEnregistrer());
    boutonOuvrir = new JButton(new ActionOuvrir());
    
    
    boutonRectangle.setActionCommand(ActionForme.NOM_ACTION_RECTANGLE);
    boutonEllipse.setActionCommand(ActionForme.NOM_ACTION_ELLIPSE);
    boutonCarre.setActionCommand(ActionForme.NOM_ACTION_CARRE);
    boutonCercle.setActionCommand(ActionForme.NOM_ACTION_CERCLE);
    boutonLigne.setActionCommand(ActionForme.NOM_ACTION_LIGNE);
    boutonTrace.setActionCommand(ActionForme.NOM_ACTION_TRACE);

    boutonOutils = new ButtonGroup();
    boutonOutils.add(boutonRectangle);
    boutonOutils.add(boutonEllipse);
    boutonOutils.add(boutonCarre);
    boutonOutils.add(boutonCercle);
    boutonOutils.add(boutonLigne);
    boutonOutils.add(boutonTrace);
    boutonOutils.add(boutonSelection);
    initComponents();
  }

  private void initComponents() {
    this.setPreferredSize(new Dimension(180,400));
    this.setLayout(new GridLayout(20,1,10,5));
    this.add(boutonEffacer);
    this.add(boutonRectangle);
    this.add(boutonEllipse);
    this.add(boutonCarre);
    this.add(boutonCercle);
    this.add(boutonLigne);
    this.add(boutonTrace);
    this.add(boutonSelection);
    this.add(boutonCouleurLigne);
    this.add(boutonEnregistrer);
    this.add(boutonOuvrir);
  }
}
