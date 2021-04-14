package polynomial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PolynomialImplTest {

  PolynomialImpl myList = new PolynomialImpl();


  @Test(expected = IllegalArgumentException.class)
  public void addTerm() {

    System.out.println(myList.toString());
    myList.addTerm(3, 1);
    assertEquals(myList.toString(), "3.0x^1 ");
    myList.addTerm(5, 1);
    assertEquals(myList.toString(), "8.0x^1 ");
    myList.addTerm(5, 2);
    assertEquals(myList.toString(), "5.0x^2 +8.0x^1 ");
    myList.addTerm(5, 5);
    assertEquals(myList.toString(), "5.0x^5 +5.0x^2 +8.0x^1 ");
    myList.addTerm(5, 4);
    myList.addTerm(0, 4);
    assertEquals(myList.toString(), "5.0x^5 +5.0x^4 +5.0x^2 +8.0x^1 ");
    myList.addTerm(2, -1);
    myList.addTerm(2, 0);
    assertEquals(myList.toString(), "5.0x^5 +5.0x^4 +5.0x^2 +8.0x^1 +2 ");
    myList.addTerm(-2, 0);
    assertEquals(myList.toString(), "5.0x^5 +5.0x^4 +5.0x^2 +8.0x^1 ");

  }

  @Test
  public void removeTerm() {

    myList.addTerm(5, 0);
    myList.addTerm(5, 1);
    myList.addTerm(5, 2);
    myList.addTerm(5, 5);
    myList.removeTerm(6);
    assertEquals(myList.toString(), "5.0x^5 +5.0x^2 +5.0x^1 +5.0");
    myList.removeTerm(5);
    assertEquals(myList.toString(), "5.0x^2 +5.0x^1 +5.0");
    myList.removeTerm(0);
    assertEquals(myList.toString(), "5.0x^2 +5.0x^1 ");
    myList.removeTerm(-2);
  }

  @Test
  public void getDegree() {

    myList.addTerm(3, 0);
    assertEquals(myList.getDegree(), 0);
    myList.addTerm(3, 2);
    assertEquals(myList.getDegree(), 2);
    myList.addTerm(3, 3);
    assertEquals(myList.getDegree(), 3);


  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getCoefficient() {

    PolynomialImpl otherList = new PolynomialImpl("-5x^1 -3x^2 2x^1 -7");
    assertEquals(otherList.toString(), "-3.0x^2 -3.0x^1 -7.0");
    PolynomialImpl nextList = new PolynomialImpl("-5x^1 3x^2 2x^1");
    assertEquals(nextList.toString(), "3.0x^2 -3.0x^1 ");
    assertEquals(otherList.getCoefficient(2), -3.0, .01);
    assertEquals(otherList.getCoefficient(0), -7.0, .01);
    otherList.getCoefficient(6);

  }

  @Test
  public void evaluate() {

    myList.addTerm(5, 1);
    myList.addTerm(5, 2);
    myList.addTerm(-5, 5);
    myList.addTerm(-5, 7);
    // System.out.println(myList.toString());
    assertEquals(myList.evaluate(6), -1438350.0, .01);
    assertEquals(myList.evaluate(-5), 406350.0, .01);
    assertEquals(myList.evaluate(.7), 4.6978785, .01);
    assertEquals(myList.evaluate(-.7), 0.2021214999999993, .01);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add() throws IllegalArgumentException {

    PolynomialImpl otherList = new PolynomialImpl("-5x^1 -3x^2 2x^1 4x^8 3x^-5");
    System.out.println(myList.add(otherList).toString());
    myList.addTerm(5, -1);
    myList.addTerm(5, 2);
  }

  @Test
  public void testToString() {

    myList.addTerm(5, 1);
    assertEquals(myList.toString(), "5.0x^1 ");
    myList.addTerm(5, 2);
    assertEquals(myList.toString(), "5.0x^2 +5.0x^1 ");
    myList.addTerm(-5, 5);
    assertEquals(myList.toString(), "-5.0x^5 +5.0x^2 +5.0x^1 ");
    myList.addTerm(-5, 7);
    assertEquals(myList.toString(), "-5.0x^7 -5.0x^5 +5.0x^2 +5.0x^1 ");
    myList.addTerm(0, 0);
    assertEquals(myList.toString(), "-5.0x^7 -5.0x^5 +5.0x^2 +5.0x^1 ");

  }
}