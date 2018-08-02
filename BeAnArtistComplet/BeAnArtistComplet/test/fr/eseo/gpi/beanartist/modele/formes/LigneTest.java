package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class LigneTest {
  public static final double DELTA = 1e-7;

  @Test
  public void testConstructeurVide() {
    Ligne ligne = new Ligne();
    assertEquals("X par d�faut", 0, ligne.getX(), DELTA);
    assertEquals("Y par d�faut", 0, ligne.getY(), DELTA);
    assertEquals("Largeur par défaut", Ligne.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", Ligne.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPointPoint() {
    Ligne ligne = new Ligne(new Point(0,0), new Point(10,10));
    assertEquals("X", 0, ligne.getX(), DELTA);
    assertEquals("Y", 0, ligne.getY(), DELTA);
    assertEquals("Largeur par défaut", 10, ligne.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 10, ligne.getHauteur(), DELTA);
  }
  @Test
  public void testConstructeurPoint() {
    Ligne ligne = new Ligne(new Point(7.5, 3.8));
    assertEquals("X", 7.5, ligne.getX(), DELTA);
    assertEquals("Y", 3.8, ligne.getY(), DELTA);
    assertEquals("Largeur par défaut", Ligne.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", Ligne.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPointDimentions() {
    Ligne ligne = new Ligne(new Point(7.5, 3.8), 12, 151);
    assertEquals("X", 7.5, ligne.getX(), DELTA);
    assertEquals("Y", 3.8, ligne.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, ligne.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 151, ligne.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurDimentions() {
    Ligne ligne = new Ligne(12, 151);
    assertEquals("X", 0, ligne.getX(), DELTA);
    assertEquals("Y", 0, ligne.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, ligne.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 151, ligne.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeur4doubles() {
    Ligne ligne = new Ligne(1, 1, 12, 151);
    assertEquals("X", 1, ligne.getX(), DELTA);
    assertEquals("Y", 1, ligne.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, ligne.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 151, ligne.getHauteur(), DELTA);
  }

  @Test
  public void testSetters() {
    Ligne ligne = new Ligne();
    ligne.setHauteur(12);
    ligne.setLargeur(14);
    ligne.setPosition(new Point(14, 32));
    assertEquals("hauteur", 12, ligne.getHauteur(), DELTA);
    assertEquals("largeur", 14, ligne.getLargeur(), DELTA);
    assertEquals("X", 14, ligne.getX(), DELTA);
    assertEquals("Y", 32, ligne.getY(), DELTA);
    ligne.setX(32);
    ligne.setY(14);
    assertEquals("X", 32, ligne.getX(), DELTA);
    assertEquals("Y", 14, ligne.getY(), DELTA);
  }

  @Test
  public void testSetP1P2() {
    Ligne ligne = new Ligne();
    ligne.setP1(new Point(14, 32));
    assertEquals("P1", "(14 , 32)", ligne.getP1().toString());
    ligne.setP2(new Point(15, 33));
    assertEquals("P2", ("(15 , 33)"), ligne.getP2().toString());

    ligne.setP1(new Point(-14, 32));
    assertEquals("P1", "(-14 , 32)", ligne.getP1().toString());
    ligne.setP2(new Point(15, -33));
    assertEquals("P2", ("(15 , -33)"), ligne.getP2().toString());
  }

  @Test
  public void testSettersNegatifs() {
    Ligne ligne = new Ligne();
    ligne.setHauteur(-12);
    ligne.setLargeur(-14);
    assertEquals("hauteur", -12, ligne.getHauteur(), DELTA);
    assertEquals("largeur", -14, ligne.getLargeur(), DELTA);
  }

  @Test
  public void testAirePerimetre() {
    Ligne ligne = new Ligne();
    ligne.setHauteur(10);
    ligne.setLargeur(9);
    assertEquals("Aire", 0, ligne.aire(), DELTA);
    assertEquals("Perimetre", Math.sqrt(100 + 81), ligne.perimetre(), DELTA);
  }

  @Test
  public void testContientDouble() {
    Ligne ligne = new Ligne(0, 0, 2, 2);
    assertTrue("Contient", ligne.contient(1, 1));
    assertFalse("Contient", ligne.contient(3, 1));
  }

  @Test
  public void testContientPoint() {
    Ligne ligne = new Ligne(0, 0, 10, 10);
    assertTrue("Contient", ligne.contient(new Point(5, 5)));
    assertFalse("Contient", ligne.contient(new Point(5, 7)));
  }

  @Test
  public void testToString() {
    Ligne ligne = new Ligne(0, 0, 2, 2);
    assertEquals("toString", "[Ligne] p1 : (0 , 0) p2 : (2 , 2) longueur : 2,83", ligne.toString());
  }

  @Test
  public void testGetCadreMinMaxXY() {
    Ligne ligne = new Ligne(5, 10, -15, -20);
    assertEquals("CadreMinX", -10, ligne.getCadreMinX(), DELTA);
    assertEquals("CadreMaxX", 5, ligne.getCadreMaxX(), DELTA);
    assertEquals("CadreMinY", -10, ligne.getCadreMinY(), DELTA);
    assertEquals("CadreMaxY", 10, ligne.getCadreMaxY(), DELTA);
  }
  
  @Test
  public void TestCouleurs() {
    Ligne ligne = new Ligne(0, 0, 5, 5);
    ligne.setCouleurLigne(Color.red);
    assertEquals("CouleurLigne", Color.red, ligne.getCouleurLigne());
  }
}
