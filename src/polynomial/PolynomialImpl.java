package polynomial;


public class PolynomialImpl implements Polynomial {

  private Polynomial head;

  public PolynomialImpl() {
    head = new ConstantNode(0);
  }


  public PolynomialImpl(String toBeParsed) {

    this.head = new ConstantNode(0);
    if (!toBeParsed.isEmpty()) {
      //System.out.println("Inside of Loop");
      String[] splitTerm = toBeParsed.split(" ");
      //System.out.println("Printing elements in splitTerm");
      for (String s : splitTerm) {
        //System.out.println(s);
        String[] newTermList;
        if (s.contains("x")) {
          //Parse each term to a coefficient and exponent half
          newTermList = s.split("x");
          //System.out.println("Printing terms in newTermList");
          for (String s1 : newTermList) {
            if (s1.contains("+")) {
              s1 = s1.substring(1);
            }
            //System.out.println(s1);
          }
          //System.out.println("Creating Term");
          //Adds the parsed coefficient and exponent into the polynomial list
          this.head = this.head.addTerm(Double.parseDouble(newTermList[0]),
              Integer.parseInt(newTermList[1].substring(1)));
        } else if (!s.contains("x")) {
          //System.out.println(s);
          this.head = this.head.addTerm(Double.parseDouble(s), 0);
        }
      }
    }
  }


  @Override
  public Polynomial addTerm(double coefficient, int power) throws IllegalArgumentException {

    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be less than zero");
    } else {
      head = this.head.addTerm(coefficient, power);

    }
    return this;
  }


  @Override
  public Polynomial removeTerm(int power) {
    this.head = head.removeTerm(power);
    return this;
  }

  @Override
  public int getDegree() {
    return head.getDegree();
  }

  @Override
  public double getCoefficient(int power) throws IndexOutOfBoundsException {
    return head.getCoefficient(power);
  }

  @Override
  public double evaluate(double number) {
    return head.evaluate(number);
  }

  @Override
  public Polynomial add(Polynomial otherPoly) throws IllegalArgumentException {
    String thisFunct = toString();
    //System.out.println("Created calling function string: " + thisFunct);
    String otherFunct = otherPoly.toString();
    //System.out.println("Created insertion function string: " + otherFunct);
    PolynomialImpl newPoly = new PolynomialImpl(thisFunct.concat(otherFunct));
    //System.out.println("Created combined string: " + newPoly);

    return newPoly;
  }

  @Override
  public String toString() {
    //System.out.println(String.format("Head.toString().length is %d", head.toString().length()));
    if (head.toString().length() > 1) {
      if (head.toString().charAt(1) == '-') {
        //System.out.println("First toString() Ledge in Impl Class");
        return head.toString().substring(1);
      } else if (head.toString().charAt(0) == '+') {
        //System.out.println("Second toString() Ledge in Impl Class");
        return head.toString().substring(1);
      } else {
        //System.out.println("Third toString() Ledge in Impl Class");
        return head.toString();
      }
    }
    //System.out.println("Hanging toString() Ledge in Impl Class");
    return head.toString();
  }
}
