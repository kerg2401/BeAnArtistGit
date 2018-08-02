package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CercleTest {
  public static final double DELTA = 1e-7;

  @Test
  public void testConstructeurVide() {
    Cercle cercle = new Cercle();
    assertEquals("X par défaut", 0, cercle.getX(), DELTA);
    assertEquals("Y par défaut", 0, cercle.getY(), DELTA);
    assertEquals("Largeur par défaut", Cercle.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", Cercle.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPoint() {
    Cercle cercle = new Cercle(new Point(7.5, 3.8));
    assertEquals("X", 7.5, cercle.getX(), DELTA);
    assertEquals("Y", 3.8, cercle.getY(), DELTA);
    assertEquals("Largeur par défaut", Cercle.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", Cercle.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPointDimentions() {
    Cercle cercle = new Cercle(new Point(7.5, 3.8), 12);
    assertEquals("X", 7.5, cercle.getX(), DELTA);
    assertEquals("Y", 3.8, cercle.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, cercle.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 12, cercle.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurDimensions() {
    Cercle cercle = new Cercle(12);
    assertEquals("X", 0, cercle.getX(), DELTA);
    assertEquals("Y", 0, cercle.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, cercle.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 12, cercle.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeur4doubles() {
    Cercle cercle = new Cercle(1, 1, 12);
    assertEquals("X", 1, cercle.getX(), DELTA);
    assertEquals("Y", 1, cercle.getY(), DELTA);
    assertEquals("Largeur par défaut", 12, cercle.getLargeur(), DELTA);
    assertEquals("Hauteur par défaut", 12, cercle.getHauteur(), DELTA);
  }

  @Test
  public void testSetters() {
    Cercle cercle = new Cercle();
    cercle.setHauteur(12);
    cercle.setPosition(new Point(14, 32));
    assertEquals("hauteur", 12, cercle.getHauteur(), DELTA);
    assertEquals("largeur", 12, cercle.getLargeur(), DELTA);
    assertEquals("X", 14, cercle.getX(), DELTA);
    assertEquals("Y", 32, cercle.getY(), DELTA);
    cercle.setX(32);
    cercle.setY(14);
    assertEquals("X", 32, cercle.getX(), DELTA);
    assertEquals("Y", 14, cercle.getY(), DELTA);

    cercle.setLargeur(95);
    assertEquals("hauteur", 95, cercle.getHauteur(), DELTA);
    assertEquals("largeur", 95, cercle.getLargeur(), DELTA);
  }

  @Test(expected = Exception.class)
  public void testSettersNegatifs() {
    Cercle cercle = new Cercle();
    cercle.setHauteur(-12);
    assertEquals("hauteur", 12, cercle.getHauteur(), DELTA);
    assertEquals("largeur", 12, cercle.getLargeur(), DELTA);

    cercle.setLargeur(-14);
    assertEquals("hauteur", 14, cercle.getHauteur(), DELTA);
    assertEquals("largeur", 14, cercle.getLargeur(), DELTA);
  }

  @Test
  public void testAirePerimetre() {
    Cercle cercle = new Cercle();
    cercle.setLargeur(9);
    assertEquals("Aire", Math.PI * Math.pow((9.0 / 2.0), 2), cercle.aire(), DELTA);
    assertEquals("Perimetre", Math.PI * 9, cercle.perimetre(), DELTA);
  }
}
