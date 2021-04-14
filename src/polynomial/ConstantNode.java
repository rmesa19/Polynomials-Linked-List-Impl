package polynomial;

/**
 * The Class used to represent a constant in the polynomial Node Class.
 * Contains constant field.
 */
public class ConstantNode implements Polynomial {

  private double constant;

  /**
   * Constructor for Term.
   *
   * @param constant the constant for the polynomial.
   */
  ConstantNode(double constant) {
    this.constant = constant;
  }

  /**
   * Adds a term to the polynomial chain.
   *
   * @param coefficient coefficient to be entered.
   * @param power       power for the term.
   * @throws IllegalArgumentException if power is negative.
   */
  @Override
  public Polynomial addTerm(double coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be less than zero");
    } else if (power == 0) {
      //System.out.println("Adding Via Constant Node: power == 0");
      this.constant = this.constant + coefficient;
      return this;
    } else if (power >= 1) {
      //System.out.println("Adding Via Constant Node");
      //System.out.println("Power just passed in is: " + power);
      return addFunction(coefficient, power, this);
    }
    //System.out.println("Adding Via Constant Node: final dump");
    this.constant = this.constant + coefficient;
    return this;
  }

  private Polynomial addFunction(double coefficient, int power, Polynomial spot) {
    return new TermNode(coefficient, power, this);
  }

  @Override
  public Polynomial removeTerm(int power) {
    if (power == 0) {
      this.constant = 0;
      return this;
    } else {
      return this;
    }
  }


  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public double getCoefficient(int power) throws IndexOutOfBoundsException {
    return this.constant;
  }

  @Override
  public double evaluate(double number) {
    return this.constant;
  }

  @Override
  public Polynomial add(Polynomial otherPoly) throws IllegalArgumentException {
    return this;
  }

  @Override
  public String toString() {
    if (this.constant > 0) {
      String newString = "+".concat(Double.toString(this.constant));
      return newString;
    } else if (this.constant < 0) {
      String newString = "-".concat(Double.toString(Math.abs(this.constant)));
      return newString;
    } else {
      String newString = "";
      return newString;
    }
  }
}
