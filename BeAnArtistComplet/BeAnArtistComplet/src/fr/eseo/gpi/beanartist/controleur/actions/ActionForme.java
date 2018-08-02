package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.gpi.beanartist.controleur.outils.OutilCarre;
import fr.eseo.gpi.beanartist.controleur.outils.OutilCercle;
import fr.eseo.gpi.beanartist.controleur.outils.OutilEllipse;
import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.controleur.outils.OutilRectangle;
import fr.eseo.gpi.beanartist.controleur.outils.OutilTrace;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionForme extends AbstractAction {
  private static final long serialVersionUID = 5248888274717796241L;
  
  public static final String NOM_ACTION_RECTANGLE = "Rectangle";
  public static final String NOM_ACTION_ELLIPSE = "Ellipse";
  public static final String NOM_ACTION_CARRE = "Carre";
  public static final String NOM_ACTION_CERCLE = "Cercle";
  public static final String NOM_ACTION_LIGNE = "Ligne";
  public static final String NOM_ACTION_TRACE = "Trace";
  
  public ActionForme() {
    super(NOM_ACTION_LIGNE);
  }
  
  public ActionForme(String title) {
    super(title);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case NOM_ACTION_RECTANGLE : new OutilRectangle(FenetreBeAnArtist.getInstance().getPanneauDessin());
        break;
      
      case NOM_ACTION_ELLIPSE : new OutilEllipse(FenetreBeAnArtist.getInstance().getPanneauDessin());
        break;
      
      case NOM_ACTION_CARRE : new OutilCarre(FenetreBeAnArtist.getInstance().getPanneauDessin());
        break;
      
      case NOM_ACTION_CERCLE : new OutilCercle(FenetreBeAnArtist.getInstance().getPanneauDessin());
        break;
      
      case NOM_ACTION_LIGNE : new OutilLigne(FenetreBeAnArtist.getInstance().getPanneauDessin());
        break;
        
      case NOM_ACTION_TRACE : new OutilTrace(FenetreBeAnArtist.getInstance().getPanneauDessin());
        break;
      
      default : 
        break;
    }
  }

}
