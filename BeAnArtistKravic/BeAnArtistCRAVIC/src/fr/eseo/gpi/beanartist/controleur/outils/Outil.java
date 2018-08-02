package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import fr.eseo.gpi.beanartist.modele.formes.Point;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public abstract class Outil implements MouseMotionListener, MouseListener {

  private PanneauDessin panneauDessin;
  private Point debut;
  private Point fin;

  /*
   * Constructeurs
   */

  public Outil(PanneauDessin p) {
    //panneauDessin = p;
    associer(p);
  }

  /*
   * Getters
   */

  public PanneauDessin getPanneauDessin() {
    return panneauDessin;
  }

  public Point getDebut() {
    return debut;
  }

  public Point getFin() {
    return fin;
  }

  /*
   * Setters
   */

  public void setPanneauDessin(PanneauDessin p) {
    panneauDessin = p;
  }

  public void setDebut(Point p) {
    debut = p;
  }

  public void setFin(Point p) {
    fin = p;
  }

  /*
   * Méthodes de classe
   */

  public void associer(PanneauDessin p) {
    if (p != null) {
      if (p.getOutilCourant() != null) {
        p.getOutilCourant().liberer();
      }
    }
    this.panneauDessin = p;
    if (p != null) {
      panneauDessin.setOutilCourant(this);
      panneauDessin.addMouseListener(this);
      panneauDessin.addMouseMotionListener(this); 
    }
  }

  private void liberer() {
    panneauDessin.removeMouseListener(this);
    panneauDessin.removeMouseMotionListener(this);
    panneauDessin.setOutilCourant(null);
    panneauDessin = null;
  }

  /*
   * Mouse Events
   */

  public void mousePressed(MouseEvent event) {
    debut = new Point(event.getX(), event.getY());
  }

  public void mouseReleased(MouseEvent event) {
    fin = new Point(event.getX(), event.getY());
  }

  public void mouseClicked(MouseEvent event) {

  }

  public void mouseDragged(MouseEvent event) {

  }

  public void mouseMoved(MouseEvent event) {

  }

  public void mouseEntered(MouseEvent event) {

  }

  public void mouseExited(MouseEvent event) {

  }
}
