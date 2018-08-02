package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class EllipseTest {
  public static final double DELTA = 1e-7;

  @Test
  public void testConstructeurVide() {
    Ellipse ellipse = new Ellipse();
    assertEquals("X par défaut", 0, ellipse.getX(), DELTA);
    assertEquals("Y par défaut", 0, ellipse.getY(), DELTA);
    assertEquals("Largeur par défaut", Ellipse.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", Ellipse.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPoint() {
    Ellipse ellipse = new Ellipse(new Point(7.5, 3.8));
    assertEquals("X", 7.5, ellipse.getX(), DELTA);
    assertEquals("Y", 3.8, ellipse.getY(), DELTA);
    assertEquals("Largeur par défaut", Ellipse.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", Ellipse.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPointDimentions() {
    Ellipse ellipse = new Ellipse(new Point(7.5, 3.8), 12, 151);
    assertEquals("X", 7.5, ellipse.getX(), DELTA);
    assertEquals("Y", 3.8, ellipse.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, ellipse.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 151, ellipse.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurDimentions() {
    Ellipse ellipse = new Ellipse(12, 151);
    assertEquals("X", 0, ellipse.getX(), DELTA);
    assertEquals("Y", 0, ellipse.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, ellipse.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 151, ellipse.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeur4doubles() {
    Ellipse ellipse = new Ellipse(1, 1, 12, 151);
    assertEquals("X", 1, ellipse.getX(), DELTA);
    assertEquals("Y", 1, ellipse.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, ellipse.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 151, ellipse.getHauteur(), DELTA);
  }

  @Test(expected = Exception.class)
  public void testConstructeurPointDoubleDoubleXNegatif() {
    Ellipse ellipse = new Ellipse(new Point(), -2, 4);
    ellipse.getHauteur();
    fail("Constructeur avec X négatif : Il n'y a pas eu d'erreur.");
  }

  @Test(expected = Exception.class)
  public void testConstructeurPointDoubleDoubleYNegatif() {
    Ellipse ellipse = new Ellipse(new Point(), 2, -4);
    ellipse.getHauteur();
    fail("Constructeur avec Y négatif : Il n'y a pas eu d'erreur.");
  }

  @Test
  public void testSetters() {
    Ellipse ellipse = new Ellipse();
    ellipse.setHauteur(12);
    ellipse.setLargeur(14);
    ellipse.setPosition(new Point(14, 32));
    assertEquals("hauteur", 12, ellipse.getHauteur(), DELTA);
    assertEquals("largeur", 14, ellipse.getLargeur(), DELTA);
    assertEquals("X", 14, ellipse.getX(), DELTA);
    assertEquals("Y", 32, ellipse.getY(), DELTA);
    ellipse.setX(32);
    ellipse.setY(14);
    assertEquals("X", 32, ellipse.getX(), DELTA);
    assertEquals("Y", 14, ellipse.getY(), DELTA);
  }

  @Test(expected = Exception.class)
  public void testSetHauteurNegatif() {
    Ellipse ellipse = new Ellipse();
    ellipse.setHauteur(-12);
    fail("SetHauteurNégatif : Il n'y a pas eu d'erreur.");
  }

  @Test(expected = Exception.class)
  public void testSetLargeurNegatif() {
    Ellipse ellipse = new Ellipse();
    ellipse.setLargeur(-14);
    fail("SetLArgeurNégatif : Il n'y a pas eu d'erreur.");
  }

  @Test
  public void testAirePerimetre() {
    Ellipse ellipse = new Ellipse();
    ellipse.setHauteur(10);
    ellipse.setLargeur(10);
    assertEquals("Aire", Math.PI * 25, ellipse.aire(), DELTA);
    assertEquals("Perimetre", Math.PI * 2 * 5, ellipse.perimetre(), DELTA);
  }

  @Test
  public void testEllipseContientDouble() {
    Ellipse ellipse = new Ellipse(10, 10);
    assertTrue("Contient True", ellipse.contient(5, 5));
    assertFalse("Contient False", ellipse.contient(10, 6));
  }

  @Test
  public void testEllipseContientPoint() {
    Ellipse ellipse = new Ellipse(10, 10);
    assertTrue("Contient True", ellipse.contient(new Point(5, 5)));
    assertFalse("Contient False", ellipse.contient(new Point(10, 6)));
  }
  
  @Test
  public void TestCouleurs() {
    Ellipse ellipse = new Ellipse(0, 0, 5, 5);
    ellipse.setCouleurLigne(Color.red);
    assertEquals("CouleurLigne", Color.red, ellipse.getCouleurLigne());
  }
}
