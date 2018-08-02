package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import fr.eseo.gpi.beanartist.vue.formes.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

public class ActionEnregistrer extends AbstractAction {
  private static final long serialVersionUID = 7426597638980745496L;
  public static final String NOM_ACTION = "Enregistrer";
  
  public ActionEnregistrer () {
    super(NOM_ACTION);
  }
  
  public void actionPerformed(ActionEvent arg0) {
    final JFileChooser fc = new JFileChooser(); // Popup de choix de fichier
    if (fc.showSaveDialog(FenetreBeAnArtist.getInstance().getPanneauDessin()) == JFileChooser.APPROVE_OPTION) {
      String fileName = fc.getSelectedFile().getPath();
      
      FileOutputStream fileWriter = null;
      ObjectOutputStream out = null;
      
      try {
        fileWriter = new FileOutputStream(fileName);
       
        out = new ObjectOutputStream(fileWriter); // Ecriture des objets
        out.writeInt(FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes().size());
        
        for (VueForme vf:FenetreBeAnArtist.getInstance().getPanneauDessin().getVueFormes()) {
          out.writeObject(vf.getForme());
        }

      } catch (IOException e) {
        throw new Error ("Erreur d'ouverture du fichier !");
      }
      finally {
        try {
          out.close();
          fileWriter.close();
        } catch (IOException e) {}
      }
    }
  }
  
}
