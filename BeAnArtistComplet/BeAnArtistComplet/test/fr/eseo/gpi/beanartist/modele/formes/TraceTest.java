package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class TraceTest {
  public static final double DELTA = 1e-5;

  @Test
  public void testConstructeurVide() {
    Trace trace = new Trace();
    assertEquals("Px", 0, trace.getX(), DELTA);
    assertEquals("Py", 0, trace.getY(), DELTA);
    assertEquals("Largeur", 0, trace.getLargeur(), DELTA);
    assertEquals("Hauteur", 0, trace.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPoint() {
    Trace trace = new Trace(new Point(7.5, 3.8));
    assertEquals("Px", 7.5, trace.getX(), DELTA);
    assertEquals("Py", 3.8, trace.getY(), DELTA);
    assertEquals("Largeur", 0, trace.getLargeur(), DELTA);
    assertEquals("Hauteur", 0, trace.getHauteur(), DELTA);
  }

  @Test
  public void testConstructeurPointPoint() {
    Trace trace = new Trace(new Point(7, 3), new Point(-7, 6));
    assertEquals("Px", -7, trace.getX(), DELTA);
    assertEquals("Py", 3, trace.getY(), DELTA);
    assertEquals("Hauteur", 3, trace.getHauteur(), DELTA);
    assertEquals("Largeur", 14, trace.getLargeur(), DELTA);

  }

  @Test
  public void testSetterX() {
    Trace trace = new Trace();
    trace.ajouterPoint(new Point(5, 5));
    trace.ajouterPoint(new Point(-5, 10));

    trace.setX(0);
    assertEquals(new Point(5, 0), trace.getPoints().get(0));
    assertEquals(new Point(10, 5), trace.getPoints().get(1));
    assertEquals("P2", new Point(0, 10), trace.getPoints().get(2));
  }
  
  @Test
  public void testSetterY() {
    Trace trace = new Trace();
    trace.ajouterPoint(new Point(5, 5));
    trace.ajouterPoint(new Point(-5, 10));
    
    trace.setY(5);
    assertEquals("P0", new Point(0, 5), trace.getPoints().get(0));
    assertEquals("P1", new Point(5, 10), trace.getPoints().get(1));
    assertEquals("P2", new Point(-5, 15), trace.getPoints().get(2));
  }

  @Test
  public void testSettersNegatifs() {
    Trace trace = new Trace();
    trace.ajouterPoint(new Point(5, 5));
    trace.ajouterPoint(new Point(-5, 10));

    trace.setX(0);
    assertEquals(new Point(5, 0), trace.getPoints().get(0));
    assertEquals(new Point(10, 5), trace.getPoints().get(1));
    assertEquals("P2", new Point(0, 10), trace.getPoints().get(2));

    trace.setY(-5);
    assertEquals("P0", new Point(5, -5), trace.getPoints().get(0));
    assertEquals("P1", new Point(10, 0), trace.getPoints().get(1));
    assertEquals("P2", new Point(0, 5), trace.getPoints().get(2));
  }

  @Test
  public void testAirePerimetre() {
    Trace trace = new Trace();
    trace.ajouterPoint(new Point(5, 5));
    trace.ajouterPoint(new Point(10, 10));
    assertEquals("Aire", 0, trace.aire(), DELTA);
    assertEquals("Perimetre", Math.sqrt(200), trace.perimetre(), DELTA);
  }

  @Test
  public void testContientDouble() {
    Trace trace = new Trace(new Point(), new Point(2, 2));
    assertTrue("Contient", trace.contient(1, 1));
    assertFalse("Contient", trace.contient(3, 1));
  }

  @Test
  public void testContientPoint() {
    Trace trace = new Trace(new Point(), new Point(10, 10));
    assertTrue("Contient", trace.contient(new Point(5, 5)));
    assertFalse("Contient", trace.contient(new Point(5, 7)));
  }

  @Test
  public void testSetHauteur() {
    Trace trace = new Trace(new Point(1, 1), new Point(3, 1));
    trace.ajouterPoint(new Point(2, 4));
    assertEquals("Hauteur de départ", 3, trace.getHauteur(), DELTA);
    trace.setHauteur(6);
    assertEquals("Hauteur finale", 6, trace.getHauteur(), DELTA);
    assertEquals("p3 y", new Point(2, 7), trace.getPoints().get(2));
  }

  @Test
  public void testSetLargeur() {
    Trace trace = new Trace(new Point(1, 1), new Point(3, 1));
    trace.ajouterPoint(new Point(2, 4));
    assertEquals("Largeur de départ", 2, trace.getLargeur(), DELTA);
    trace.setLargeur(4);
    assertEquals("Largeur finale", 4, trace.getLargeur(), DELTA);
    assertEquals("p3 y", new Point(3, 4), trace.getPoints().get(2));
  }

  @Test
  public void testFinalTrace() {
    Trace t = new Trace(new Point(182.5, 100)); // Pentagone régulier
    t.ajouterPoint(new Point(33.256, 51.508));
    t.ajouterPoint(new Point(125.494, 178.462));
    t.ajouterPoint(new Point(125.494, 21.538));
    t.ajouterPoint(new Point(33.256, 148.492));
    t.ajouterPoint(new Point(182.5, 100));

    t.setHauteur(1.519);
    assertEquals("Hauteur", 1.519, t.getHauteur(), DELTA);
    assertEquals("Point de départ", 21.538, t.getY(), DELTA);

    assertEquals("Premier point", 22.2975, t.getPoints().get(0).getY(), DELTA);
  }

  @Test
  public void testToString() {
    Trace trace = new Trace(new Point(), new Point(0, 2));
    assertEquals("toString", "[Trace] pos : (0 , 0) dim : 0 x 2 longueur : 2 nbSegments : 1",
        trace.toString());
  }

  @Test
  public void testGetCadreMinMaxXY() {
    Trace trace = new Trace(new Point(-10, -10), new Point(10, 10));
    assertEquals("CadreMinX", -10, trace.getCadreMinX(), DELTA);
    assertEquals("CadreMaxX", 10, trace.getCadreMaxX(), DELTA);
    assertEquals("CadreMinY", -10, trace.getCadreMinY(), DELTA);
    assertEquals("CadreMaxY", 10, trace.getCadreMaxY(), DELTA);
  }

  @Test
  public void testSetPosition() {
    Trace trace = new Trace(new Point(-10, -10), new Point(10, 10));
    trace.setPosition(new Point(0, 0));
    assertEquals("Position", new Point(0, 0), trace.getPosition());
    assertEquals("Point 0", new Point(0, 0), trace.getPoints().get(0));
    assertEquals("Point 1", new Point(20, 20), trace.getPoints().get(1));
  }

  @Test
  public void testDeplacerVers() {
    Trace trace = new Trace(new Point(-10, -10), new Point(10, 10));
    trace.deplacerVers(0, 0);
    assertEquals("Position", new Point(0, 0), trace.getPosition());
    assertEquals("Point 0", new Point(0, 0), trace.getPoints().get(0));
    assertEquals("Point 1", new Point(20, 20), trace.getPoints().get(1));
  }

  @Test
  public void TestCouleurs() {
    Trace trace = new Trace();
    trace.setCouleurLigne(Color.red);
    assertEquals("CouleurLigne", Color.red, trace.getCouleurLigne());
  }
}
