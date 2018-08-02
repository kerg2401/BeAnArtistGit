package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarreTest {
  public static final double DELTA = 1e-7;

  @Test
  public void testConstructeurVide() {
    Carre carre = new Carre();
    assertEquals("X par défaut", 0, carre.getX(), DELTA);
    assertEquals("Y par défaut", 0, carre.getY(), DELTA);
    assertEquals("Largeur par défaut", Carre.LARGEUR_PAR_DEFAUT, carre.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", Carre.LARGEUR_PAR_DEFAUT, carre.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPoint() {
    Carre carre = new Carre(new Point(7.5, 3.8));
    assertEquals("X", 7.5, carre.getX(), DELTA);
    assertEquals("Y", 3.8, carre.getY(), DELTA);
    assertEquals("Largeur par défaut", Carre.LARGEUR_PAR_DEFAUT, carre.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", Carre.LARGEUR_PAR_DEFAUT, carre.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPointDimentions() {
    Carre carre = new Carre(new Point(7.5, 3.8), 12);
    assertEquals("X", 7.5, carre.getX(), DELTA);
    assertEquals("Y", 3.8, carre.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, carre.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 12, carre.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurDimensions() {
    Carre carre = new Carre(12);
    assertEquals("X", 0, carre.getX(), DELTA);
    assertEquals("Y", 0, carre.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, carre.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 12, carre.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeur4doubles() {
    Carre carre = new Carre(1, 1, 12);
    assertEquals("X", 1, carre.getX(), DELTA);
    assertEquals("Y", 1, carre.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, carre.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 12, carre.getHauteur(), DELTA);
  }

  @Test
  public void testSetters() {
    Carre carre = new Carre();
    carre.setHauteur(12);
    carre.setPosition(new Point(14, 32));
    assertEquals("hauteur", 12, carre.getHauteur(), DELTA);
    assertEquals("largeur", 12, carre.getLargeur(), DELTA);
    assertEquals("X", 14, carre.getX(), DELTA);
    assertEquals("Y", 32, carre.getY(), DELTA);
    carre.setX(32);
    carre.setY(14);
    assertEquals("X", 32, carre.getX(), DELTA);
    assertEquals("Y", 14, carre.getY(), DELTA);

    carre.setLargeur(95);
    assertEquals("hauteur", 95, carre.getHauteur(), DELTA);
    assertEquals("largeur", 95, carre.getLargeur(), DELTA);
  }

  @Test(expected = Exception.class)
  public void testSettersNegatifs() {
    Carre carre = new Carre();
    carre.setHauteur(-12);
  }

  @Test
  public void testAirePerimetre() {
    Carre carre = new Carre();
    carre.setLargeur(9);
    assertEquals("Aire", 81, carre.aire(), DELTA);
    assertEquals("Perimetre", 36, carre.perimetre(), DELTA);
  }
}
