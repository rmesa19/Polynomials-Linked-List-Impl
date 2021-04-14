package polynomial;

/**
 * The Class used to represent a term in the polynomial Node Class.
 * Contains two fields coefficient and power.
 */
public class TermNode implements Polynomial {
  private double coefficient;
  private int power;
  private Polynomial rest;

  /**
   * Constructor for Term.
   *
   * @param coefficient the coefficient of the term.
   * @param power       the power of the term.
   */
  public TermNode(double coefficient, int power, Polynomial rest) {
    this.coefficient = coefficient;
    this.power = power;
    this.rest = rest;
  }

  public int getPower() {
    return power;
  }

  @Override
  public Polynomial addTerm(double coefficient, int power) throws IllegalArgumentException {
    //System.out.println("Power being passed is: " + power);
    //System.out.println("Current node degree: " + this.getDegree());
    //System.out.println("Current rest degree: " + rest.getDegree());
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative or decimal");
    } else if (coefficient == 0) {
      return this;
    } else if (power == this.getDegree()) {
      //System.out.println("Comparing if power is equal to degree");
      this.coefficient = this.coefficient + coefficient;
    } else if (power < this.getDegree() && power > rest.getDegree()) {
      //System.out.println("Comparing if power is between this and rest degree");
      //System.out.println("Current node degree: " + this.getDegree());
      //System.out.println("Current rest degree: " + rest.getDegree());
      this.rest = this.rest.addTerm(coefficient, power);
    } else if (power > rest.getDegree()) {
      //System.out.println("Comparing if power is greater than rest degree");System.out.println("Current node degree: " + this.getDegree());
      //System.out.println("Power being passed is: " + power);
      //System.out.println("Current node degree: " + this.getDegree());
      //System.out.println("Current rest degree: " + rest.getDegree());
      return addFunction(coefficient, power, this);
    } else if (power < rest.getDegree()) {
      //System.out.println("Utilized: power < rest.getDegree(); to add term");
      this.rest = this.rest.addTerm(coefficient, power);
    } else if (true) {
      this.rest = this.rest.addTerm(coefficient, power);
    }
    return this;
  }

  /**
   * Helper function for addTerm Function.
   *
   * @param coefficient coefficient entered for addTerm.
   * @param power       power entered for addTerm.
   * @param spot        polynomial that represents rest of chain.
   * @return a new TermNode with given power and coefficient.
   */
  private Polynomial addFunction(double coefficient, int power, Polynomial spot) {
    return new TermNode(coefficient, power, spot);
  }

  @Override
  public Polynomial removeTerm(int power) {
    if (this.getDegree() == power) {
      return this.rest;
    } else {
      this.rest = this.rest.removeTerm(power);
    }
    return this;
  }

  @Override
  public int getDegree() {
    return this.power;
  }

  /**
   * Method used to retrieve the power of the term.
   *
   * @param power the power associated with the coefficient being searched for.
   * @return the coefficient parameter;
   */
  @Override
  public double getCoefficient(int power) throws IndexOutOfBoundsException {
    if (this.getDegree() < power) {
      throw new IndexOutOfBoundsException(String.format("There is no term with power: " +
          "%d in the polynomial", power));
    }
    if (this.getDegree() == power) {
      return this.coefficient;
    } else {
      return rest.getCoefficient(power);

    }
  }

  @Override
  public double evaluate(double number) {
    return (this.coefficient * Math.pow(number, this.power)) + rest.evaluate(number);
  }

  @Override
  public Polynomial add(Polynomial otherPoly) throws IllegalArgumentException {
    return this;

  }

  @Override
  public String toString() {
    if (this.coefficient > 0) {
      String newString = "+".concat(Double.toString(Math.abs(this.coefficient)).concat("x^")
          .concat(Integer.toString(this.power)).concat(" "));
      return newString.concat(rest.toString());
    } else {
      String newString = Double.toString(this.coefficient).concat("x^")
          .concat(Integer.toString(this.power)).concat(" ");
      return newString.concat(rest.toString());
    }
  }
}
