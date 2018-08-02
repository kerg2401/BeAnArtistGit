package fr.eseo.gpi.beanartist.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
  public static final double DELTA = 1e-7;

  @Test
  public void ConstructeurVide() {
    Point p = new Point();
    assertEquals("X par défaut", 0, p.getX(), DELTA);
    assertEquals("Y par défaut", 0, p.getY(), DELTA);
  }

  @Test
  public void ConstructeurPos() {
    Point p = new Point(-3, 5);
    assertEquals("X = -3", -3, p.getX(), DELTA);
    assertEquals("Y = -5", 5, p.getY(), DELTA);
  }

  @Test
  public void TestSetters() {
    Point p = new Point();
    p.setX(-3);
    p.setY(5);
    assertEquals("set X -3", -3, p.getX(), DELTA);
    assertEquals("set Y -5", 5, p.getY(), DELTA);
  }

  @Test
  public void testToString() {
    Point p = new Point(-3, 5);
    assertEquals("toString", "(-3 , 5)", p.toString());
  }

  @Test
  public void TestdeplacerVers() {
    Point p = new Point(-3, 5);
    p.deplacerVers(0, 0);
    assertEquals("DeplacerVers", new Point(0, 0), p);
  }

  @Test
  public void TestdeplacerDe() {
    Point p = new Point(0, 0);
    p.deplacerDe(-3, 5);
    assertEquals("DeplacerDe", new Point(-3, 5), p);
  }

  @Test
  public void testHashCode() {
    Point p = new Point(-3, 5);
    assertEquals("Hashcode", p.hashCode(), p.hashCode());
  }

  @Test
  public void testEquals() {
    Point p1 = new Point(-3, 5);
    assertTrue("Equals", p1.equals(new Point(-3, 5)));
    assertFalse("notEqualsX", p1.equals(new Point(3, 5)));
    assertFalse("notEqualsY", p1.equals(new Point(-3, -5)));
    assertFalse("notEqualsNull", p1.equals(null));
    assertTrue("Equals this", p1.equals(p1));
  }

}
