package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class RectangleTest {
  public static final double DELTA = 1e-7;

  @Test
  public void testConstructeurVide() {
    Rectangle rect = new Rectangle();
    assertEquals("X par d�faut", 0, rect.getX(), DELTA);
    assertEquals("Y par d�faut", 0, rect.getY(), DELTA);
    assertEquals("Largeur par d�faut", Rectangle.LARGEUR_PAR_DEFAUT, rect.getLargeur(), DELTA);
    assertEquals("Hauteur par d�faut", Rectangle.HAUTEUR_PAR_DEFAUT, rect.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPoint() {
    Rectangle rect = new Rectangle(new Point(7.5, 3.8));
    assertEquals("X", 7.5, rect.getX(), DELTA);
    assertEquals("Y", 3.8, rect.getY(), DELTA);
    assertEquals("Largeur par d�faut", Rectangle.LARGEUR_PAR_DEFAUT, rect.getLargeur(), DELTA);
    assertEquals("Hauteur par d�faut", Rectangle.HAUTEUR_PAR_DEFAUT, rect.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPointDimentions() {
    Rectangle rect = new Rectangle(new Point(7.5, 3.8), 12, 151);
    assertEquals("X", 7.5, rect.getX(), DELTA);
    assertEquals("Y", 3.8, rect.getY(), DELTA);
    assertEquals("Largeur par d�faut", 12, rect.getLargeur(), DELTA);
    assertEquals("Hauteur par d�faut", 151, rect.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurDimentions() {
    Rectangle rect = new Rectangle(12, 151);
    assertEquals("X", 0, rect.getX(), DELTA);
    assertEquals("Y", 0, rect.getY(), DELTA);
    assertEquals("Largeur par d�faut", 12, rect.getLargeur(), DELTA);
    assertEquals("Hauteur par d�faut", 151, rect.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeur4doubles() {
    Rectangle rect = new Rectangle(1, 1, 12, 151);
    assertEquals("X", 1, rect.getX(), DELTA);
    assertEquals("Y", 1, rect.getY(), DELTA);
    assertEquals("Largeur", 12, rect.getLargeur(), DELTA);
    assertEquals("Hauteur", 151, rect.getHauteur(), DELTA);
  }

  @Test(expected = Exception.class)
  public void testConstructeurHauteurNegative() {
    Rectangle rect = new Rectangle(1, 1, 12, -151);
    assertEquals("Largeur", 12, rect.getLargeur(), DELTA);
    assertEquals("Hauteur", -151, rect.getHauteur(), DELTA);
  }

  @Test(expected = Exception.class)
  public void testConstructeurLargeurNegative() {
    Rectangle rect = new Rectangle(1, 1, -12, 151);
    assertEquals("Largeur", -12, rect.getLargeur(), DELTA);
    assertEquals("Hauteur", 151, rect.getHauteur(), DELTA);
  }

  @Test
  public void testSetters() {
    Rectangle rect = new Rectangle();
    rect.setHauteur(12);
    rect.setLargeur(14);
    rect.setPosition(new Point(14, 32));
    assertEquals("hauteur", 12, rect.getHauteur(), DELTA);
    assertEquals("largeur", 14, rect.getLargeur(), DELTA);
    assertEquals("X", 14, rect.getX(), DELTA);
    assertEquals("Y", 32, rect.getY(), DELTA);
    rect.setX(32);
    rect.setY(14);
    assertEquals("X", 32, rect.getX(), DELTA);
    assertEquals("Y", 14, rect.getY(), DELTA);
  }

  @Test(expected = Exception.class)
  public void testSetHauteurNegatif() {
    Rectangle rect = new Rectangle();
    rect.setHauteur(-12);
    fail("SetHauteurN�gatif : Il n'y a pas eu d'erreur.");
  }

  @Test(expected = Exception.class)
  public void testSetLargeurNegatif() {
    Rectangle rect = new Rectangle();
    rect.setLargeur(-12);
    fail("SetLArgeurN�gatif : Il n'y a pas eu d'erreur.");
  }

  @Test
  public void testAirePerimetre() {
    Rectangle rect = new Rectangle();
    rect.setHauteur(10);
    rect.setLargeur(9);
    assertEquals("Aire", 90, rect.aire(), DELTA);
    assertEquals("Perimetre", 38, rect.perimetre(), DELTA);
  }

  @Test
  public void testCadreMinMaxXY() {
    Rectangle rect = new Rectangle(new Point(10, 5), 15, 25);
    assertEquals("CadreMinX", 10, rect.getCadreMinX(), DELTA);
    assertEquals("CadreMaxX", 25, rect.getCadreMaxX(), DELTA);
    assertEquals("CadreMinY", 5, rect.getCadreMinY(), DELTA);
    assertEquals("CadreMaxY", 30, rect.getCadreMaxY(), DELTA);
  }

  @Test
  public void testToString() {
    Rectangle rect = new Rectangle(new Point(10, 5), 15, 25);
    assertEquals("toString", "[Rectangle] pos (10 , 5) dim 15 x 25 périmètre : 80 aire : 375",
        rect.toString());
  }

  @Test
  public void testDeplacerVersDeplacerDe() {
    Rectangle rect = new Rectangle(new Point(10, 5), 15, 25);
    rect.deplacerVers(10, 10);
    assertEquals("deplacerVers", "(10 , 10)", rect.getPosition().toString());
    rect.deplacerDe(-5, 10);
    assertEquals("deplacerVers", "(5 , 20)", rect.getPosition().toString());
  }

  @Test
  public void TestContientDoubleDouble() {
    Rectangle rect = new Rectangle(0, 0, 5, 5);
    assertTrue("Contient point", rect.contient(2, 2));
    assertTrue("Contient point limite", rect.contient(1, 0));
    assertFalse("Contient pas point", rect.contient(-2, 2));
  }

  @Test
  public void TestContientPoint() {
    Rectangle rect = new Rectangle(0, 0, 5, 5);
    assertTrue("Contient point", rect.contient(new Point(2, 2)));
    assertTrue("Contient point limite", rect.contient(new Point(1, 0)));
    assertFalse("Contient pas point", rect.contient(new Point(-2, 2)));
  }
  
  @Test
  public void TestCouleurs() {
    Rectangle rect = new Rectangle(0, 0, 5, 5);
    rect.setCouleurLigne(Color.red);
    assertEquals("CouleurLigne", Color.red, rect.getCouleurLigne());
  }

}
