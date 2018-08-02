package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import fr.eseo.gpi.beanartist.modele.formes.Carre;
import fr.eseo.gpi.beanartist.modele.formes.Cercle;
import fr.eseo.gpi.beanartist.modele.formes.Ellipse;
import fr.eseo.gpi.beanartist.modele.formes.Forme;
import fr.eseo.gpi.beanartist.modele.formes.Ligne;
import fr.eseo.gpi.beanartist.modele.formes.Rectangle;
import fr.eseo.gpi.beanartist.modele.formes.Trace;
import fr.eseo.gpi.beanartist.vue.formes.VueCarre;
import fr.eseo.gpi.beanartist.vue.formes.VueCercle;
import fr.eseo.gpi.beanartist.vue.formes.VueEllipse;
import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.formes.VueLigne;
import fr.eseo.gpi.beanartist.vue.formes.VueRectangle;
import fr.eseo.gpi.beanartist.vue.formes.VueTrace;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionOuvrir extends AbstractAction {
  private static final long serialVersionUID = -8555770192145729671L;
  public static final String NOM_ACTION = "Ouvrir";

  public ActionOuvrir() {
    super(NOM_ACTION);
  } 
  
  private void creerVueForme(Forme f) {
    VueForme vue;
    switch (f.getClass().getSimpleName()) {
    case "Rectangle":
      vue = new VueRectangle((Rectangle) f);
      break;
    case "Ellipse" :
      vue = new VueEllipse((Ellipse) f);
      break;
    case "Carre" : 
      vue = new VueCarre((Carre) f);
      break;
    case "Cercle" : 
      vue = new VueCercle((Cercle) f);
      break;
    case "Ligne" : 
      vue = new VueLigne((Ligne) f);
      break;
    case "Trace" :
      vue = new VueTrace((Trace) f);
      break;
    default : vue = null;
  }
  
  FenetreBeAnArtist.getInstance().getPanneauDessin().ajouterVueForme(vue);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    final JFileChooser fc = new JFileChooser(); // Popup de choix de fichier
    if (fc.showOpenDialog(FenetreBeAnArtist.getInstance().getPanneauDessin()) == JFileChooser.APPROVE_OPTION) {
      
      FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes().clear();
      FenetreBeAnArtist.getInstance().getPanneauDessin().repaint();
      
      ObjectInputStream in = null;
      FileInputStream fileReader = null;
      
      try {
        fileReader = new FileInputStream(fc.getSelectedFile());
        in = new ObjectInputStream(fileReader);
        
        Forme f;
        int nbFormes = in.readInt();
        for (int i=0; i<nbFormes; i++) {
          f = (Forme) in.readObject();
          creerVueForme(f);
        }
      } catch (FileNotFoundException e1) {
        e1.printStackTrace();
      } catch (IOException e1) {
        e1.printStackTrace();
      } catch (ClassNotFoundException e1) {
        System.out.println("Classe non trouvée : " + e1);
      } finally {
        try {
          in.close();
          fileReader.close();
        } catch (IOException e2) {
          
        }
      }
      
      
    }
  }
}
