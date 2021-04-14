package polynomial;

/**
 * The interface that represents the polynomial class
 */
public interface Polynomial {
  /**
   * Adds a Term to the Polynomial.
   * Throws an exception if negative power is passed.
   */
  Polynomial addTerm(double coefficient, int power) throws IllegalArgumentException;


  /**
   * Removes a term from the polynomial.
   *
   * @return
   */
  Polynomial removeTerm(int power);

  /**
   * Gets the Highest exponent in the polynomial.
   *
   * @return highest exponent in polynomial.
   */
  int getDegree();

  /**
   * Takes a power and returns the coefficient for the term with that power.
   *
   * @return coefficient corresponding to power given.
   */
  double getCoefficient(int power) throws IndexOutOfBoundsException;

  /**
   * Takes a double-precision decimal number and returns a double-precision result.
   *
   * @param number number to be entered into the polynomial for evaluation.
   * @return the answer for the inserted number.
   */
  double evaluate(double number);

  /**
   * Takes another Polynomial object and returns the polynomial obtained
   * by adding the two polynomials. Throws an exception if polynomial entered
   * is not of the same concrete class as function caller.
   *
   * @param otherPoly polynomial of same concrete class as caller.
   * @return
   */
  Polynomial add(Polynomial otherPoly) throws IllegalArgumentException;
  //implemented by adding polynomial to list and sorting.
  //if powers are the same, add coefficients and add new poly to list
  //if powers are different, simply add poly to list.

  /**
   * Prints to console a string representation of the Polynomial.
   *
   * @return a string representation of the polynomial;
   */
  String toString();
}
