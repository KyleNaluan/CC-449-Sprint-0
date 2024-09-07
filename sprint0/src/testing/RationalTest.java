package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class RationalTest {

  @Test
  public void oneFourthPlusOneHalfShouldBeThreeFourths() {
    Rational num1 = new Rational(1, 4);
    Rational num2 = new Rational(1, 2);
    Rational sum = num1.plus(num2);

    assertTrue(sum.equals(new Rational(3, 4)));
  }

  @Test
  public void oneHalfReciprocalShouldBeTwo() {
    Rational num1 = new Rational(1, 2);
    Rational recip = num1.getReciprocal();

    assertTrue(recip.equals(new Rational(2)));
  }

  @Test
  public void twoTimesTwoShouldBeFour() {
    Rational num1 = new Rational(2);
    Rational num2 = new Rational(2);
    Rational sum = num1.multiply(num2);

    assertTrue(sum.equals(new Rational(4)));
  }

  @Test
  public void negativeTwoTimesTwoShouldBeNegativeFour() {
    Rational num1 = new Rational(2);
    Rational num2 = new Rational(-2);
    Rational sum = num1.multiply(num2);

    assertTrue(sum.equals(new Rational(-4)));
  }

  @Test
  public void oneDividedByTwoShouldBeOneHalf() {
    Rational num1 = new Rational(1);
    Rational num2 = new Rational(2);
    Rational quotient = num1.divide(num2);

    assertTrue(quotient.equals(new Rational(1, 2)));
  }

  @Test
  public void oneMinusSixShouldBeNegativeFive() {
    Rational num1 = new Rational(1);
    Rational num2 = new Rational(6);
    Rational difference = num1.minus(num2);

    assertTrue(difference.equals(new Rational(-5)));
  }

}
