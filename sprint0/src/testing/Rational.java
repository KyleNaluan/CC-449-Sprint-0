package testing;

/**
 * Represents a Rational number in Mathematics. When a Rational is created it
 * will always be reduced to simplest form.
 */
public class Rational {

  private int num;
  private int denom;

  public Rational(int num, int denom) {
    this.num = num;
    this.denom = denom;

    this.reduce();
  }

  public Rational(int num) {
    this.num = num;
    this.denom = 1;
  }

  /**
   * Reduces this Rational's numerator and denominator to the simplest form using
   * the GCD.
   */
  private void reduce() {
    // Need the GCD of numerator and denominator.
    int gcd = this.getGCD(this.num, this.denom);

    // Reduce the Rational
    this.num /= gcd;
    this.denom /= gcd;

    // Move negative to numerator
    if (this.denom < 0) {
      this.num *= -1;
      this.denom *= -1;
    }
  }

  /**
   * Returns the greatest commond divisor (GCD) of the two given numbers. The GCD
   * is the highest number that divides both of the given values.
   */
  private int getGCD(int a, int b) {
    // Find minimum of the two
    int max = a;
    if (b > a) {
      max = b;
    }

    // Start at minimum, work down to 1, thus first factor
    // found is the GCD.
    for (int i = max; i > 1; i--) {
      // Check if divides both
      if (a % i == 0 && b % i == 0) {
        return i;
      }
    }

    // No factor found, return 1
    return 1;
  }

  public Rational getNegative() {
    int negativeNum = this.num * -1;

    return new Rational(negativeNum, this.denom);
  }

  public int getNum() {
    return this.num;
  }

  public int getDenom() {
    return this.denom;
  }

  public boolean isNegative() {
    if ((this.num / this.denom) < 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isZero() {
    if (this.num == 0) {
      return true;
    } else {
      return false;
    }
  }

  public Rational getReciprocal() {
    int recNum = this.denom;
    int recDenom = this.num;

    Rational reciprocal = new Rational(recNum, recDenom);

    return reciprocal;

  }

  public Rational plus(Rational a) {

    int num1 = this.num * a.denom;
    int num2 = a.num * this.denom;
    int combinedNum = num1 + num2;
    int denom = this.denom * a.denom;

    Rational sum = new Rational(combinedNum, denom);
    return sum;

  }

  public Rational minus(Rational a) {
    int num1 = this.num * a.denom;
    int num2 = a.num * this.denom;
    int combinedNum = num1 - num2;
    int denom = this.denom * a.denom;

    Rational difference = new Rational(combinedNum, denom);
    return difference;

  }

  public Rational multiply(Rational a) {

    int productNum = this.num * a.num;
    int productDenom = this.denom * a.denom;

    Rational product = new Rational(productNum, productDenom);

    return product;

  }

  public Rational divide(Rational a) {

    Rational reciprocal = a.getReciprocal();

    int quotientNum = this.num * reciprocal.num;
    int quotientDenom = this.denom * reciprocal.denom;

    Rational quotient = new Rational(quotientNum, quotientDenom);

    return quotient;

  }

  public boolean equals(Rational a) {

    if ((this.num == a.num) && (this.denom == a.denom)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns a String representation of the Rational in simplest form. If the
   * denominator is 1, then this returns a whole number. If the Rational is equal
   * to zero, then this returns zero. Otherwise, the Rational is shown in simplest
   * form with the negative sign out front if the Rational is negative.
   */
  @Override
  public String toString() {
    if (this.num / this.denom > 0) {
      if (this.denom == 1) {
        return "" + this.num;
      } else {
        return this.num + "/" + this.denom;
      }
    } else {
      if (this.denom == -1) {
        return "-" + this.num;
      } else if (this.denom == 1) {
        return "" + this.num;
      } else if (this.denom < 0) {
        return "-" + this.num + "/" + (this.denom * -1);
      } else {
        return this.num + "/" + this.denom;
      }
    }
  }

}
